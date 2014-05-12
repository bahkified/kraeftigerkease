<%@ include file="sharedHead.jsp"%>
<%@ include file="header.jsp"%>

<html>
<body>

<div class="container-fluid appContainer">
    <div class="col-xs-12 col-sm-10 col-sm-offset-1" role="form">
        <script src='js/jqBootstrapValidation.js' ></script>
        <script>
            $(function () { $("input").not("[type=submit]").jqBootstrapValidation(); } );
        </script>

        <form class="form-horizontal error" id="emailForm" action="site/contactUs" method="post">
            <legend>
                <h2>Contact Us</h2>
            </legend>

            <div class="form-group control-group">
                <label for="inputName" class="col-sm-2 control-label">
                    Name <span class="glyphicon glyphicon-asterisk"></span>
                </label>
                <div class="col-sm-10 controls">
                    <input type="text" class="form-control" id="inputName" placeholder="First Name" name="name"
                            required data-validation-required-message="Name is required.">
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="form-group control-group">
                <label for="inputEmail" class="col-sm-2 control-label">
                    Email <span class="glyphicon glyphicon-asterisk"></span>
                </label>
                <div class="col-sm-10 controls">
                    <input type="email" class="form-control" id="inputEmail" placeholder="Email" name="email" required
                            data-validation-email-message="Enter a valid email."
                            data-validation-required-message="Email address is required.">
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="form-group control-group">
                <label for="inputPhone" class="col-sm-2 control-label"> Phone Number </label>
                <div class="col-sm-10 controls">
                    <input type="text" class="form-control" id="inputPhone" placeholder="Phone Number" name="phone">
                </div>
            </div>
            <div class="form-group control-group">
                <label for="inputSubject" class="col-sm-2 control-label"> Subject </label>
                <div class="col-sm-10 controls">
                    <input type="text" class="form-control" id="inputSubject" name="subject">
                </div>
            </div>
            <div class="form-group control-group">
                <label for="inputComments" class="col-sm-2 control-label">
                    Message <span class="glyphicon glyphicon-asterisk"></span>
                </label>
                <div class="col-sm-10 controls">
                    <textarea class="form-control" id="inputComments" name="comments" required
                           data-validation-required-message="Cannot blank message. Please enter your comments."
                            rows="10"></textarea>
                    <p class="help-block"></p>
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
