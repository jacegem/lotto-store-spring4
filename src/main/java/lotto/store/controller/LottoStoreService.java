package lotto.store.controller;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service("LottoStoreService")
public class LottoStoreService {

	//create ObjectMapper instance
	ObjectMapper objectMapper = new ObjectMapper();
	
	Map<String, String> sidoMap = new HashMap<String, String>() {{ 
		put("충북", "충청북도"); 
		put("충남", "충청남도"); 
		put("전북", "전라북도"); 
		put("전남", "전라남도"); 
		put("경북", "경상북도"); 
		put("경남", "경상남도"); 
		put("세종", "세종특별자치시"); 
	}};
	//Read more: http://www.java67.com/2016/01/how-to-initialize-hashmap-with-values-in-java.html#ixzz4E5iDh1Gh
	
	//String[] sidos = {"서울", "경기", "부산", "대구", "인천", "대전", "울산", "강원", "충북", "충남", "광주", "전북", "전남", "경북", "경남", "제주", "세종"};
	String[] sidos = {"세종"};
	List<String> sidoList = new ArrayList<String>(){{
		addAll(Arrays.asList(sidos));
	}};


	
	public String getMessage() {
		return "msg from service";
	}

	public void save() throws Exception {
		List<LottoStore> lottoStore = new ArrayList<LottoStore>();
		
		for(String sido : sidoList){
			List<String> gugunList = getGugunList(sido);
			List<LottoStore> storeList = getStoreList(sido, gugunList);
			lottoStore.addAll(storeList);
		}
		
		
		
		ofy().save().entities(lottoStore).now();

	}

	private List<LottoStore> getStoreList(String sido, List<String> gugunList) throws Exception {
		List<LottoStore> lottoStore = new ArrayList<LottoStore>();
		
		for (String gugun : gugunList){
			String encSido = URLEncoder.encode(sido, "EUC-KR");
			String encGugun = "";
			if (gugun != null)
				encGugun = URLEncoder.encode(gugun, "EUC-KR");
			
			int page = 1;
			while(true){
				System.out.println(String.format("SIDO:%s\tGUGUN:%s\tPAGE:%d", sido, gugun, page));
				String url  = "http://nlotto.co.kr/game.do?method=sellerInfo645Result&searchType=1&" 
						+ "nowPage=" + page + "&sltSIDO=" + encSido + "&sltGUGUN=" + encGugun;
				String content = getUrlContents(url);
				//convert json string to object
				LottoStoreList list = objectMapper.readValue(content, LottoStoreList.class);
				lottoStore.addAll(list.storeList);
				if (list.pageEnd <= page) break;
				else page++;					
			}			
		}
		
		
		return lottoStore;
	}

	private List<String> getGugunList(String sido) throws Exception {
		String searchGugunUrl = "http://nlotto.co.kr/lotto645Stat.do?method=searchGUGUN&SIDO=";
		
		if (sidoMap.containsKey(sido))
			sido = sidoMap.get(sido);
		
		String encodeSido = URLEncoder.encode(sido, "EUC-KR");
		String url = searchGugunUrl.concat(encodeSido);
		String content = getUrlContents(url);

		//create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();
		
		//convert json string to object
		List<String> list = objectMapper.readValue(content, new TypeReference<List<String>>(){});
		
		return list;
	}

	private static String getUrlContents(String theUrl) {
		StringBuilder content = new StringBuilder();

		// many of these calls can throw exceptions, so i've just
		// wrapped them all in one try/catch statement.
		try {
			// create a url object
			URL url = new URL(theUrl);

			// create a urlconnection object
			URLConnection urlConnection = url.openConnection();

			// wrap the urlconnection in a bufferedreader
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(urlConnection.getInputStream(), "EUC-KR"));

			String line;

			// read from the urlconnection via the bufferedreader
			while ((line = bufferedReader.readLine()) != null) {
				content.append(line + "\n");
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content.toString();
	}

}
