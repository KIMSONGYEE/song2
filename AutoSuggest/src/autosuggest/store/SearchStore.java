package autosuggest.store;

import java.util.List;

import autosuggest.domain.SearchWord;

public interface SearchStore {
	List<SearchWord> findWord(String keyword);
}
