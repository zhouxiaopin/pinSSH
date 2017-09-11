package com.gzticc.hz.pojo;

/**
 * 部门实体类的包装对象
 * Created by Administrator on 2017/9/11.
 */
public class DepartmentQueryVo{
    //为了系统 可扩展性，对原始生成的pojo进行扩展
    private DepartmentCustom departmentCustom;

    public void setDepartmentCustom(DepartmentCustom departmentCustom) {
        this.departmentCustom = departmentCustom;
    }

    public DepartmentCustom getDepartmentCustom() {
        return departmentCustom;
    }
}
