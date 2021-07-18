package cn.wsharkcoder.mongorepositorydemo;

import cn.wsharkcoder.mongorepositorydemo.converter.MoneyReadConverter;
import cn.wsharkcoder.mongorepositorydemo.model.Coffee;
import cn.wsharkcoder.mongorepositorydemo.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;
import java.util.Date;

/**
 * @author WSharkCoder
 */
@SpringBootApplication
@EnableMongoRepositories
@Slf4j
public class MongoRepositoryDemoApplication implements CommandLineRunner {
    @Autowired
    private CoffeeRepository coffeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongoRepositoryDemoApplication.class, args);
    }

    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(Arrays.asList(new MoneyReadConverter()));
    }

    @Override
    public void run(String... args) throws Exception {
        Coffee espresso = Coffee.builder()
                .name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .createTime(new Date())
                .createTime(new Date())
                .build();
        Coffee latte = Coffee.builder()
                .name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 30.0))
                .createTime(new Date())
                .updateTime(new Date())
                .build();
        // 保存咖啡
        coffeeRepository.insert(Arrays.asList(espresso, latte));
        // 查询所有咖啡并按照升序排列
        coffeeRepository.findAll(Sort.by("name"))
                .forEach(e -> log.info("Saved Coffee {}", e));

        Thread.sleep(1000);
        latte.setPrice(Money.of(CurrencyUnit.of("CNY"), 35.0));
        latte.setUpdateTime(new Date());

        coffeeRepository.save(latte);
        coffeeRepository.findByName("latte")
                .forEach(e -> log.info("Coffee {}", e));

        coffeeRepository.deleteAll();

    }
}
