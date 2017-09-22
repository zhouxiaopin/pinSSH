<%@ taglib prefix="ticc" uri="http://www.ticc.com" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ticc:datagrid controRequestPath="/sysMenu" dgTitle="系统资源管理" idField="sysMenuId" columns="[[
            {field:'sysMenuId',title:'id',checkbox:true,width:ticc.getFixWidth(0.1)},
            {field:'sysMenuNo',title:'菜单编号',width:ticc.getFixWidth(0.1)},
            {field:'sysMenuName',title:'菜单名称',width:ticc.getFixWidth(0.1)},
            {field:'url',title:'请求url',width:ticc.getFixWidth(0.2)},
            {field:'parentNo',title:'菜单父编号',width:ticc.getFixWidth(0.1)},
            {field:'levelCode',title:'菜单级别',width:ticc.getFixWidth(0.1)},
            {field:'useStatus',title:'使用状态',width:ticc.getFixWidth(0.1)},
            {field:'createPersionId',title:'创建人',width:ticc.getFixWidth(0.1)},
            {field:'createTime',title:'创建时间',width:ticc.getFixWidth(0.1),
                formatter: function(value){
                    if (value){
                        var date = new Date(value).format('yyyy-MM-dd hh:mm:ss');
                        return date;
                    }else{
                        return value;
                    }

                }
            }
        ]]" searchParams="{
                'sysMenuCustom.sysMenuNo': $('#sysMenuNo').val(),
                'sysMenuCustom.sysMenuName': $('#sysMenuName').val()
            }">
    <legend class="legend">信息查询</legend>
    菜单编号:&nbsp;<input id="sysMenuNo" class="easyui-textbox" />&nbsp;
    菜单名称:&nbsp;<input id="sysMenuName" class="easyui-textbox" />

</ticc:datagrid>