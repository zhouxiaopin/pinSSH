package com.gzticc.hz.pojo;

import java.util.Date;

/**
 * 部门实体类
 * Created by Administrator on 2017/9/11.
 */
public class Department {
    private Long departmentId;          //主键ID
    private String departmentNo;        //部门编号
    private String departmentName;      //部门名称
    private String departmentPhone;     //部门电话
    private String status;              //部门状态
    private Date createTime;            //创建时间

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentNo(String departmentNo) {
        this.departmentNo = departmentNo;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepartmentPhone(String departmentPhone) {
        this.departmentPhone = departmentPhone;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentNo() {
        return departmentNo;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentPhone() {
        return departmentPhone;
    }

    public String getStatus() {
        return status;
    }

    public Date getCreateTime() {
        return createTime;
    }
}
