package lotto.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lotto/store")
public class LottoStoreController {
	String prefix = "lotto/store/";
	
	@RequestMapping(value = "/list")
	public String getAddCustomerPage(ModelMap model) {
		return prefix + "list";
	}
	
	@RequestMapping(value = "/json")
	public String getJson(ModelMap model) {
		return prefix + "list";
	}
}
