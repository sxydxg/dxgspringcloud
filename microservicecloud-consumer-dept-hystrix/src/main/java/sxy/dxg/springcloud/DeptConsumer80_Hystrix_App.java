package sxy.dxg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker//启用熔断器 即Hystrix
// Ribbon 是默认开启的，无需配置  https://blog.csdn.net/weixin_34008805/article/details/91420636
public class DeptConsumer80_Hystrix_App {


    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_Hystrix_App.class,args);
    }
}