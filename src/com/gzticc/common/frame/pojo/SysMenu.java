package com.gzticc.common.frame.pojo;

import java.util.Date;

/**
 * 系统菜单实体类
 * Created by Administrator on 2017/9/18.
 */
public class SysMenu {
    private Long sysMenuId;
    private String sysMenuNo;
    private String sysMenuName;
    private String parentNo;
    private String status;
    private Long createPersionId;
    private Date createTime;

    public void setSysMenuId(Long sysMenuId) {
        this.sysMenuId = sysMenuId;
    }

    public void setSysMenuNo(String sysMenuNo) {
        this.sysMenuNo = sysMenuNo;
    }

    public void setSysMenuName(String sysMenuName) {
        this.sysMenuName = sysMenuName;
    }

    public void setParentNo(String parentNo) {
        this.parentNo = parentNo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatePersionId(Long createPersionId) {
        this.createPersionId = createPersionId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getSysMenuId() {
        return sysMenuId;
    }

    public String getSysMenuNo() {
        return sysMenuNo;
    }

    public String getSysMenuName() {
        return sysMenuName;
    }

    public String getParentNo() {
        return parentNo;
    }

    public String getStatus() {
        return status;
    }

    public Long getCreatePersionId() {
        return createPersionId;
    }

    public Date getCreateTime() {
        return createTime;
    }
}
