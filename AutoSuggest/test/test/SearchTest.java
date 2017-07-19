package test;

import java.util.List;

import org.junit.Test;

import autosuggest.domain.SearchWord;
import autosuggest.store.SearchStore;
import autosuggest.store.SearchStoreLogic;

public class SearchTest {

	SearchStore store = new SearchStoreLogic();
	
	@Test
	public void test(){
		List<SearchWord> words = store.findWord("호빵");
		System.out.println(words.size());
		for (SearchWord searchWord : words) {
			System.out.println(searchWord.getWord());
		}
	}
}
