package sxy.dxg.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sxy.dxg.springcloud.entity.Dept;
import sxy.dxg.springcloud.service.DeptClientService;

import java.util.List;

/**
 * @auther 丁溪贵
 * @date 2019/9/25
 */

@RestController
public class DeptController_Consumer {

    //该接口的子类被Fegin的进行动态实现了
    @Autowired
    private DeptClientService deptClientService;

    @HystrixCommand(fallbackMethod = "failMethod")
    @RequestMapping(value = "/consumer/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable(value = "id")long id){
        // 部门id为2就抛出异常
        if(id==2){
            throw  new RuntimeException();
        }
        return deptClientService.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return deptClientService.list();
    }

    @RequestMapping(value = "/consumer/dept/add",method = RequestMethod.POST)
    public boolean add(Dept dept) {
        return deptClientService.add(dept);
    }

    public Dept failMethod(long id){

        return new Dept().setDname("没有此部门");
    }
}
