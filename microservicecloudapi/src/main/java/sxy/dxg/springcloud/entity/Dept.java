package sxy.dxg.springcloud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @auther 丁溪贵
 * @date 2019/9/21
 *
 *      注意：这个lombok在idea当中是需要配置插件的
 *
 *    点击 view-->tool windows-->structure(看有没有相应的方法生成)
 *    1.查看structure   快捷键 alt+7
 *    2.查看项目结构    快捷键 alt+1
 *
 */

@NoArgsConstructor
@Data
@Accessors(chain = true)   // 使用链式方法（就是setxx()会返回当前对象--->不就是级联嘛）
public class Dept implements Serializable {

    private Long deptno;    //主键
    private String dname;    //部门名称
    private String db_source;  //来源数据库，因为微服务架构 可以一个服务对应 一个数据库，同一个信息被存储到不同数据库

    public Dept(String dname) {
        super();
        this.dname = dname;
    }


}
