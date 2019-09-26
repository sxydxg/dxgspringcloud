package sxy.dxg.myRule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 该配置类不能放在@ConponentScan包下（也就是@SpringBootApplication的包和子包下）
@Configuration
public class MyselfRule {
    
    @Bean
    public IRule myRule(){
//        return new RandomRule(); // 随机算法替代默认的轮询
//        return new RetryRule();
//        return new RoundRobinRule();
        return new RandomRule_ZY(); //自定义每台机器五次
    }
}