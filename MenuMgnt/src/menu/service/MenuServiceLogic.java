package menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import menu.domain.Menu;
import menu.store.MenuStore;

@Service
public class MenuServiceLogic implements MenuService {

	@Autowired
	private MenuStore store;
	
	@Override
	public int menuCreate(Menu menu) {
		int check = store.menuCreate(menu);
		return check;
	}

	@Override
	public Menu menuFind(String code) {
		Menu menu = store.menuFind(code);
		return menu;
	}

	@Override
	public List<Menu> findAll() {
		List<Menu> menus = store.findAll();
		return menus;
	}

}
