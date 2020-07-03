package hibernate.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TransactionDAO {
	//Spring JDBC 에서 제공하는 데이터 삽입 클래스의 변수
	@Autowired
	private SimpleJdbcInsert template;
	@Transactional
	public void insert() {
		//테이블 이름설정
		template.withTableName("TOURISTSPOT");
		//삽입할 데이터 생성
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("spotname", "평화랜");
	    map.put("roadaddress", null);
	    map.put("touraddress", "경기 적성면 설 4-6");
	    map.put("tell", "0319404619");
	    map.put("businesshour", "매일 09:00 - 18:00");
	    map.put("price", null);
	    
	    template.execute(map);

	    template.execute(map);
	}
}
