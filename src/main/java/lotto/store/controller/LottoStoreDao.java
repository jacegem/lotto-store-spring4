package lotto.store.controller;



import org.springframework.stereotype.Component;

@Component
public class LottoStoreDao {

	public String getMessage() {
		// TODO Auto-generated method stub
		return "message from dao";
	}
	
	public LottoStore getStoreFromDatastore(){
		LottoStore ls = new LottoStore();
		return ls;
	}

	public void save() {
		// TODO Auto-generated method stub
		// 정보를 가져와서 
		// 저장한다. 
		
		
	}

}
