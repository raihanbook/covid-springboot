package covid.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import covid.model.CovidModel;
import covid.services.CovidApiService;

@Controller
public class MainController {
	@Autowired
	CovidApiService cas;
	
	@GetMapping("/index")
	public String index(Model model) {
		List<CovidModel> listCovid = cas.getAllCovidModel();
		model.addAttribute("listCovidResponse", listCovid);
		
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
