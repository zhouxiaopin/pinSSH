package com.gzticc.common.pojo;

import com.gzticc.common.utils.BaseConstant;

import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */
public class PageResult<T> extends BaseResult{
    private int Count = BaseConstant.DEFAULT_PAGE_COUNT;
    private int IndexPage = 0;
    private List<T> Data;

    public void setCount(int count) {
        Count = count;
    }

    public void setIndexPage(int indexPage) {
        IndexPage = indexPage;
    }

    public void setData(List<T> data) {
        Data = data;
    }

    public int getCount() {
        return Count;
    }

    public int getIndexPage() {
        return IndexPage;
    }

    public List<T> getData() {
        return Data;
    }
}
