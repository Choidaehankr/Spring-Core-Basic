package example.mybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class MybatisApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("DB 연결 확인")
	void testRunner() {
		try {
			Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			log.info("연결 성공: {}", con.getMetaData().getURL());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
