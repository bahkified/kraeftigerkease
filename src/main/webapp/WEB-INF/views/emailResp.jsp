<%@ include file="sharedHead.jsp"%>
<%@ include file="header.jsp"%>

<html>
<head>
    <script>
        var response_message = "<c:out value="${message}"/>";
    </script>
</head>
<body>

<div class="container-fluid appContainer">
    <div class="col-xs-12 col-sm-10 col-sm-offset-1">
        <c:out value="${message}"/>
    </div>
</div>

</body>
</html>
