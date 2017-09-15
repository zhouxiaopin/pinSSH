/**
 * Created by Administrator on 2017/9/15.
 */
window.zcp = {
    ajaxRequest: function (path, data, success, ptype, error, timeout, async) {

        if (!ptype || ptype.toLowerCase() != "get"){
            ptype = "post";
        }
        if (async == undefined) {
            async = true;
        }
        $.ajax({
            url: path,
            type: ptype,
            data: data,
            async: async,
            dataType: "json",
            timeout: (timeout == undefined || timeout == null) ? 15000 : timeout,
            success: success,
            error: function (xhr, textStatus, errorThrown) {
                if (errorThrown == 'timeout') {
                    $.messager.alert('提示','服务器繁忙,请稍后再试','info');
                }
            }

        });
    },
    getBrowser: function(){
        var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
        var isOpera = userAgent.indexOf("Opera") > -1;
        //判断是否Opera浏览器
        if (isOpera) {
            return "Opera"
        }
        //判断是否Firefox浏览器
        if (userAgent.indexOf("Firefox") > -1) {
            return "Firefox";
        }
        //判断是否Chrome浏览器
        if (userAgent.indexOf("Chrome") > -1){
            return "Chrome";
        }
        //判断是否Safari浏览器
        if (userAgent.indexOf("Safari") > -1) {
            return "Safari";
        }
        //判断是否IE浏览器
        if (userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !isOpera) {
            return "IE";
        }
    }
}
