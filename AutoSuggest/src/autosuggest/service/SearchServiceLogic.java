package autosuggest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import autosuggest.domain.SearchWord;
import autosuggest.store.SearchStore;

@Service
public class SearchServiceLogic implements SearchService {

	@Autowired
	private SearchStore store;
	
	@Override
	public List<SearchWord> findWord(String keyword) {
		List<SearchWord> words = store.findWord(keyword);
		return words;
	}

}
