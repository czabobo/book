<%@page pageEncoding="UTF-8" contentType="text/html; utf-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="app"></c:set>
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
            $("#btn").click(function () {
                $("#ul_com").empty();
                var comment = $("#comment").val();
                $.ajax({
                    url: "${app}/comment/add",
                    data: {"comment": comment},
                    dataType: "json",
                    type: "post",
                    success: function (data) {
                        $.each(data, function (index, comment) {
                            var li = $("<li>").html("用户" + comment.name + "：" + comment.comment)
                            $("#ul_com").append(li);
                        })
                    }
                })
            })
        })
    </script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <c:forEach var="book" items="${requestScope.books}">
            <div class="col-md-3">
                <img src="${app}/img/${book.image}" class="img-responsive" alt="Responsive image">
                <input type="text" placeholder="请输入评论..." id="comment">
                <input type="button" value="提交" id="btn">
            </div>
            <div class="col-md-1">
            </div>
        </c:forEach>
    </div>
</div>
<hr>
<ul id="ul_com">
</ul>
</body>
</html>