package autosuggest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import autosuggest.domain.SearchWord;
import autosuggest.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	private SearchService servivce;
	
	@RequestMapping("/serach.do")
	@ResponseBody
	public List<SearchWord> search(String keyword){
		List<SearchWord> words = servivce.findWord(keyword);
		
		return words;
	}
	
}
