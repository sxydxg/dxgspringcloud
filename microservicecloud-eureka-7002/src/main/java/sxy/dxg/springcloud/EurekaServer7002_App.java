package sxy.dxg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @auther 丁溪贵
 * @date 2019/9/22
 */
@SpringBootApplication
@EnableEurekaServer    // 启动Eureka服务端（注册中心）
public class EurekaServer7002_App {


    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7002_App.class,args);
    }
}
