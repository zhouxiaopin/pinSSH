package com.gzticc.common.frame.tag;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import java.io.IOException;

/**
 * Created by Administrator on 2017/9/20.
 */
public class DatagridTag extends BaseTag {

    @Override
    public void doTag() throws JspException, IOException {
        HttpServletResponse response = (HttpServletResponse)((PageContext)this.getJspContext()).getResponse();
        //设置输出内容类型和编码
        response.setContentType("text/html;charset=utf-8");

        StringBuilder html = new StringBuilder();
        if (id != null) {
//            html.append("<table id='"+id+"'></table>");
            html.append("<table id='"+id+"' ");
        }else {
            id = "_t_"+System.nanoTime();
//            html.append("<table id='"+id+"' ></table>");
            html.append("<table id='"+id+"' ");
        }
        html.append(" >");
        html.append("</table>");

        JspWriter out = getJspContext().getOut();
        out.print(html.toString());
    }
}
