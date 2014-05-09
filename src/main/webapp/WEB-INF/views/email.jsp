<%@ include file="sharedHead.jsp"%>
<%@ include file="header.jsp"%>

<html>
<body>

<div class="container-fluid appContainer">
    <div class="col-xs-12 col-sm-10 col-sm-offset-1" role="form">
        <form class="form-horizontal" action="site/contactUs" method="post">
            <legend>
                <h2>Contact Us</h2>
            </legend>

            <div class="form-group">
                <label for="inputFirstName" class="col-sm-2 control-label">
                    First Name <span class="glyphicon glyphicon-asterisk"></span>
                </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputFirstName" placeholder="First Name">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2">
                    <button type="submit" class="btn btn-default" name="submitBtn" id="submitBtn" value="Submit">
                        Submit
                    </button>
                </div>
            </div>

        </form>
    </div>
</div>

</body>
</html>
