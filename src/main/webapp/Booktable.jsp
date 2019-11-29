<%@page pageEncoding="UTF-8" contentType="text/html; utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="app" value="${pageContext.request.contextPath}"></c:set>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <%--引入bootstrap的核心css--%>
    <link rel="stylesheet" href="${app}/boot/css/bootstrap.min.css">
    <%--引入jqgrid的核心css--%>
    <%--jqgird的主题css--%>
    <link rel="stylesheet" href="${app}/jqgrid/css/trirand/ui.jqgrid-bootstrap.css">
    <%--引入jquery的js--%>
    <script src="${app}/boot/js/jquery-3.3.1.min.js"></script>
    <%--引入bootstrap的js--%>
    <script src="${app}/boot/js/bootstrap.min.js"></script>
    <%--jqgird的国际化js--%>
    <script src="${app}/jqgrid/js/trirand/i18n/grid.locale-cn.js"></script>
    <%--jqgird的js--%>
    <script src="${app}/jqgrid/js/trirand/jquery.jqGrid.min.js"></script>
    <script>
        $(function () {
            $("#tb").jqGrid({
                //表格名称
                caption: "图书表",
                styleUI: "Bootstrap",
                url: "${app}/book/selectByPage",
                datatype: "json",
                mtype: "post",
                //宽度自动匹配
                autowidth: true,
                //分页 rowNum:每页展示几条 rowList:每页展示几条的集合
                pager: "#page",
                rowNum: 2,
                rowList: [2, 4, 8],
                //显示总条数
                viewrecords: true,
                //全选(在表的第一列添加复选框)
                multiselect: true,
                //增删改的时候发送请求的位置
                editurl: "${app}/book/edit",
                colNames: ["编号", "书名", "作者", "封面", "内容", "操作"],
                colModel: [
                    {
                        name: "id"
                    },
                    {
                        name: "name",
                        editable: true,
                    },
                    {
                        name: "author",
                        editable: true,
                    },
                    {
                        name: "image",
                        formatter: function (cellvalue, options, rowObject) {
                        }
                    },
                    {
                        name: "content",
                        editable: true,
                    },
                    {
                        name: "xxxxx",
                        formatter: function (cellvalue, options, rowObject) {
                            return "<a href=\"javascript:edit('" + rowObject.id + "')\" class=\"btn btn-warning\"><span class=\"glyphicon glyphicon-pencil\"></span></a> <a href=\"javascript:del('" + rowObject.id + "')\" class=\"btn btn-danger\"><span class=\"glyphicon glyphicon-trash\"></span></a>";
                        },
                    },
                ],
            }).jqGrid("navGrid", "#page", {edit: false, del: false, refresh: false, search: false})


            $("#btn_add").click(function () {
                //表格选择器调用了editGridRow方法要new(创建)一个(模态框){height : 300, reloadAfterSubmit : true}
                $("#tb").jqGrid('editGridRow', "new", {
                    height: 300,
                    reloadAfterSubmit: true
                });
            })

        })

        function edit(gr) {
            //gr是选中的某一行的id
            jQuery("#tb").jqGrid('editGridRow', gr, {
                height: 300,
                reloadAfterSubmit: true
            });
        }

        function del(gr) {
            //gr是选中的某一行的id
            $("#tb").jqGrid('delGridRow', gr, {
                reloadAfterSubmit: true
            });
        }
    </script>
</head>
<body>

<table id="tb"></table>

<div id="page"></div>


</body>
</html>