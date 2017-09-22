package com.gzticc.common.frame.tag;

import com.gzticc.common.base.utils.StringUtils;

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

    private String controRequestPath;//控制器请求映射
    private String dgTitle;          //头标题
    private String idField;         //主键属性
    private String columns;         //数据网格的列
    private String searchParams;    //搜索按钮的参数

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
        html.append("<fieldset class='fieldset'>");
/*        html.append("<legend class='legend'>信息查询</legend>");
        html.append("部门编号:&nbsp;<input id='departmentNo' class='easyui-textbox' />&nbsp;");
        html.append("部门名称:&nbsp;<input id='departmentName' class='easyui-textbox' />");*/

        JspFragment content = this.getJspBody();
        content.invoke(sw);
        html.append(sw.toString());

        //查询按钮id
        String serachBtnId = "_t_"+System.nanoTime();
        html.append("<a id='"+serachBtnId+"' class='easyui-linkbutton' data-options=\"iconCls:'icon-search'\">查询</a>");
        html.append("</fieldset>");

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
        //计算高度
        html.append("var height = $('#"+commonShowDivId+"').height() - $('#"+commonQueryDivId+"').height();");
        html.append("$('#"+dataInfoAreaId+"').height(height);");

        //搜索按钮事件
        html.append("$('#"+serachBtnId+"').on('click',function () {");
        html.append("$('#"+id+"').datagrid('load',");
        html.append(getSearchParams());
        html.append(");");
        html.append("});");


        columns = columns.replace("width:ticc.getFixWidth(","width:ticc.getFixWidth('#"+dataInfoAreaId+"',");
        html.append("ticcFrame.intiDatagrid('");
        if(StringUtils.isNull(getDgTitle())) {
            html.append("',");
        }else{
            html.append(getDgTitle()+"',");
        }
        String requestPath = path+getControRequestPath();
        html.append("'#"+id+"','"+requestPath+"','"+getIdField()+"',"+columns+",");
//        html.append("[]");
        html.append(getToolbar(id,getIdField(),requestPath));
        html.append(")");
        html.append("});");
        html.append("</script>");

        JspWriter out = getJspContext().getOut();
        out.write(html.toString());
    }

    public void setControRequestPath(String controRequestPath) {
        this.controRequestPath = controRequestPath;
    }

    public void setDgTitle(String dgTitle) {
        this.dgTitle = dgTitle;
    }

    public void setIdField(String idField) {
        this.idField = idField;
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }

    public void setSearchParams(String searchParams) {
        this.searchParams = searchParams;
    }

    public String getControRequestPath() {
        return controRequestPath;
    }

    public String getDgTitle() {
        return dgTitle;
    }

    public String getIdField() {
        return idField;
    }

    public String getColumns() {
        return columns;
    }

    public String getSearchParams() {
        return searchParams;
    }

    private String getToolbar(String elementId,String idField,String controRequestPath){
        StringBuilder html = new StringBuilder();

        html.append("[{");
        html.append("iconCls: 'icon-add',");
        html.append("text: '添加',");
        html.append("handler: function(){");
        html.append("$('.dialog').dialog({");
        html.append("title: '添加',");
        html.append("href: '"+controRequestPath+"/initAdd.action',");
        html.append("onClose:function () {");
        html.append("$('#"+elementId+"').datagrid('reload');");
        html.append("}");
        html.append("});");
        html.append("}");
        html.append("},'-',{");
        html.append("iconCls: 'icon-edit',");
        html.append("text: '修改',");
        html.append("handler: function(){");
        html.append("if (!ticcFrame.datagridCheckOne('#"+elementId+"')){");
        html.append("return;");
        html.append("}");
        html.append("$('.dialog').dialog({");
        html.append(" title: '修改',");
        html.append("href: '"+controRequestPath+"/initUpdate.action',");
        html.append("queryParams: {'id':$('#"+elementId+"').datagrid('getChecked')[0]['"+idField+"']},");
        html.append("onClose:function () {");
        html.append("$('#"+elementId+"').datagrid('reload');");
        html.append("}");
        html.append("});");
        html.append("}");
        html.append("},'-',{");
        html.append("iconCls: 'icon-remove',");
        html.append("text: '删除',");
        html.append("handler: function(){");
        html.append("var rows = $('#"+elementId+"').datagrid('getChecked');");
        html.append("var len = rows.length;");
        html.append("var ids = [];");
        html.append("for(var i = 0; i < len; i++){");
        html.append("ids.push(rows[i]['"+idField+"']);");
        html.append("}");
        html.append("$.messager.confirm('提示','你确定要删除吗？',function (val) {");
        html.append("if (!val){");
        html.append("return;");
        html.append("}");
        html.append("ticc.ajaxRequest('"+controRequestPath+"/delete.action',");
        html.append("{'ids':ids},function (data) {");
        html.append("if(true === data.status){");
        html.append("$('#"+elementId+"').datagrid('reload');");
        html.append("}else {");
        html.append("$.messager.alert('提示',data.msg,'error');");
        html.append(" }");
        html.append("});");
        html.append("});");
        html.append("}");
        html.append("},'-',{");
        html.append("iconCls: 'icon-search',");
        html.append("text: '查看',");
        html.append("handler: function(){");
        html.append("if (!ticcFrame.datagridCheckOne('#"+elementId+"')){");
        html.append("return;");
        html.append("}");
        html.append("$('.dialog').dialog({");
        html.append("title: '查看',");
        html.append("href: '"+controRequestPath+"/initQueryDetail.action',");
        html.append("queryParams: {'id':$('#"+elementId+"').datagrid('getChecked')[0]['"+idField+"']},");
        html.append("onClose:function () {");
        html.append("$('#"+elementId+"').datagrid('reload');");
        html.append("}");
        html.append("});");
        html.append("}");
        html.append("}]");

        return html.toString();
    }
}
