<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style type="text/css">
</style>
<div class="easyui-tabs" data-options="border:false" style="width:100%;height:100%;">
        <div title="我的桌面" style="display:none;background: #FFffff;">
                <jsp:include page="../common/jsp/myDesktop.jsp" flush="true"/>
        </div>
        <div title="部门管理" data-options="closable:true,fit:true" style="padding:5px;">
      <%--          <div id="baseDiv">
                        <div id="div1">基本信息</div>
                        <span>IP:</span>
                        <input type="text" disabled="disabled" value=<%=request.getAttribute("ip")%>>
                        <span>本次历时:</span>
                        <input type="text" disabled="disabled" value=<%=request.getAttribute("duration")%>>
                </div>--%>
              <div style="width:100%;min-width:1024px;height: auto;min-height: 100px;">
                      <fieldset style="min-height:80px;border-color: #AED0EA;border-radius:5px;padding: 10px;display: block;">
                              <legend style="margin-left: 10px">信息查询</legend>
                              部门编号:&nbsp;<input id="departmentNo" class="easyui-textbox" />&nbsp;
                              部门名称:&nbsp;<input id="departmentName" class="easyui-textbox" />


                              <a id="serachBtn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
                      </fieldset>
              </div>
              <div id="dataInfo" style="width:100%;min-width:1024px;height: auto;">
                      <div id="dialog"></div>
                      <table id="dg" >
                      </table>

              </div>

        </div>
        <div title="Tab3" data-options="closable:true,fit:true" style="padding:20px;display:none;">
                tab3
        </div>
</div>
<script type="text/javascript">
//        alert($("#dataInfo").width());
//        alert(document.body.clientWidth);

    function fixWidth(percent)
    {
        return ($("#dataInfo").width()) * percent ;
    }
    $(function () {
        $('#serachBtn').on('click',function () {
            $('#dg').datagrid('load',{
                'departmentCustom.departmentNo': $('#departmentNo').val(),
                'departmentCustom.departmentName': $('#departmentName').val()
            });


        });

        var browser = zcp.getBrowser();
        if ("Firefox" == browser){
            $("#dataInfo").css("min-height","372px");
        }else if("Chrome" == browser){
            $("#dataInfo").css("min-height","399px");
        }else if("IE" == browser){
            $("#dataInfo").css("min-height","415px");
            alert("ie");
        }else{
            $("#dataInfo").css("min-height","350px");
        }

        $("#dg").datagrid({
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
                {field:'departmentId',title:'id',checkbox:true,width:fixWidth(0.1)},
                {field:'departmentNo',title:'部门编号',width:fixWidth(0.1)},
                {field:'departmentName',title:'部门名称',width:fixWidth(0.2)},
                {field:'departmentPhone',title:'部门电话',width:fixWidth(0.2)},
                {field:'status',title:'部门状态',width:fixWidth(0.1)},
                {field:'createTime',title:'创建时间',width:fixWidth(0.3),
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
            onLoadSuccess: function () {
                $(this).datagrid('clearSelections');
                $(this).datagrid('clearChecked');
            },
            toolbar: [{
                iconCls: 'icon-add',
                text: '添加',
                handler: function(){
                    //$.messager.alert('提示','添加按钮','info');
                    $('#dialog').dialog({
                        title: '添加',
                        width: 600,
                        height: 400,
                        closed: false,
                        cache: false,
                        resizable:true,
                        method:'POST',
                        maximizable:true,
                        href: '${pageContext.request.contextPath}/department/initAdd.action',
                        modal: true,
                        onClose:function () {
                            $('#dg').datagrid('reload');
                        }
                    });
//                    $('#dd').dialog('refresh', 'new_content.php');
                }
            },'-',{
                iconCls: 'icon-edit',
                text: '修改',
                handler: function(){
//                    $.messager.alert('提示','修改按钮','info');
                    var rows = $("#dg").datagrid('getChecked');
                    var len = rows.length;
                    if (0 >= len){
                        $.messager.alert('提示','请选择一行','info');
                        return;
                    }else if(2 <= len){
                        $.messager.alert('提示','只能选择一行','info');
                        return;
                    }
                    $('#dialog').dialog({
                        title: '修改',
                        width: 600,
                        height: 400,
                        closed: false,
                        cache: false,
                        resizable:true,
                        method:'POST',
                        maximizable:true,
                        href: '${pageContext.request.contextPath}/department/initUpdate.action',
                        modal: true,
                        queryParams: {
                            'id':$("#dg").datagrid('getChecked')[0].departmentId
                        },
                        onClose:function () {
                            $('#dg').datagrid('reload');
                        }
                    });
                }
            },'-',{
                iconCls: 'icon-remove',
                text: '删除',
                handler: function(){
                    var rows = $("#dg").datagrid('getChecked');
                    var len = rows.length;
                    var ids = [];
                    for(var i = 0; i < len; i++){
                        ids.push(rows[i].departmentId);
                    }
                    $.messager.confirm('提示','你确定要删除吗？',function (val) {
                        if (!val){
                            return;
                        }
                        zcp.ajaxRequest('${pageContext.request.contextPath}/department/delete.action',
                            {'ids':ids},function (data) {
                                if(true === data.status){
                                    $('#dg').datagrid('reload');
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
                    var rows = $("#dg").datagrid('getChecked');
                    var len = rows.length;
                    if (0 >= len){
                        $.messager.alert('提示','请选择一行','info');
                        return;
                    }else if(2 <= len){
                        $.messager.alert('提示','只能选择一行','info');
                        return;
                    }
                    $('#dialog').dialog({
                        title: '查看',
                        width: 600,
                        height: 400,
                        closed: false,
                        cache: false,
                        resizable:true,
                        method:'POST',
                        maximizable:true,
                        href: '${pageContext.request.contextPath}/department/initQueryDetail.action',
                        modal: true,
                        queryParams: {
                            'id':$("#dg").datagrid('getChecked')[0].departmentId
                        },
                        onClose:function () {
                            $('#dg').datagrid('reload');
                        }
                    });
                }
            }]
        });
    });


</script>
