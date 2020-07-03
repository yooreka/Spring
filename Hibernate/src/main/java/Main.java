import java.sql.Connection;

import javax.sql.DataSource;
import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import hibernate.dao.ItemDAO;
import hibernate.dao.TransactionDAO;

public class Main {

	public static void main(String[] args) {
		try {
			// 스프링설정 파일의 경로를 설정
			GenericXmlApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
			// 데이터베이스 접속 정보 가져와서 접속이 되는지 테스트
			/*DataSource ds = context.getBean(DataSource.class);
			Connection con = ds.getConnection();
			System.out.println(con);*/
			
			//DAO 인스턴스를 가져와서 삽입하는 메소드 호출
			//TransactionDAO dao = context.getBean(TransactionDAO.class);
			//dao.insert();
			
			//hibernate 설정 확인
			/*SessionFactory sessionFactory = context.getBean(SessionFactory.class);
			System.out.println(sessionFactory);*/
			
			ItemDAO itemDAO = context.getBean(ItemDAO.class);
			//itemDAO.list();
			//itemDAO.insert();
			itemDAO.getItem();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
