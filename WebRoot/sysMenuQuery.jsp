<%@ taglib prefix="ticc" uri="http://www.ticc.com" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="commonShowDiv">
    <div class="commonQueryDiv">
        <fieldset class="fieldset">
            <legend class="legend">信息查询</legend>
            部门编号:&nbsp;<input id="departmentNo" class="easyui-textbox" />&nbsp;
            部门名称:&nbsp;<input id="departmentName" class="easyui-textbox" />
            <a id="serachBtn" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
        </fieldset>
    </div>
        <ticc:datagrid columns="[[
            {field:'departmentId',title:'id',checkbox:true,width:ticc.getFixWidth(0.1)},
            {field:'departmentNo',title:'部门编号',width:ticc.getFixWidth(0.1)},
            {field:'departmentName',title:'部门名称',width:ticc.getFixWidth(0.2)},
            {field:'departmentPhone',title:'部门电话',width:ticc.getFixWidth(0.2)},
            {field:'status',title:'部门状态',width:ticc.getFixWidth(0.1)},
            {field:'createTime',title:'创建时间',width:ticc.getFixWidth(0.3),
                formatter: function(value){
                    if (value){
                        var date = new Date(value).format('yyyy-MM-dd hh:mm:ss');
                        return date;
                    }else{
                        return value;
                    }

                }
            }
        ]]"/>
    <%--</div>--%>
</div>
<script type="text/javascript">
    $(function () {

        $('#serachBtn').on('click',function () {
            $('#dataInfo').datagrid('load',{
                'departmentCustom.departmentNo': $('#departmentNo').val(),
                'departmentCustom.departmentName': $('#departmentName').val()
            });

        });
    });


</script>
