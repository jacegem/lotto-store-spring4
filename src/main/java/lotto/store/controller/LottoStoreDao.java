package lotto.store.controller;

import org.springframework.stereotype.Repository;

import com.googlecode.objectify.ObjectifyService;

@Repository("LottoStoreDao")
public class LottoStoreDao {


	public String getMessage() {
		// TODO Auto-generated method stub
		return "message from dao";
	}

	public LottoStore getStoreFromDatastore() {
		LottoStore ls = new LottoStore();
		return ls;
	}

	public void save() {
		// TODO Auto-generated method stub
		// 정보를 가져와서
		// 저장한다.	
		LottoStore ls = new LottoStore();	
		ls.setName("name is...");
		ObjectifyService.ofy().save().entity(ls).now();
	}

}
