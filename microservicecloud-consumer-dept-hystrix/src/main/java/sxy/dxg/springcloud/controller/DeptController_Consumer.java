package sxy.dxg.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sxy.dxg.springcloud.entity.Dept;

import java.util.List;

/**
 *      hystrix 的默认属性都在这个类当中：com.netflix.hystrix.HystrixCommandProperties
 */
@RestController
//  hystrix默认会读取次方法，这里还可以书写默认的参数
@DefaultProperties(defaultFallback="myDefaultMethod")
public class DeptController_Consumer {

    // 只需要微服务名称（@LoadBalanced会代理restTemplate类）
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

    // 封装了类似于httpClient的api，用户发送http请求
    @Autowired
    private RestTemplate restTemplate ;

    // 4次请求中只要超过2次失败就会开启熔断，等待60秒后，hystrix会半关闭熔断来检查次服务是否可用
    @HystrixCommand(fallbackMethod = "testHystrix_faild",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "4"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "6000")
    })
    @RequestMapping("/testHystrix/{flag}")
    public String testHystrix(@PathVariable boolean flag){
        // 超过一定异常调用的阈值，testHystrix方法不会被调用，而直接返回失败结果
        System.out.println("testHystrix方法被调用了");
        //如果为true，则抛出一个遗产
        if(flag){
            throw new RuntimeException();
        }

        return "还好，一切正常" ;
    }
    // testHystrix方法专属的服务降级的方法，注意参数和返回值都必须一样
    public String testHystrix_faild(boolean flag){
        return "哎呀，发生了异常!" ;
    }

    @HystrixCommand(fallbackMethod = "testHystrix_faild2",
            commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")

    })
    @RequestMapping("/testHystrix/sleep/{num}")
    public String testHystrix2(@PathVariable Integer num){
        // 超过一定异常调用的阈值，testHystrix方法不会被调用，而直接返回失败结果
        System.out.println("testHystrix2方法被调用了");
        //如果为true，则抛出一个遗产
        try {
            Thread.sleep(num*1000);  // 有num决定超时几秒钟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "还好，一切正常!" ;
    }
    // testHystrix方法专属的服务降级的方法，注意参数和返回值都必须一样
    public String testHystrix_faild2(Integer flag){
        return "哎呀，方法调用超时了!" ;
    }

    @HystrixCommand
    @RequestMapping("/myDefaultMethod/{flag}")
    public String testHystrix3(@PathVariable boolean flag){
        if(flag){
            throw new RuntimeException();
        }
        return  "还好，一切正常!" ;
    }

    // 该方法返回值必须是所有方法返回类型的同类型或者其子类
    public String myDefaultMethod(){
        return "我是默认快速失败方法！";
    }








    // 服务端的添加方法必须是 post，但是在消费端方法就可以是任意
    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add",dept,Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

   /* @SuppressWarnings("unchecked")
    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }*/



}