package sxy.dxg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @auther 丁溪贵
 * @date 2019/9/26
 */
@SpringBootApplication
@EnableConfigServer     // 请用spring cloud 的config服务
public class Config_3344_StartSpringCloudApp {

    public static void main(String[] args) {
        SpringApplication.run(Config_3344_StartSpringCloudApp.class,args);
    }
}
