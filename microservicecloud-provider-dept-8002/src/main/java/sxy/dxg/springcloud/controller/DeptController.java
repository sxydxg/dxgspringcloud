package sxy.dxg.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sxy.dxg.springcloud.entity.Dept;
import sxy.dxg.springcloud.service.DeptService;

import java.util.List;

/**
 * @auther 丁溪贵
 * @date 2019/9/22
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService ;


    /**
     *   @RequestBody 用来接收前端数据是json格式（而不是key1=value1&key2=value2 这种格式）
     *
     */
    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id")Long id){
        return deptService.findById(id);
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return deptService.findAll();
    }
}
