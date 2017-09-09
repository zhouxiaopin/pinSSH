<%@ page language="java" pageEncoding="UTF-8"%>
<div class="easyui-tabs" data-options="border:false" style="width:100%;height:100%;">
        <div title="我的桌面" style="display:none;background: #FFffff;">
                <div id="ind_right" style="width: 98%">

                        <div style="width: 98%">&nbsp;&nbsp;&nbsp;&nbsp;</div>
                        <div class="ind_right_title" style="width: 98%"><strong style='border-bottom: 3px solid rgb(255, 116, 0);font-size:14px'>我的中心</strong></div>
                        <div class="ind_right_box" style="width: 98%">
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr style=" background-color: #fff7e3;">
                                                <td width="25%" align="right"  class="td3"><strong>登录帐号：</strong></td>
                                                <td width="75%" class="td3">${_sysUser_.userNo }</td>
                                        </tr>
                                        <tr  style=" background-color: #fefdf4;">
                                                <td align="right"  class="td3"><strong>登录名称：</strong></td>
                                                <td class="td3">${_sysUser_.userName }</td>
                                        </tr>

                                        <tr style=" background-color: #fff7e3;">
                                                <td align="right"  class="td3"><strong>本次登录IP：</strong></td>
                                                <td class="td3">${_sysUser_.loginIp }&nbsp;</td>
                                        </tr>
                                        <tr  style=" background-color: #fefdf4;">
                                                <td align="right"  class="td3"><strong>本次登录时间：</strong></td>
                                                <td class="td3"><fm:formatDate value="${_sysUser_.loginTime }" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;</td>
                                        </tr>
                                        <tr style=" background-color: #fff7e3;">
                                                <td align="right"  class="td3"><strong>上次登录IP：</strong></td>
                                                <td class="td3">${_sysUser_.lastLoginIp }&nbsp;</td>
                                        </tr>
                                        <tr  style=" background-color: #fefdf4;">
                                                <td align="right" class="td3"><strong>上次登录时间：</strong></td>
                                                <td class="td3"><fm:formatDate value="${_sysUser_.lastLoginTime }" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;</td>
                                        </tr>
                                        <!--
                                        <tr>
                                          <td align="right" bgcolor="#e4e4e4" class="td4"><strong>版本号：</strong></td>
                                          <td class="td4">v.2012.08.16</td>
                                        </tr>
                                         -->
                                </table>
                        </div>
                </div>
        </div>
        <div title="Tab2" data-options="closable:true,fit:true" style="overflow:auto;padding:20px;display:none;">
                tab2
        </div>
        <div title="Tab3" data-options="closable:true,fit:true" style="padding:20px;display:none;">
                tab3
        </div>
</div>
