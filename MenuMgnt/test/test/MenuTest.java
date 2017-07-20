package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import menu.domain.Menu;
import menu.store.MenuStore;
import menu.store.MenuStoreLogic;

public class MenuTest {
	
	MenuStore store = new MenuStoreLogic();
	
	@Test
	public void menuCreateTest(){
		Menu menu = new Menu();
		menu.setCode("M02");
		menu.setName("참치김밥");
		menu.setUrl("ww");
		menu.setDisplay(1);
		int check = store.menuCreate(menu);
		System.out.println(check);
		assertEquals(1, check);
	}
	
	@Test
	public void menuSelect(){
		Menu menu = store.menuFind("M02");
		System.out.println(menu.getDisplay());
		System.out.println(menu.getName());
	}

}
