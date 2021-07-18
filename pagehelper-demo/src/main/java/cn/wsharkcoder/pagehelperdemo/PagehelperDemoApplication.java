package cn.wsharkcoder.pagehelperdemo;

import cn.wsharkcoder.pagehelperdemo.mapper.CoffeeMapper;
import cn.wsharkcoder.pagehelperdemo.model.Coffee;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * @author WSharkCoder
 */
@SpringBootApplication
@Slf4j
@MapperScan("cn.wsharkcoder.pagehelperdemo.mapper")
public class PagehelperDemoApplication implements ApplicationRunner {
    @Autowired
    private CoffeeMapper coffeeMapper;

    public static void main(String[] args) {

        SpringApplication.run(PagehelperDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //1.使用RowBounds转入页码
        //每页3条数据 第1页
        coffeeMapper.findAllWithRowBounds(new RowBounds(1, 3))
                .forEach(c -> log.info("Page(1) Coffee {}", c));
        log.info("================");
        //每页3条数据 第2页
        coffeeMapper.findAllWithRowBounds(new RowBounds(2, 3))
                .forEach(c -> log.info("Page(2) Coffee {}", c));

        log.info("================");
        //所有数据
        coffeeMapper.findAllWithRowBounds(new RowBounds(1, 0))
                .forEach(c -> log.info("Page(1) Coffee {}", c));
        log.info("================");

        coffeeMapper.findAllWithParam(2, 3)
                .forEach(c -> log.info("Page(1) Coffee {}", c));

        List<Coffee> list = coffeeMapper.findAllWithParam(2, 3);

        PageInfo<List<Coffee>> page = new PageInfo(list);
        log.info("PageInfo: {}", page);


    }
}
