package covid.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import covid.model.CovidModel;
import covid.model.PostModel;
import covid.model.PreventionModel;
import covid.repo.PreventionRepo;
import covid.services.CovidApiService;
import covid.services.PostService;
import covid.utility.FileUtility;

@Controller
public class MainController {
	@Autowired
	CovidApiService covidService;

	@Autowired
	PostService postService;

	@Autowired
	PreventionRepo preventionRepo;
	
	@GetMapping("/")
	public String home(Model model) {
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String index(@RequestParam(defaultValue="") String country, Model model) {
		CovidModel covid = new CovidModel();
		
		if (country.equalsIgnoreCase("")) {
			covid = covidService.getCovidModel("world");
		} else {
			covid = covidService.getCovidModel(country);			
		}
		
		List<CovidModel> listCovid = covidService.getAllCovidModel();
		model.addAttribute("postModel", new PostModel());
		model.addAttribute("listCovidResponse", listCovid);
		model.addAttribute("covidResponse", covid);		
		
		return "index";
	}
	
	@PostMapping("/")
	public String inputModel(@ModelAttribute PostModel postModel) {
		PostModel response = postService.inputModel(postModel);
		return "redirect:/";
	}
	
	@GetMapping("/countries")
	public String countries(Model model) {
		return "countries";
	}
	
	@GetMapping("/faqs")
	public String faqs(Model model) {
		List<PreventionModel> listModel = preventionRepo.findAll();
		model.addAttribute("listModel", listModel);
		model.addAttribute("preventionModel", new PreventionModel());
		return "faqs";
	}
	
	@PostMapping("/faqs")
	public String inputFaq(
			@ModelAttribute("preventionModel") PreventionModel data,
			Model model,
			@RequestParam("file") MultipartFile file) throws IOException {
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		String uploadDir = "prevention-image/";
		
		FileUtility.saveFile(file, uploadDir, fileName);
		data.setImage("prevention-image/" + fileName);
		this.preventionRepo.save(data);
		
		return "redirect:/faqs";
	}
	
	@GetMapping("/prevention")
	public String prevention(Model model) {
		List<PreventionModel> listModel = preventionRepo.findAll();
		model.addAttribute("listModel", listModel);
		return "prevention";
	}
	
	@GetMapping("/symptoms")
	public String symptoms(Model model) {
		return "symptoms";
	}
	
	@GetMapping("/prevention/input")
	public String getInputPrevention(Model model) {
		model.addAttribute("preventionModel", new PreventionModel());
		return "input_prevention";
	}
	
	@PostMapping("/prevention/input")
	public String inputPrevention(
			@ModelAttribute("preventionModel") PreventionModel data,
			Model model,
			@RequestParam("file") MultipartFile file) throws IOException {
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		String uploadDir = "prevention-image/";
		
		FileUtility.saveFile(file, uploadDir, fileName);
		data.setImage("prevention-image/" + fileName);
		this.preventionRepo.save(data);
		
		return "redirect:/prevention/input";
	}
}
