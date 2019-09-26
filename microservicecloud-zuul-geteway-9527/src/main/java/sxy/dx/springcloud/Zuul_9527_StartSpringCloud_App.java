package sxy.dx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


/**
 *  zuul 这个网关的意义很大（可以看一下黑马57培训的文档）
 *
 *   ctrl+n  查找类
 */
@SpringBootApplication
@EnableZuulProxy     //开启Zuul路由网关
public class Zuul_9527_StartSpringCloud_App {

    public static void main(String[] args) {
        SpringApplication.run(Zuul_9527_StartSpringCloud_App.class,args);
    }

}