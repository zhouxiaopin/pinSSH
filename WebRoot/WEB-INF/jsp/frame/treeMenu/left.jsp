<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="leftMenu" class="easyui-accordion" data-options="border:false" style="width:100%;height:100%;">
</div>
<script type="text/javascript">
    ticc.ajaxRequest('${pageContext.request.contextPath}/sysMenu/getComboTree.action',
        {levelCode:'1',isGetSubTree:true},function (data) {
            var $leftMenu = $('#leftMenu');

            for(var i = 0, len = data.length; i < len; i++){
                if(i == 0){
                    $leftMenu.accordion('add', {
                        title: data[i].text,
                        content: "<ul id='treeMenu"+i+"'></ul>",
                        selected: true
                    });
                }else{
                    $leftMenu.accordion('add', {
                        title: data[i].text,
                        content: "<ul id='treeMenu"+i+"'></ul>",
                        selected: false
                    });
                }
                $('#treeMenu'+i).tree({
                    data: data[i].children,
                    onSelect:function (node) {
//                        alert(JSON.stringify(node));
                        if($(this).tree('isLeaf',node.target)){

                            var $mainTabs = $('#mainTabs');
                            var len = $mainTabs.tabs('tabs').length;
                            /*判断tab数量*/
                            if (len > 14){
                                $.messager.alert('提示','选项卡数量太多了','warning');
                                return;
                            }
                            var exists = $mainTabs.tabs('exists',node.text);
                            /*判断tab是否已经存在*/
                            if (exists){
                                /*tab存在，选中*/
                                $mainTabs.tabs('select',node.text);
                                return;
                            }
                            $mainTabs.tabs('add',{
                                <%--href:'${pageContext.request.contextPath}/'+node.attributes.url,--%>
                                href:'${pageContext.request.contextPath}/department/initQuery.action',
                                method:'post',
                                title: node.text,
                                selected: true,
                                closable:true,
                                fit:true,
                                style:{padding:'5px'}
                            });
                        }

                    }
                });
            }

        });


</script>
