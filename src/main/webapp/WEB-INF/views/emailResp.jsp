<%@ include file="sharedHead.jsp"%>
<%@ include file="header.jsp"%>

<html>
<body>

<div class="container-fluid appContainer">
    <div class="col-xs-12 col-sm-10 col-sm-offset-1">
        <div class="row">
            <c:out value="${message}"/>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>
