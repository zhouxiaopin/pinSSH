package com.gzticc.common.frame.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.StringWriter;

/**
 * Created by Administrator on 2017/9/20.
 */
public class BaseTag extends SimpleTagSupport {
    protected String id;
    protected String name;
    protected String clazz;
    protected StringWriter sw = new StringWriter();

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClazz() {
        return clazz;
    }

    protected String getBasePath(HttpServletRequest request) {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + path + "/";

        return basePath;
    }
}
