package autosuggest.service;

import java.util.List;

import autosuggest.domain.SearchWord;

public interface SearchService {
	
	List<SearchWord> findWord(String keyword);
}
