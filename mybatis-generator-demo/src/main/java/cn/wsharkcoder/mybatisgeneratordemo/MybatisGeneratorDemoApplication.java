package cn.wsharkcoder.mybatisgeneratordemo;

import cn.wsharkcoder.mybatisgeneratordemo.mapper.CoffeeMapper;
import cn.wsharkcoder.mybatisgeneratordemo.model.Coffee;
import cn.wsharkcoder.mybatisgeneratordemo.model.CoffeeExample;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;

import org.mybatis.generator.internal.DefaultShellCallback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author WSharkCoder
 */
@SpringBootApplication
@Slf4j
@MapperScan("cn.wsharkcoder.mybatisgeneratordemo.mapper")
public class MybatisGeneratorDemoApplication implements ApplicationRunner {
    @Autowired
    private CoffeeMapper coffeeMapper;

    public static void main(String[] args) {
        SpringApplication.run(MybatisGeneratorDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //生成代码
//        generateArtifacts();
        playWithArtifacts();
    }

    private void generateArtifacts() throws Exception {
        //警告列表
        List<String> warnings = new ArrayList<>();
        //配置解析器
        ConfigurationParser cp = new ConfigurationParser(warnings);
        //读取配置
        Configuration config = cp.parseConfiguration(
                this.getClass().getResourceAsStream("/generatorConfig.xml")
        );
        //脚本回调
        DefaultShellCallback callback = new DefaultShellCallback(true);
        //Mybatis代码生成器
        MyBatisGenerator mybatisGenerator = new MyBatisGenerator(config, callback, warnings);
        mybatisGenerator.generate(null);

    }

    private void playWithArtifacts() {
        //构建Coffee对象
        Coffee espresso = new Coffee()
                .withName("espresso")
                .withPrice(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .withCreateTime(new Date())
                .withUpdateTime(new Date());
        //插入Coffee对象
        coffeeMapper.insert(espresso);

        Coffee latte = new Coffee()
                .withName("latte")
                .withPrice(Money.of(CurrencyUnit.of("CNY"), 30.0))
                .withCreateTime(new Date())
                .withUpdateTime(new Date());
        coffeeMapper.insert(latte);

        //具有内部类Coffee参数

        CoffeeExample example = new CoffeeExample();
        example.createCriteria().andNameEqualTo("latte");
        List<Coffee> list = coffeeMapper.selectByExample(example);
        list.forEach(e -> log.info("SelectByExample: {}", e));

    }
}
