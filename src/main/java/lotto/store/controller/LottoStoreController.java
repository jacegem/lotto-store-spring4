package lotto.store.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/lotto/store")
public class LottoStoreController {
	String prefix = "lotto/store/";
	
	@Autowired()
	LottoStoreService service;
	
	@RequestMapping(value = "/list")
	public String getAddCustomerPage(ModelMap model) {
		String msg = service.getMessage();
		System.out.println(msg);
		return prefix + "list";
	}
	
	@RequestMapping(value = "/save")
	public String save(ModelMap model) throws Exception {
		service.save();
		return prefix + "list";
	}
	
	@RequestMapping(value = "/json")
	public @ResponseBody List<LottoStore> getJson(ModelMap model) {
		List<LottoStore> list = new ArrayList<LottoStore>(); 
		return list;
	}
	
	@RequestMapping(value = "/map")
	@ResponseBody
	public Map<String, String> getMap(ModelMap model) {
		Map<String, String> resultMap = new HashMap<String, String>();
		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/sample")
	public AjaxResponseBody getSampleJson(ModelMap model){
		AjaxResponseBody result = new AjaxResponseBody();
		//logic 
		result.code ="ajax코드";
		result.msg = "ajax메시지";
				
		return result;
	} 
}
