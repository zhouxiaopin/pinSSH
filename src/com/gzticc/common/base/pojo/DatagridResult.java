package com.gzticc.common.base.pojo;

import java.util.Collection;

/**
 * Created by Administrator on 2017/9/12.
 */
public class DatagridResult<T> {
    private int total;
    private Collection<T> rows;

    public void setTotal(int total) {
        this.total = total;
    }

    public void setRows(Collection<T> rows) {
        this.rows = rows;
        setTotal(rows.size());
    }

    public int getTotal() {
        return total;
    }

    public Collection<T> getRows() {
        return rows;
    }
}

