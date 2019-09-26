package sxy.dxg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import sxy.dxg.myRule.MyselfRule;

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
@EnableDiscoveryClient  // 能够发现服务（）
@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = MyselfRule.class)// 为某一个服务特定指定负载均衡算法（也可以是相关配置）
public class DeptConsumer80_App {
    public static void main(String[] args) {
        SpringApplication.run(sxy.dxg.springcloud.DeptConsumer80_App.class,args);
    }
}
