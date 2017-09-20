<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/frame/common/resInclude.jsp"%>
<div style="width:100%;min-width:1024px;height: auto;min-height: 100px;">
    <fieldset style="min-height:80px;border-color: #AED0EA;border-radius:5px;padding: 10px;display: block;">
        <legend style="margin-left: 10px">信息查询</legend>
        部门编号:&nbsp;<input id="departmentNo" class="easyui-textbox" />&nbsp;
        部门名称:&nbsp;<input id="departmentName" class="easyui-textbox" />


        <a id="serachBtn" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
    </fieldset>
</div>
<div class="dataInfoArea" style="width:100%;min-width:1024px;height: auto;">
<%--    <table id="dataInfo" class="dataInfo">
    </table>--%>
    <ticc:datagrid id="dataInfo"></ticc:datagrid>
</div>
<script type="text/javascript">
    $(function () {


        $('#serachBtn').on('click',function () {
            $('#dataInfo').datagrid('load',{
                'departmentCustom.departmentNo': $('#departmentNo').val(),
                'departmentCustom.departmentName': $('#departmentName').val()
            });


        });

        var browser = ticc.getBrowser();
        if ("Firefox" == browser){
            $(".dataInfoArea").css("min-height","372px");
        }else if("Chrome" == browser){
            $(".dataInfoArea").css("min-height","399px");
        }else if("IE" == browser){
            $(".dataInfoArea").css("min-height","415px");
            alert("ie");
        }else{
            $(".dataInfoArea").css("min-height","350px");
        }

        $("#dataInfo").datagrid({
            url: '${pageContext.request.contextPath}/department/list.action?time=' + new Date().getTime(),
            type: 'POST',
            title: '部门管理',
            striped:true,//奇偶行显示不同颜色
            rownumbers:true,//显示行号
            idField:"departmentId",
            fitColumns : true,
            fit : true,
//            singleSelect : true,
            pagination : true,
            pageNumber : 1,
            pageSize : 10,
            pageList : [10,20,30,40,50],
            columns : [[
                {field:'departmentId',title:'id',checkbox:true,width:ticc.getFixWidth(".dataInfoArea",0.1)},
                {field:'departmentNo',title:'部门编号',width:ticc.getFixWidth(".dataInfoArea",0.1)},
                {field:'departmentName',title:'部门名称',width:ticc.getFixWidth(".dataInfoArea",0.2)},
                {field:'departmentPhone',title:'部门电话',width:ticc.getFixWidth(".dataInfoArea",0.2)},
                {field:'status',title:'部门状态',width:ticc.getFixWidth(".dataInfoArea",0.1)},
                {field:'createTime',title:'创建时间',width:ticc.getFixWidth(".dataInfoArea",0.3),
                    formatter: function(value,row,index){
                        if (value){
                            var date = new Date(value).format("yyyy-MM-dd hh:mm:ss");
                            return date;
                        }else{
                            return value;
                        }

                    }
                }
            ]],
            onLoadError: function () {
                $.messager.alert('提示','系统繁忙,请稍后再试','error');
            },
            onLoadSuccess: function (data) {
                $(this).datagrid('clearSelections');
                $(this).datagrid('clearChecked');
            },
            toolbar: [{
                iconCls: 'icon-add',
                text: '添加',
                handler: function(){
                    //$.messager.alert('提示','添加按钮','info');
                    $('.dialog').dialog({
                        title: '添加',
                        href: '${pageContext.request.contextPath}/department/initAdd.action',
                        onClose:function () {
                            $('#dataInfo').datagrid('reload');
                        }
                    });
//                    $('#dd').dialog('refresh', 'new_content.php');
                }
            },'-',{
                iconCls: 'icon-edit',
                text: '修改',
                handler: function(){
//                    $.messager.alert('提示','修改按钮','info');
                    var rows = $("#dataInfo").datagrid('getChecked');
                    var len = rows.length;
                    if (0 >= len){
                        $.messager.alert('提示','请选择一行','info');
                        return;
                    }else if(2 <= len){
                        $.messager.alert('提示','只能选择一行','info');
                        return;
                    }
                    $('.dialog').dialog({
                        title: '修改',
                        href: '${pageContext.request.contextPath}/department/initUpdate.action',
                        queryParams: {
                            'id':$("#dataInfo").datagrid('getChecked')[0].departmentId
                        },
                        onClose:function () {
                            $('#dataInfo').datagrid('reload');
                        }
                    });
                }
            },'-',{
                iconCls: 'icon-remove',
                text: '删除',
                handler: function(){
                    var rows = $("#dataInfo").datagrid('getChecked');
                    var len = rows.length;
                    var ids = [];
                    for(var i = 0; i < len; i++){
                        ids.push(rows[i].departmentId);
                    }
                    $.messager.confirm('提示','你确定要删除吗？',function (val) {
                        if (!val){
                            return;
                        }
                        ticc.ajaxRequest('${pageContext.request.contextPath}/department/delete.action',
                            {'ids':ids},function (data) {
                                if(true === data.status){
                                    $('#dataInfo').datagrid('reload');
                                }else {
                                    $.messager.alert('提示',data.msg,'error');
                                }
                            });

                    });
                }
            },'-',{
                iconCls: 'icon-search',
                text: '查看',
                handler: function(){
//                    $.messager.alert('提示','查看按钮','info');
                    var rows = $(".dataInfo").datagrid('getChecked');
                    var len = rows.length;
                    if (0 >= len){
                        $.messager.alert('提示','请选择一行','info');
                        return;
                    }else if(2 <= len){
                        $.messager.alert('提示','只能选择一行','info');
                        return;
                    }
                    $('.dialog').dialog({
                        title: '查看',
                        href: '${pageContext.request.contextPath}/department/initQueryDetail.action',
                        queryParams: {
                            'id':$("#dataInfo").datagrid('getChecked')[0].departmentId
                        },
                        onClose:function () {
                            $('#dataInfo').datagrid('reload');
                        }
                    });
                }
            }]
        });
    });


</script>
