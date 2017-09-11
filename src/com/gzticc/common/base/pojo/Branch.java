package com.gzticc.common.base.pojo;

import java.util.List;

/**
 * Created by user on 2017/5/29.
 */
public class Branch<T> {

    /**
     * Count : 10
     * IndexPage : 0
     * Data : []
     */

    private int Count;
    private int IndexPage;
    private List<T> Data;

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public int getIndexPage() {
        return IndexPage;
    }

    public void setIndexPage(int IndexPage) {
        this.IndexPage = IndexPage;
    }

    public List<T> getData() {
        return Data;
    }

    public void setData(List<T> Data) {
        this.Data = Data;
    }

}
