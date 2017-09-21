package com.gzticc.common.frame.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import java.io.IOException;

/**
 * Created by Administrator on 2017/9/20.
 */
public class DatagridTag extends BaseTag {

    private String columns;

    @Override
    public void doTag() throws JspException, IOException {
        PageContext context = (PageContext)this.getJspContext();
        HttpServletResponse response = (HttpServletResponse)context.getResponse();
        //设置输出内容类型和编码
        response.setContentType("text/html;charset=utf-8");

        HttpServletRequest request = (HttpServletRequest)context.getRequest();
        String path = request.getContextPath();
        String basePath = getBasePath(request);

        StringBuilder html = new StringBuilder();

        String commonShowDivId = "_t_"+System.nanoTime();
        html.append("<div id='"+commonShowDivId+"' class='commonShowDiv'>");



        //搜索框
        String commonQueryDivId = "_t_"+System.nanoTime();
        html.append("<div id='"+commonQueryDivId+"' class='commonQueryDiv'>");
/*        html.append("<fieldset class='fieldset'>");
        html.append("<legend class='legend'>信息查询</legend>");
        html.append("部门编号:&nbsp;<input id='departmentNo' class='easyui-textbox' />&nbsp;");
        html.append("部门名称:&nbsp;<input id='departmentName' class='easyui-textbox' />");
        html.append("<a id='serachBtn' class='easyui-linkbutton' data-options=\"iconCls:'icon-search'\">查询</a>");
        html.append("</fieldset>");*/

        JspFragment content = this.getJspBody();
        content.invoke(this.getJspContext().getOut());

        html.append("</div>");

        //网格div的id
        String dataInfoAreaId = "_t_"+System.nanoTime();

        html.append(" <div id='"+dataInfoAreaId+"' style='width:100%;min-width:1024px;height: 100%;'>");

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

        html.append("</div>");

        html.append("</div>");

        html.append("<script type='text/javascript'>");
        html.append("$(function () {");
        html.append("var height = $('#"+commonShowDivId+"').height() - $('#"+commonQueryDivId+"').height();");
        html.append("$('#"+dataInfoAreaId+"').height(height);");

        columns = columns.replace("width:ticc.getFixWidth(","width:ticc.getFixWidth('#"+dataInfoAreaId+"',");
        html.append("ticcFrame.intiDatagrid('部门管理','#"+id+"','"+path+"/department','departmentId',"+columns+")");
        html.append("});");
        html.append("</script>");

        JspWriter out = getJspContext().getOut();
        out.write(html.toString());
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }

    public String getColumns() {
        return columns;
    }
}
