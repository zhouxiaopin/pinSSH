package com.gzticc.common.pojo;

import java.util.Collection;

/**
 * Created by Administrator on 2017/9/12.
 */
public class DatagridResult<T> {
    private Long total;
    private Collection<T> rows;

    public void setTotal(Long total) {
        this.total = total;
    }

    public void setRows(Collection<T> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public Collection<T> getRows() {
        return rows;
    }
}

