<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="easyui-tabs" data-options="border:false" style="width:100%;height:100%;">
        <div title="我的桌面" style="display:none;background: #FFffff;">
                <jsp:include page="../common/jsp/myDesktop.jsp" flush="true"/>
        </div>
        <div title="部门管理" data-options="closable:true,fit:true" style="padding:20px;">
                <div>收拾
                </div>
                <table id="dg" style="width:100%"></table>
        </div>
        <div title="Tab3" data-options="closable:true,fit:true" style="padding:20px;display:none;">
                tab3
        </div>
</div>
<script type="text/javascript">
    $("#dg").datagrid({
        url: '${pageContext.request.contextPath}/department/list.action?time=' + new Date().getTime(),
        type: 'POST',
        columns : [[
            {field:'departmentId',hidden:true},
            {field:'departmentNo',title:'部门编号',width:100},
            {field:'departmentName',title:'部门名称',width:100},
            {field:'departmentPhone',title:'部门电话',width:100},
            {field:'status',title:'部门状态',width:100},
            {field:'createTime',title:'创建时间',width:100}
        ]],
        toolbar: [{
            iconCls: 'icon-add',
            handler: function(){alert('添加按钮')}
        },'-',{
            iconCls: 'icon-edit',
            handler: function(){alert('修改按钮')}
        },'-',{
            iconCls: 'icon-remove',
            handler: function(){alert('删除按钮')}
        }],
        striped:true,//奇偶行显示不同颜色
        rownumbers:true,//显示行号
        idField:"departmentId",
        fitColumns : true,
        singleSelect : true,
        pagination : true,
        pageNumber : 1,
        pageSize : 10,
        pageList : [10,20,30,40,50],
        fit:true,
        queryParams: {

            'departmentCustom.departmentName':'技术'
        },
        onLoadSuccess : function (data) {
            alert(JSON.stringify(data));
        }
    });
    /*$.ajax({
        url: '${pageContext.request.contextPath}/department/list.action?time=' + new Date().getTime(),
        type: 'POST',
        dataType: 'JSON',
        contentType: "application/json",
        error: function(request) {
            alert(JSON.stringify(request));
            alert("出错了，请稍候再试");
        },
        success: function (data) {
            //alert(JSON.stringify(data));


            $('#dg').datagrid({
                data: data
            });


        }
    });*/
</script>
