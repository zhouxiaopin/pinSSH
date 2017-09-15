<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@ include file="/zcp/common/jsp/resInclude.jsp"%>
    <title>部门管理</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="部门管理">
    <style type="text/css">

    </style>
</head>
<body>
<form id="department" method="post">
    <table style="margin: 0 auto;">
        <tbody>
        <td colspan="2">
            <label id="retMsg" style="display:block;text-align: center;color: #FF0000">${retMsg}</label>
            <input name="departmentId" value="${obj.departmentId}" type="hidden"/>
        </td>
            <c:choose>
                <c:when test="${oprt == 'add'}">
                    <tr>
                        <th><label>部门编号:</label></th>
                        <td> <input name="departmentNo" missingMessage="部门编号不能为空" value="${obj.departmentNo}" class="easyui-textbox easyui-validatebox" type="text" data-options="required:true" /></td>
                    </tr>
                    <tr>
                        <th><label >部门名称:</label></th>
                        <td><input name="departmentName" value="${obj.departmentName}" class="easyui-textbox easyui-validatebox" type="text"/></td>
                    </tr>
                    <tr>
                        <th><label>部门电话:</label></th>
                        <td><input name="departmentPhone" value="${obj.departmentPhone}" class="easyui-numberbox easyui-validatebox" type="text" data-options="validType:'phone'" /></td>
                    </tr>
                    <tr>
                        <th><label>部门状态:</label></th>
                        <td><input name="status" value="${obj.status}" class="easyui-textbox easyui-validatebox" type="text" data-options="validType:'phone'" /></td>
                    </tr>
                </c:when>
                <c:when test="${oprt == 'update'}">
                    <tr>
                        <th><label >部门编号:</label></th>
                        <td> <input name="departmentNo" value="${obj.departmentNo}" class="easyui-textbox easyui-validatebox" type="text" data-options="required:true" /></td>
                    </tr>
                    <tr>
                        <th><label >部门名称:</label></th>
                        <td><input name="departmentName" value="${obj.departmentName}" class="easyui-validatebox" type="text"/></td>
                    </tr>
                    <tr>
                        <th><label >部门电话:</label></th>
                        <td><input name="departmentPhone" value="${obj.departmentPhone}" class="easyui-numberbox easyui-validatebox" type="text" data-options="validType:'phone'" /></td>
                    </tr>
                    <tr>
                        <th><label >部门状态:</label></th>
                        <td><input name="status" value="${obj.status}" class="easyui-textbox easyui-validatebox" type="text" data-options="validType:'phone'" /></td>
                    </tr>
                </c:when>
                <c:when test="${oprt == 'queryDetail'}">
                    <tr>
                        <th><label >部门编号:</label></th>
                        <td> <input name="departmentNo" value="${obj.departmentNo}" class="easyui-textbox easyui-validatebox" type="text" data-options="required:true" /></td>
                    </tr>
                    <tr>
                        <th><label >部门名称:</label></th>
                        <td><input name="departmentName" value="${obj.departmentName}" class="easyui-textbox easyui-validatebox" type="text"/></td>
                    </tr>
                    <tr>
                        <th><label >部门电话:</label></th>
                        <td><input name="departmentPhone" value="${obj.departmentPhone}" class="easyui-numberbox easyui-validatebox" type="text" data-options="validType:'phone'" /></td>
                    </tr>
                    <tr>
                        <th><label >部门状态:</label></th>
                        <td><input name="status" value="${obj.status}" class="easyui-textbox easyui-validatebox" type="text" data-options="validType:'phone'" /></td>
                    </tr>
                    <tr>
                        <th><label >创建时间:</label></th>
                        <td><input name="createTime" value="<fmt:formatDate value="${obj.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" class="easyui-datetimebox" type="text" data-options="" /></td>
                    </tr>
                </c:when>
            </c:choose>
            <tr>
                <td colspan="2" style="text-align: center;padding-top: 5px">
                    <a href="javascript:void(0)" id="submitForm" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确定</a>
                    <a href="javascript:void(0)" id="resetForm" class="easyui-linkbutton" data-options="iconCls:'icon-undo'">重置</a>
                </td>
            </tr>
        </tbody>
    </table>
</form>
<script type="text/javascript">
    $(function () {
        <%--$('#department').form('load',{--%>
            <%--departmentId:${obj.departmentId},--%>
            <%--departmentNo:${obj.departmentNo},--%>
            <%--departmentName:${obj.departmentName},--%>
            <%--departmentPhone:${obj.departmentPhone},--%>
            <%--status:${obj.status},--%>
            <%--createTime:'<fmt:formatDate value="${obj.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>'--%>
        <%--});--%>

        if("${oprt }" == "queryDetail"){
            $(":input").attr("disabled",true);
            $("a").attr("disabled",true);
        }

        $('#department').form({
            url:'${pageContext.request.contextPath}/department/${oprt}.action',
            onSubmit: function(param){
//                $.messager.progress();	// 显示进度条
                // do some check
                // return false to prevent submit;
                var isValid = $(this).form('validate');
                if (!isValid){
//                    $.messager.progress('close');	// 如果表单是无效的则隐藏进度条
                    $('#retMsg').html("表单校验不通过");
                }
                return isValid;	// 返回false终止表单提交
            },
            success:function(data){
                data = JSON.parse(data);
                $('#retMsg').html(data.msg);
//                if(true === data.status){
//                    $.messager.alert('提示',data.msg,'info');
//                }else {
//                    $.messager.alert('提示',data.msg,'error');
//                }

                //alert(data);
//                $.messager.progress('close');	// 如果提交成功则隐藏进度条
            }
        });
        $('#submitForm').on('click',function () {
            if ($(this).linkbutton('options').disabled == false) {
                $('#department').form('submit');
            }
        });
        $('#resetForm').on('click',function () {
            if ($(this).linkbutton('options').disabled == false) {
                $('#department').form('reset');
            }
        });

    });

</script>
</body>
</html>
