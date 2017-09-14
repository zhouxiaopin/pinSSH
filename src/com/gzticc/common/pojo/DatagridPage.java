package com.gzticc.common.pojo;

/**
 * Created by Administrator on 2017/9/13.
 */
public class DatagridPage<T> {
    private Integer page;//当前页
    private Integer rows;//页大小
    private Long start;//起始索引

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getRows() {
        return rows;
    }

    public Long getStart() {
        this.start = Long.valueOf((page-1)*rows);
        return start;
    }

}
