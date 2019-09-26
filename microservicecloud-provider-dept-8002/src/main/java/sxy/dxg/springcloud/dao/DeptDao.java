package sxy.dxg.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import sxy.dxg.springcloud.entity.Dept;

import java.util.List;

@Mapper  // 一定要打上mapper注解
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}
