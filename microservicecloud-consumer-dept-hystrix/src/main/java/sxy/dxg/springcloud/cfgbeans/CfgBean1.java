package sxy.dxg.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;
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