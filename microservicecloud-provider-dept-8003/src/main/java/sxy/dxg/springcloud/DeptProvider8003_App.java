package sxy.dxg.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @auther 丁溪贵
 * @date 2019/9/22
 *          @EnableDiscoveryClient和EnableEurekaClient都是服务注册的注解
 *          @EnableDiscoveryClient内部包含了EnableEurekaClient
 *          在此我使用EnableEurekaClient
 *
 *      博客解释：https://www.jianshu.com/p/f6db3117864f
 */
@SpringBootApplication
@MapperScan("sxy.dxg.springcloud.dao") // 扫描mapper接口
@EnableEurekaClient// 启用eureka客户端，并将自己注册eureka服务端中去
public class DeptProvider8003_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8003_App.class,args);
    }
}
