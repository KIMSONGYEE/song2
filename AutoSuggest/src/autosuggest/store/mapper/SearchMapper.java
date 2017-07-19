package autosuggest.store.mapper;

import java.util.List;

import autosuggest.domain.SearchWord;

public interface SearchMapper {
	List<SearchWord> findWord(String keyword);
}
