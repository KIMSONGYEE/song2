package menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import menu.domain.Menu;
import menu.service.MenuService;

@Controller
public class MenuController {
	
	@Autowired
	private MenuService service;
	
	@RequestMapping("/codeCheck.do")
	@ResponseBody
	public boolean codeCheck(String code){
		System.out.println(code);
		Menu menu = service.menuFind(code);
		if (menu == null) {
			return true;
		}
		return false;
	}

	@RequestMapping("/menuCreate.do")
	@ResponseBody
	public boolean menuCreate(String code, String name, String display, String url){
		System.out.println(code+","+name+","+display+","+url);
		Menu menu = new Menu();
		menu.setCode(code);
		menu.setName(name);
		menu.setDisplay(Integer.parseInt(display));
		menu.setUrl(url);
		
		int check = service.menuCreate(menu);
		
		if (check == 1) {
			return true;
		}
		return false;
	}
	
	@RequestMapping("/findAll.do")
	public String findAll(Model model){
		List<Menu> menus = service.findAll();
		model.addAttribute("menus", menus);
		return "/views/menuList.jsp";
	}
}
