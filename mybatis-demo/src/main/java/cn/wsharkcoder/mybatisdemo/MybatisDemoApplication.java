package cn.wsharkcoder.mybatisdemo;

import cn.wsharkcoder.mybatisdemo.entity.Coffee;
import cn.wsharkcoder.mybatisdemo.mapper.CoffeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author FangJunXiong
 */
@SpringBootApplication
@Slf4j
@MapperScan("cn.wsharkcoder.mybatisdemo.mapper")
public class MybatisDemoApplication implements ApplicationRunner {
    @Autowired
    CoffeeMapper coffeeMapper;

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Coffee c = Coffee.builder()
                .name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .build();
        int count = coffeeMapper.save(c);
        log.info("#####################");
        log.info("Save {} coffee:{}", count, c);
        log.info("#####################");

        c = Coffee.builder()
                .name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 25.0))
                .build();
        count = coffeeMapper.save(c);
        log.info("#####################");
        log.info("Save {} coffee:{}", count, c);
        log.info("#####################");

        c = coffeeMapper.findById(c.getId());
        log.info("#####################");
        log.info("Find Coffee:{}", c);
        log.info("#####################");

    }
}
