package menu.store;

import java.util.List;

import menu.domain.Menu;

public interface MenuStore {
	
	int menuCreate(Menu menu);
	Menu menuFind(String code);
	List<Menu> findAll();
}
