package sxy.dxg.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sxy.dxg.springcloud.dao.DeptDao;
import sxy.dxg.springcloud.entity.Dept;
import sxy.dxg.springcloud.service.DeptService;

import java.util.List;

/**
 * @auther 丁溪贵
 * @date 2019/9/22
 */
@Service
//@Transactional // 要不要配置事务类呢？
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        boolean b = deptDao.addDept(dept);
        return b;
    }

    @Override
    public Dept findById(Long id) {
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> findAll() {
        return deptDao.findAll();
    }
}
