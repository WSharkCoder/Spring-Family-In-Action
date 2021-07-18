package cn.wsharkcoder.jpademo;

import cn.wsharkcoder.jpademo.model.Coffee;
import cn.wsharkcoder.jpademo.model.CoffeeOrder;
import cn.wsharkcoder.jpademo.model.OrderState;
import cn.wsharkcoder.jpademo.repository.ComplexCoffeeOrderRepository;
import cn.wsharkcoder.jpademo.repository.ComplexCoffeeRepository;
import cn.wsharkcoder.jpademo.repository.SimpleCoffeeOrderRepository;
import cn.wsharkcoder.jpademo.repository.SimpleCoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.TypeCache;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import java.util.Arrays;
import java.util.Collections;
import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;


@SpringBootApplication
/**
 * 开启JPA
 */
@EnableJpaRepositories
/**
 * 开启事务
 */
@EnableTransactionManagement
@Slf4j
/**
 * @author FangJunXiong
 */
public class JpaDemoApplication implements ApplicationRunner {
    @Autowired
    private SimpleCoffeeRepository simpleCoffeeRepository;
    @Autowired
    private SimpleCoffeeOrderRepository simpleCoffeeOrderRepository;

    @Autowired
    private ComplexCoffeeRepository complexCoffeeRepository;
    @Autowired
    private ComplexCoffeeOrderRepository complexCoffeeOrderRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }


    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        initOrdersBySimpleRepository();
        findOrders();
    }

    private void initOrdersBySimpleRepository() {
        Coffee espresso = Coffee.builder()
                .name("espresso")
                .money(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .build();
        simpleCoffeeRepository.save(espresso);
        log.info("Coffee: {}", espresso);

        Coffee latte = Coffee.builder().name("latte")
                .money(Money.of(CurrencyUnit.of("CNY"), 30.0))
                .build();
        simpleCoffeeRepository.save(latte);
        log.info("Coffee: {}", latte);

        CoffeeOrder order = CoffeeOrder.builder()
                .customer("Li Lei")
                .items(Collections.singletonList(espresso))
                .state(OrderState.INIT)
                .build();
        simpleCoffeeOrderRepository.save(order);
        log.info("Order: {}", order);

        order = CoffeeOrder.builder()
                .customer("Li lei")
                .items(Arrays.asList(espresso, latte))
                .state(OrderState.INIT)
                .build();
        simpleCoffeeOrderRepository.save(order);
        log.info("Order:{}", order);
    }

    private void findOrders() {
        //加载菜单
        complexCoffeeRepository.findAll(Sort.by(Sort.Direction.DESC, "id"))
                .forEach(e -> log.info("Loading {}", e));
        //查询最新的三个订单
        List<CoffeeOrder> list = complexCoffeeOrderRepository.findTop3ByOrderByUpdateTimeDescIdAsc();
        log.info("findTop3ByOrderByUpdateTimeDescIdAsc: {}", getJoinedOrderId(list));
        //查询Li lei的订单
        list = complexCoffeeOrderRepository.findByCustomerOrderById("Li lei");
        log.info("findByCustomerOrderById: {}", getJoinedOrderId(list));

        //不开启事务会因为没Session而报LazyInitializationException
        list.forEach(o ->
        {
            log.info("Order {}", o.getId());
            o.getItems().forEach(i -> log.info("   Item {}", i));
        });
        //根据咖啡查订单
        list = complexCoffeeOrderRepository.findByItems_Name("latte");
        log.info("findByItems_Name: {}", getJoinedOrderId(list));
    }

    private String getJoinedOrderId(List<CoffeeOrder> list) {
        return list.stream().map(e -> e.getId().toString())
                .collect(Collectors.joining(","));
    }
}
