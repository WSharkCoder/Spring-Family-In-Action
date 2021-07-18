package cn.wsharkcoder.druiddatasourcepooldemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author WSharkCoder
 */
@SpringBootApplication
@Slf4j
public class DruidDatasourcePoolDemoApplication implements CommandLineRunner {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DruidDatasourcePoolDemoApplication(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(DruidDatasourcePoolDemoApplication.class, args);
    }

    public void run(String... args) throws Exception {
        log.info(dataSource.toString());

    }
}
