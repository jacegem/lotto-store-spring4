package lotto.store.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lotto/store")
public class LottoStoreController {
	String prefix = "lotto/store/";
	
	@RequestMapping(value = "/list")
	public String getAddCustomerPage(ModelMap model) {
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
}
