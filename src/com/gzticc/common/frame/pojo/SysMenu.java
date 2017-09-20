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
    private String url;
    private String parentNo;
    private String levelCode;
    private String useStatus;
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

    public void setUrl(String url) {
        this.url = url;
    }

    public void setParentNo(String parentNo) {
        this.parentNo = parentNo;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public void setUseStatus(String useStatus) {
        this.useStatus = useStatus;
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

    public String getUrl() {
        return url;
    }

    public String getParentNo() {
        return parentNo;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public String getUseStatus() {
        return useStatus;
    }

    public Long getCreatePersionId() {
        return createPersionId;
    }

    public Date getCreateTime() {
        return createTime;
    }
}
