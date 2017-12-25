/**
 *公用方法，获取项目名
 * 获取项目名 如: /activiti
 **/
function getProjectPath() {
    var strPath = window.document.location.pathname;
    var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
    return postPath;
}


/**
 * 获取页面中的值传递get方式
 * @param key
 * @returns {*}
 */
function getRequestParam(key) {
    var strHref = window.document.location.href;
    var intPos = strHref.indexOf("?");
    var strRight = strHref.substr(intPos + 1);

    var arrTmp = strRight.split("&");
    for (var i = 0; i < arrTmp.length; i++) {
        var arrTemp = arrTmp[i].split("=");
        if (arrTemp[0].toUpperCase() == key.toUpperCase()) {
            return arrTemp[1];
        }
    }
    return "";
}

/**
 * 将获取的obj对象的属性名添加前缀entity.
 * @param obj
 * @returns {{}}
 */
function tool_transferFormValues(obj) {
    var objdata = {};
    if (obj != null) {
        for (var key in obj) {
            var value = obj[key];
            if (value) {
                objdata["entity." + key] = obj[key];
            }
        }
    }
    return objdata
}
