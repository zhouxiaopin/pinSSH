<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style rel="stylesheet" type="text/css">
    .header{
        margin: 0 auto;
        height: 88px;
        width:auto;
    }
    .header-bg{
        background:url("${pageContext.request.contextPath}/ticc/common/images/header_top_v.jpg");
        filter:"progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale')";
        -moz-background-size:100% 100%;
        background-size:100% 100%;
        *background-color:#F2F5F7;
        *background: -webkit-gradient(linear, 0 0, 0 100%, from(#F2F5F7), to(#F2F5F7));
        *background: -webkit-linear-gradient(left, #F2F5F7, #F2F5F7);
        *background: -moz-linear-gradient(left, #F2F5F7, #F2F5F7);
        *background: -o-linear-gradient(left, #F2F5F7, #F2F5F7);
        *background: -ms-linear-gradient(left, #F2F5F7, #F2F5F7);
        *background: linear-gradient(left, #F2F5F7, #F2F5F7);
        filter: progid:DXImageTransform.Microsoft.gradient(GradientType = 1, startColorstr = #F2F5F7, endColorstr = #F2F5F7);

    }
    .header-logo{
        padding-left:50px;
        padding-top:4px;
        float:left;
        width:20%
    }
    .header-right{
        color:#2779AA;
        padding-top:14px;
        padding-right:20px;
        float:right;
        width:303px;
        display:block;
        text-align:right;
    }
    .header-rigth-fa{
        font:normal 12px "微软雅黑";
        text-align:left;
    }
    .header-right-fa-a{
        color:#FFFFFF;
        padding-right:12px;
        padding-left:12px;
    }
    .header-feige{
        background:url(${pageContext.request.contextPath}/ticc/common/images/header_feige.png) no-repeat scroll center center;
        width:2px;
        height:12px;
    }
    .header-right-wel{
        margin-top:14px;
        width:303px;
        height:28px;
        background:url(${pageContext.request.contextPath}/ticc/common/images/member_logo.png) center no-repeat;
        background-size:100% 100%;
        color:#2779AA;
        /*padding-right:6px;*/
        /*float:right;*/
        text-align:left;
        vertical-align:middle;
        font-size:14px;
    }
    .header-right-wel-img{
        padding-top:5px;
        padding-left:8px;
        float:left;
    }
    .header-right-wel-i{
        padding-top:0px;
        color:#2779AA;
        line-height:28px;
        vertical-align:top;
        float:left;
        padding-left:11px;
    }
    .header-right-wel-ir{
        padding-top:0px;
        color:#2779AA;
        line-height:28px;
        vertical-align:top;
        float:right;
        padding-right:6px
    }
    .header-right-wel-ad {
        padding-left:11px;
        color:#2779AA

    }
</style>
<div class="header header-bg">
    <div class="header-logo"><img src="${pageContext.request.contextPath}/ticc/common/images/logo.png"/></div>
    <div class="header-right">
        <div class="header-rigth-fa">
            <a href="#" target="_self" onclick="window.external.AddFavorite(location.href, document.title);" class="header-right-fa-a" style="padding-left:0px">收藏本站</a> <i class="header-feige">&nbsp;&nbsp;&nbsp;</i>

            <a href="#" onclick="refresh();"  target="_self" class="header-right-fa-a">刷新</a> <i class="header-feige">&nbsp;&nbsp;&nbsp;</i>

            <a  href="javascript:void(0);" target="_self"  onclick="y('${pageContext.request.contextPath}/afw/system/pwdModify.jsp')"  class="header-right-fa-a">更改密码</a> <i class="header-feige">&nbsp;&nbsp;&nbsp;</i>

            <a href="${pageContext.request.contextPath}/loginAction!logout.action" target="_self" class="header-right-fa-a">退出</a>
        </div>
        <div class="header-right-wel">
            <div class="header-right-wel-img"><img src="${pageContext.request.contextPath}/ticc/common/images/touxiang.png"/></div>

            <div class="header-right-wel-i">${_sysUser_.userNo}</div>
            <div class="header-right-wel-ir">欢迎来到本系统！.当前版本:V1.0.0</div>
        </div>
    </div>
    <div class="clr"></div>
</div>
