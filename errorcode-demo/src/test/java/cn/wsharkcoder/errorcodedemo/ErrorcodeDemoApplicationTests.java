package cn.wsharkcoder.errorcodedemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ErrorcodeDemoApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test(expected = CustomDuplicatedKeyException.class)
    public void contextLoads() {
        jdbcTemplate.execute("INSERT INTO FOO(ID,BAR)VALUES (1,'a')");
        jdbcTemplate.execute("INSERT INTO FOO(ID,BAR)VALUES (1,'b')");
    }

}
