<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="aa" class="easyui-accordion" data-options="border:false" style="width:100%;height:100%;">
    <div title="Title1" data-options="selected:true">
        <ul id="tt"></ul>
    </div>
</div>
<script type="text/javascript">
    zcp.ajaxRequest('${pageContext.request.contextPath}/sysMenu/getComboTree.action',
        null,function (data) {

            $('#tt').tree({data: data});
        });


</script>
