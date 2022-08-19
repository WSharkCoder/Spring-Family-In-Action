package cn.wsharkcoder.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author WSharkCoder
 * @Date 2022/08/15
 */

@SpringBootApplication
@ComponentScan(basePackages = {"cn.wsharkcoder"})
public class MultiModuleDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MultiModuleDemoApplication.class, args);
    }
}
