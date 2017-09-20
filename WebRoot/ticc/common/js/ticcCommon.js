/**
 * Created by Administrator on 2017/9/15.
 */
window.ticc = {
    /**
     * ajax请求
     * @param path  请求路径
     * @param data   参数
     * @param success   请求成功回调函数
     * @param ptype     请求方式
     * @param error     请求失败回调函数
     * @param timeout   请求超时时间
     * @param async      是否是异步请求
     */
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
    },
    /**
     *
     * @param element 元素
     * @param percent   百分比
     * @returns {number}
     */
    getFixWidth: function(element,percent){
        return ($(element).width()) * percent ;
    }
}
