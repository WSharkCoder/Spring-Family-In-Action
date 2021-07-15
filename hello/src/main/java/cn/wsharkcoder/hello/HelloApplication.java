package cn.wsharkcoder.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WSharkCoder
 * @date 2021/7/3
 */
@SpringBootApplication
@RestController
public class HelloApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello,SpringBoot!";
    }

}
