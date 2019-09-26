package sxy.dxg.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

/**
 * @auther 丁溪贵
 * @date 2019/9/22
 *
 *    关于@LoadBalanced介绍
 *    https://blog.csdn.net/u011063112/article/details/81295376
 *
 *    为什么idea的源码没有注释解释，但github上的源码都是有注释的
 *    （）已解决
 */
@Configuration
public class CfgBean1 {

    @LoadBalanced
    @Bean()
    @Scope("singleton")
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


/*
    必须注释掉，不然引起bean冲突
    @Bean
    public IRule getRule(){
        // 默认负载均衡是轮询方式，现在改为随机
        return new RandomRule();
    }*/

}
