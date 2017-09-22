/**
 * Created by Administrator on 2017/9/21.
 */
window.ticcFrame = {
    intiDatagrid: function (title,elementId,controllerRequestPath,idField,columns,toolbar) {
        $(elementId).datagrid({
            url: controllerRequestPath+'/list.action?time=' + new Date().getTime(),
            type: 'POST',
            title: title,
            idField:idField,
//            singleSelect : true,
            striped: true,
            fitColumns: true,
            fit: true,
            rownumbers: true,
            pagination : true,
            pageNumber : 1,
            pageSize : 10,
            pageList : [10,20,30,40,50],
            columns : columns,
            onLoadError: function () {
                $.messager.alert('提示','系统繁忙,请稍后再试','error');
            },
            onLoadSuccess: function (data) {
                $(this).datagrid('clearSelections');
                $(this).datagrid('clearChecked');
            },
            toolbar:toolbar
           /* toolbar: [{
                iconCls: 'icon-add',
                text: '添加',
                handler: function(){
                    $('.dialog').dialog({
                        title: '添加',
                        href: controllerRequestPath+'/initAdd.action',
                        onClose:function () {
                            $(elementId).datagrid('reload');
                        }
                    });
//                    $('#dd').dialog('refresh', 'new_content.php');
                }
            },'-',{
                iconCls: 'icon-edit',
                text: '修改',
                handler: function(){
                    if (!ticcFrame.datagridCheckOne(elementId)){
                        return;
                    }
                    $('.dialog').dialog({
                        title: '修改',
                        href: controllerRequestPath+'/initUpdate.action',
                        queryParams: {'id':$(elementId).datagrid('getChecked')[0][idField]},
                        onClose:function () {
                            $(elementId).datagrid('reload');
                        }
                    });
                }
            },'-',{
                iconCls: 'icon-remove',
                text: '删除',
                handler: function(){
                    var rows = $(elementId).datagrid('getChecked');
                    var len = rows.length;
                    var ids = [];
                    for(var i = 0; i < len; i++){
                        ids.push(rows[i][idField]);
                    }
                    $.messager.confirm('提示','你确定要删除吗？',function (val) {
                        if (!val){
                            return;
                        }
                        ticc.ajaxRequest(controllerRequestPath+'/delete.action',
                            {'ids':ids},function (data) {
                                if(true === data.status){
                                    $(elementId).datagrid('reload');
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
                    if (!ticcFrame.datagridCheckOne(elementId)){
                        return;
                    }
                    $('.dialog').dialog({
                        title: '查看',
                        href: controllerRequestPath+'/initQueryDetail.action',
                        queryParams: {'id':$(elementId).datagrid('getChecked')[0][idField]},
                        onClose:function () {
                            $(elementId).datagrid('reload');
                        }
                    });
                }
            }]*/
        });
    },
    datagridCheckOne: function (elementId) {
        var rows = $(elementId).datagrid('getChecked');
        var len = rows.length;
        if (0 >= len){
            $.messager.alert('提示','请选择一行','info');
            return false;
        }else if(2 <= len){
            $.messager.alert('提示','只能选择一行','info');
            return false;
        }
        return true;
    }
};