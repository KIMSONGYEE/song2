package menu.store;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import menu.domain.Menu;
import menu.store.mapper.MenuMapper;

@Repository
public class MenuStoreLogic implements MenuStore {

	@Override
	public int menuCreate(Menu menu) {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("MyBatis 설정파일 오류");
		}
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = factory.openSession(true);
		
		MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);
		int check = mapper.menuCreate(menu);
		
		sqlSession.close();
		return check;
	}

	@Override
	public Menu menuFind(String code) {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("MyBatis 설정파일 오류");
		}
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = factory.openSession(true);
		
		MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);
		Menu menu = mapper.menuFind(code);
		sqlSession.close();
		return menu;
	}

	@Override
	public List<Menu> findAll() {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("MyBatis 설정파일 오류");
		}
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = factory.openSession(true);
		
		MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);
		List<Menu> menus = mapper.findAll();
		sqlSession.close();
		return menus;
	}

}
