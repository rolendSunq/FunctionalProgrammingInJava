package java8.inaction.chapter08.templatemethod;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Database {
	private SqlSession session;

	public Database() {
		setSession();
	}

	private void setSession() {
		try {
			String resource = "config/MyBatisConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			session = sqlMapper.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public SqlSession getSqlSession() {
		return session;
	}
	
	public Customer getCustomerWithId(String id) {
		return session.selectOne("config.SQL.customer.getCustomerById", id);
	}

}
