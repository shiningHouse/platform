/**
 * Created by Administrator on 2016/4/28.
 */
var Main = {};
/**
 * post请求
 * @param url 请求路径
 * @param data 参数{key:value,...}
 * @param callback 回调函数
 */
Main.post = function (url, data, callback) {
    $.post(rootPath + url + "?etc=" + new Date().getTime(), data, callback);
};

/**
 * getJSON请求
 * @param url 请求路径
 * @param data 参数{key:value,...}
 * @param callback 回调函数
 */
Main.getJson = function (url, data, callback) {
    $.getJSON(rootPath + url + "?etc=" + new Date().getTime(), data, callback);
}

/**
 * 刷新面板
 * @param tableId gridtable列表Id
 */
Main.refreshPanel = function (tableId) {
    $("#" + tableId).parent().panel({
        fit: true,
        tools: [{
            iconCls: 'icon-reload',
            handler: function () {
                $("#tab").tabs('getSelected').panel("refresh");
            }
        }]
    });
}

/**
 * 打开弹出窗口
 */
Main.openWin = function (option) {
    var defaults = {
        width: 600,
        height: 400,
        modal: true,
        minimizable: false,
        maximizable: false,
        collapsible: false,
        resizable: false,
        iconCls: "icon-save",
        top:($(window).height() - 400) * 0.2,
        left:($(window).width() - 600) * 0.4
    };
    var _$winObj = null;
    if ($("#" + option.id).length > 0) {
        _$winObj = $("#" + option.id);
    } else {
        _$winObj = $("<div id='" + option.id + "'></div>");
    }
    var win = _$winObj.window($.extend({}, defaults, option || {})).window(
        "open");
    if (option.url)
        win.window("refresh", rootPath + option.url);
    return win;
}

Main.showErrorMsg = function (formId, errorJson) {
    // 系统错误
    if (errorJson != null && !errorJson.match("^\{(.+:.+,*){1,}\}$")) {
        $.messager.alert("操作失败", errorJson);
    } else {// 校验错误
        var errorResult = $.parseJSON(errorJson);
        if (errorResult.field) {
            var field = errorResult.field;
            var message = errorResult.message;
            var fidldElm = $("#" + formId + " [name='" + field + "']");
            fidldElm.after("<label class='error' for='" + field
                + "' generated='true'>" + message + "</label>");
            fidldElm.keydown(function () {
                $(this).parent().find("label[for='" + field + "']").remove();
            });
        }
    }
}

Main.ok = function (msg, callback) {
    $.messager.alert("提示", "<img src='" + rootPath + "/static/img/ok_icon.png' />&nbsp;&nbsp;<span style='vertical-align: top;'>" + msg + "</span>", null,
        callback);
}

//
// // 提交遮罩
// $.blockUI.defaults = $.extend({}, $.blockUI.defaults, {
//     message: "<img src='" + rootPath + "/static/img/icons/loading.gif'/>",
//     css: {
//         border: 'none',
//         padding: '15px',
//         width: "20px",
//         top: "0px",
//         left: "0px",
//         opacity: 1
//     },
//     overlayCSS: {
//         backgroundColor: '#dddddd',
//         opacity: 0.6,
//         cursor: 'wait'
//     }
// });
//
//
// // 拓展treegrid
// $.extend($.fn.treegrid.methods, {
//     cascadeCheckBox: function (target, idField) {
//         var checkBoxObj = $(target).treegrid("getPanel").find("[node-id]")
//             .find("input[type='checkbox']");
//         checkBoxObj.change(function () {
//             var id = $(this).parents("[node-id]").attr("node-id");
//             var checkParentNode = function (currentObj, id) {
//                 var parentNode = $(target).treegrid("getParent", id);
//                 if (parentNode) {
//                     var parentId = parentNode[idField];
//                     if (currentObj.is(":checked")) {
//                         var parentObj = $(target).treegrid("getCheckBox",
//                             parentId).attr("checked", "checked");
//                         checkParentNode(parentObj, parentId);
//                     }
//
//                 }
//             };
//             checkParentNode($(this), id);
//
//         });
//     },
//     getCheckBox: function (target, id) {
//         var checkBoxObj = $(target).treegrid("getPanel").find(
//             "[node-id='" + id + "']").find("input[type='checkbox']");
//         return checkBoxObj;
//     },
//     getCheckedIds: function (target) {
//         var authIdsAry = [];
//         var panelObj = $(target).treegrid("getPanel");
//         panelObj.find("[node-id]").each(function (i) {
//             if ($(this).find("input[type='checkbox']:checked").length > 0) {
//                 authIdsAry.push($(this).attr("node-id"));
//             }
//         });
//         return authIdsAry.join(",");
//     }
//
// });
//
// // 拓展datagrid
// $.extend($.fn.datagrid.methods, {
//     getCheckBox: function (target, indexId) {
//         var checkBoxObj = $(target).datagrid("getPanel").find("[datagrid-row-index='" + indexId + "']").find("input[type='checkbox']");
//         return checkBoxObj;
//     },
//     getCheckedIds: function (target, idFieldName) {
//         var idsAry = [];
//         var panelObj = $(target).datagrid("getPanel");
//         panelObj.find("[datagrid-row-index]").each(
//             function (i) {
//                 if ($(this).find("input[type='checkbox']:checked").length > 0) {
//                     idsAry.push($(this).find("[field='" + idFieldName + "']").text());
//                 }
//             });
//         return idsAry.join(",");
//     },
//     getNativeCheckedIds: function (target, idFieldName) {
//         var checkedRows = $(target).datagrid("getChecked");
//         var idsAry = [];
//         for (var i = 0; i < checkedRows.length; i++) {
//             idsAry.push(checkedRows[i][idFieldName]);
//         }
//         return idsAry.join(",");
//     },
//     showCellTip: function (target, fieldName) {
//         $(target).datagrid({
//             onLoadSuccess: function () {
//                 var cellObj = $(target).datagrid("getPanel").find("td[field='" + fieldName + "']");
//                 cellObj.each(function (i) {
//                     var content = $(this).text();
//                     $(this).tooltip({
//                         content: content
//                     });
//                 });
//
//             }
//         });
//
//     }
// });

/**
 * 格式化时间格式
 * @returns {string}
 */
Main.formatDate = function(val , row){
    if(val == null )
        return "";
    return new Date(parseInt(val)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
};

function formatDate2 (val){
    if(val == null )
        return "";
    var date = new Date(val);
    var Y = date.getFullYear() + '-';
    var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    var D = (date.getDate() < 10 ? '0'+(date.getDate()) : date.getDate()) + ' ';
    var h = (date.getHours() < 10 ? '0'+(date.getHours()) : date.getHours()) + ':';
    var m = (date.getMinutes() < 10 ? '0'+(date.getMinutes()) : date.getMinutes());
    return Y+M+D+h+m;
}

function formatTime(val){
    if(val == null )
        return "";
    var date = new Date(val);
    var h = date.getHours() + ':';
    var m = (date.getMinutes() < 10 ? '0'+(date.getMinutes()) : date.getMinutes());
    return h+m;
}

function removeSecond(val){
    if(val == null )
        return "";
    var time = val.split(":");
    return time[0] + ":" + time[1];
}

// Main.tab = function(title, url, type, icon){
//     if (typeof icon == 'undefined') {
//         icon = "app_icon_picture";
//     }
//     var tab = $("#tab");
//     if (tab.tabs("exists", title)) {
//         tab.tabs("select", title);
//     } else {
//         tab.tabs("add", {
//             title : title,
//             closable : true,
//             icon : icon
//         });
//         url = rootPath + url;
//         if (typeof type == 'undefined' || type == 'iframe') {
//             var subtab = tab.tabs('getSelected');
//             var content = '<iframe scrolling="auto" frameborder="0"  src="'
//                 + url + '" style="width:100%;height:100%;"></iframe>';
//             tab.tabs('update', {
//                 tab : subtab,
//                 options : {
//                     content : content
//                 }
//             });
//         } else {
//             tab.tabs('getSelected').panel("refresh", url);
//         }
//     }
// }
//
// /**
//  * 流程追踪
//  * @param id 流程实例ID
//  */
// Main.processTrace= function (id) {
//     Main.openWin({
//         id: "showTraceDetailWin",
//         width: 1000,
//         height: 700,
//         title: "审批跟踪",
//         iconCls: $(this).attr("iconCls"),
//         url: "/workflow/process/showTrace/"+id
//     });
// }
//
// Main.styleStauts = function(value,row,index){
//     return 'background-color:#64B4E2;';
// }
//
// /**
//  * 流程追踪
//  * @param val 流程实例ID
//  * @param row
//  */
//
// Main.formatTrace = function(val, row) {
//     if (val == '' || val == null) {
//         return "<a href='javascript:void(0)'>" + "" + "</a>";
//     } else {
//         return "<a href='javascript:void(0)' onclick='Main.processTrace(" + val + ")'>" + "审批跟踪" + "</a>";
//     }
// }

;(function ($) {
    $(document).ready(function () {
    }).keydown(function (e) {
        if (e.which === 27) {
            /** ESC键按下时关闭弹出窗口！ */
            $(".panel-tool-close").click();
        }
    });
})(jQuery);