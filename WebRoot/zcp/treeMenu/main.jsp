<%@ page language="java" pageEncoding="UTF-8"%>
<div class="easyui-tabs" data-options="border:false" style="width:100%;height:100%;">
        <div title="我的桌面" style="display:none;background: #FFffff;">
                <jsp:include page="../common/jsp/myDesktop.jsp" flush="true"/>
        </div>
        <div title="Tab2" data-options="closable:true,fit:true" style="padding-bottom:20px;">
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
        url : '${pageContext.request.contextPath}/EmpServlet?time=' + new Date().getTime(),
        columns : [[
            {field:'empno',title:'编号',width:100},
            {field:'ename',title:'姓名',width:100},
            {field:'job',title:'工作',width:100},
            {field:'mgr',title:'上编',width:100},
            {field:'hiredate',title:'入时',width:100},
            {field:'sal',title:'月薪',width:100},
            {field:'comm',title:'佣金',width:100},
            {field:'deptno',title:'部编',width:100}
        ]],
        fitColumns : true,
        singleSelect : true,
        pagination : true,
        pageNumber : 1,
        pageSize : 10,
        pageList : [10,20,30,40,50],
        fit:true
    });
</script>
