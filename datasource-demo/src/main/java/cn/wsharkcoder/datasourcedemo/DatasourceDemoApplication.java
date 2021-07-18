package cn.wsharkcoder.datasourcedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


/**
 * @author WSharkCoder
 * @date 2021/7/3
 */
@SpringBootApplication
@Slf4j
public class DatasourceDemoApplication implements CommandLineRunner {
    /**
     * SpringBoot自动配置数据源
     */
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(DatasourceDemoApplication.class, args);
    }

    public void run(String... args) throws SQLException {
        showConnection();
        showData();
    }

    /**
     * 显示查询信息
     *
     * @throws SQLException
     */
    private void showConnection() throws SQLException {
        log.info(dataSource.toString());
        Connection conn = dataSource.getConnection();
        log.info(conn.toString());
        conn.close();
    }

    private void showData() {

        List<Map<String, Object>> l = jdbcTemplate.queryForList("SELECT * FROM FOO");
        for (Map<String, Object> map : l) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                log.info(entry.toString());
            }
        }
    }
}
