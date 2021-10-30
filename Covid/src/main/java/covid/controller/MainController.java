package covid.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@GetMapping("/index")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/countries")
	public String countries(Model model) {
		return "countries";
	}
	
	@GetMapping("/faqs")
	public String faqs(Model model) {
		return "faqs";
	}
	
	@GetMapping("/prevention")
	public String prevention(Model model) {
		return "prevention";
	}
	
	@GetMapping("/symptoms")
	public String symptoms(Model model) {
		return "symptoms";
	}
}
