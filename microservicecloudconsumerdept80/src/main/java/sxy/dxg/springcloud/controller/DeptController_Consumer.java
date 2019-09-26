package sxy.dxg.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sxy.dxg.springcloud.entity.Dept;

import java.util.Iterator;
import java.util.List;

/**
 * @auther 丁溪贵
 * @date 2019/9/22
 */
//@RestController
public class DeptController_Consumer {

    private static final String REST_URL_PREFIX = "http://localhost:8001";
    @Autowired
    private DiscoveryClient discoveryClient ;

    // 封装了类似于httpClient的api，用户发送http请求
    @Autowired
    private RestTemplate restTemplate ;

    // 服务端的添加方法必须是 post，但是在消费端方法就可以是任意
    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add",dept,Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }


    //如果想发现服务，那么必须自己也要注册到eureka中去
    @RequestMapping("/dept/discovery")
    public Object discover(){

        List<ServiceInstance> instances = discoveryClient.getInstances("microservicecloud-dept");
        Iterator<ServiceInstance> iterator = instances.iterator();
        while(iterator.hasNext()){
            ServiceInstance next = iterator.next();
            System.out.println("ServiceId : "+next.getServiceId());
            System.out.println("Host : "+next.getHost());
            System.out.println("Port : "+next.getPort());
            System.out.println("Uri : "+next.getUri());
        }
        return instances ;
    }
}
