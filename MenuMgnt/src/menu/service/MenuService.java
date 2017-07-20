package menu.service;

import java.util.List;

import menu.domain.Menu;

public interface MenuService {
	
	int menuCreate(Menu menu);
	Menu menuFind(String code);
	List<Menu> findAll();
}
