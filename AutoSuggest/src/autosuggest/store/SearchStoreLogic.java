package autosuggest.store;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import autosuggest.domain.SearchWord;
import autosuggest.store.mapper.SearchMapper;

@Repository
public class SearchStoreLogic implements SearchStore {

	@Override
	public List<SearchWord> findWord(String keyword) {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("MyBatis 설정파일 오류");
		}
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = factory.openSession(true);

		SearchMapper mapper = sqlSession.getMapper(SearchMapper.class);
		List<SearchWord> words = mapper.findWord("%"+keyword+"%");
		
		sqlSession.close();
		return words;
	}

}
