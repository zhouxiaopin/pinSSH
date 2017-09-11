<%@ page language="java" pageEncoding="UTF-8"%>
<div id="aa" class="easyui-accordion" data-options="border:false" style="width:100%;height:100%;">
    <div title="Title1" data-options="selected:true">
        <ul id="tt"></ul>
    </div>
</div>
<script type="text/javascript">
    $('#tt').tree({
        data: [{
            text: 'Item1',
            state: 'closed',
            children: [{
                text: 'Item11'
            },{
                text: 'Item12'
            }]
        },{
            text: 'Item2',
            state: 'closed',
            children: [{
                text: 'Item21'
            },{
                text: 'Item22'
            }]
        }]
    });


</script>
