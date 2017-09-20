package com.gzticc.common.frame.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;

/**
 * Created by Administrator on 2017/9/20.
 */
public class DatagridTag extends BaseTag {

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();
        String element;
        if (id != null) {
          /* 从属性中使用消息 */
//            out.println( message );
            element = "<table id='"+id+"'></table>";
        }else {
            id = "_t_"+System.nanoTime();
            element = "<table id='"+id+"' ></table>";

          /* 从内容体中使用消息 */
            /*getJspBody().invoke(sw);*/

            /*writer.println(sw.toString());*/
        }
        out.print(element);
    }
}
