package hibernate.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hibernate.domain.Item;

@Repository
public class ItemDAO {
	@Autowired
//hibernat 사용 객체
	private SessionFactory sessionFactory;

//데이터 삽입
	@Transactional
	public void insert() {
		Item item = new Item();
		item.setCode(3);
		item.setName("문어");
		item.setManufacture("전라");
		item.setPrice(6000);
		item.setBuiltdate(new Date());

		// 데이터 삽입
		sessionFactory.getCurrentSession().save(item);
	}

	// 데이터 수정
	// 기본키로 수정
	@Transactional
	public void update() {
		Item item = new Item();
		item.setCode(2);
		item.setName("낙지");
		item.setManufacture("광주");
		item.setPrice(4000);
		item.setBuiltdate(new Date());

		// 데이터 삽입
		sessionFactory.getCurrentSession().save(item);
	}

	// 데이터 삭제
	@Transactional
	public void delete() {
		Item item = new Item();
		item.setCode(2);

		// 데이터 삭제
		sessionFactory.getCurrentSession().delete(item);

	}

	// 전체 데이터 가져오기
	@Transactional
	public void list() {
	// 전체데이터 가져오기
		List<Item> list = (List<Item>) sessionFactory.getCurrentSession().createCriteria(Item.class).list();
		// 데이터 출력
		for (Item item : list) {
			System.out.println(item);
		
			//SQL사용
	//	List<Item> list = sessionFactory.getCurrentSession().createSQLQuery("select * from item").addEntity(Item.class).list();
		}
	}
	//기본키를 가지고 데이터 1개 가져오기
	@Transactional
	public void getItem() {
		//Criteria 사용
		Item item = sessionFactory.getCurrentSession().get(Item.class, 1);
		System.out.println(item);
	}
}

