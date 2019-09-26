package sxy.dxg.springcloud.service;

import sxy.dxg.springcloud.entity.Dept;

import java.util.List;

public interface DeptService {


    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
