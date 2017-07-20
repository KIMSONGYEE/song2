package menu.store.mapper;

import java.util.List;

import menu.domain.Menu;

public interface MenuMapper {
	int menuCreate(Menu menu);
	Menu menuFind(String code);
	List<Menu> findAll();
}
