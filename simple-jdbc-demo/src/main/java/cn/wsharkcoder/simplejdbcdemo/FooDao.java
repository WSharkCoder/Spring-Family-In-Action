package cn.wsharkcoder.simplejdbcdemo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author WSharkCoder
 * @date 2021/07/05
 * 常见JDBC操作
 */
@Slf4j
@Repository
@AllArgsConstructor
public class FooDao {
    /**
     * Spring JDBC模板
     */
    private final JdbcTemplate jdbcTemplate;
    /**
     * Spring 简单插入JDBC模板
     */
    private final SimpleJdbcInsert simpleJdbcInsert;

    /**
     * 插入数据
     */
    public void insertData() {
        //列表逐行插入
        Arrays.asList("b", "c").forEach(
                bar -> {
                    jdbcTemplate.update("INSERT INTO FOO(BAR) VALUES (?)", bar);
                }
        );
        HashMap<String, String> row = new HashMap<>();
        row.put("BAR", "d");
        //插入数据并返回ID值
        Number id = simpleJdbcInsert.executeAndReturnKey(row);
        log.info("ID of d:{}", id.longValue());
    }

    public void listData() {
        //查询记录条数
        log.info("Count:{}", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO", Long.class));
        //查询字符串列表
        List<String> list = jdbcTemplate.queryForList("SELECT BAR FROM FOO", String.class);
        list.forEach(s -> log.info("Bar:{}", s));
        //查询对象列表
        List<Foo> fooList = jdbcTemplate.query("SELECT * FROM FOO", new RowMapper<Foo>() {
            @Override
            public Foo mapRow(ResultSet resultSet, int i) throws SQLException {
                return Foo.builder()
                        .id(resultSet.getLong(1))
                        .bar(resultSet.getString(2))
                        .build();
            }
        });
        fooList.forEach(f -> log.info("Foo:{}", f));
    }

}
