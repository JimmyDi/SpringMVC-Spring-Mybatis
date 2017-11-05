<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Seckill! Choose you want!</title>
    <%@include file="common/head.jsp" %>
    <script src="../resource/script/seckill.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
    <div class="panel panel-default text-center">
        <div class="pannel-heading">
            <h1>${seckill.name}</h1>
        </div>

        <div class="panel-body">
            <h2 class="text-danger">
                <%--show time icon--%>
                <span class="glyphicon glyphicon-time"></span>
                <%--show count down --%>
                <span class="glyphicon" id="seckill-box"></span>
            </h2>
        </div>
    </div>
</div>
<%--sign in model input cellphone number--%>
<div id="killPhoneModal" class="modal fade">

    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title text-center">
                    <span class="glyphicon glyphicon-phone"> </span>Seckill Phone:
                </h3>
            </div>

            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="text" name="killPhone" id="killPhoneKey"
                               placeholder="Please input your cell phone number!" class="form-control">
                    </div>
                </div>
            </div>

            <div class="modal-footer">
                <%--validation information--%>
                <span id="killPhoneMessage" class="glyphicon"> </span>
                <button type="button" id="killPhoneBtn" class="btn btn-success">
                    <span class="glyphicon glyphicon-phone"></span>
                    Submit
                </button>
            </div>

        </div>
    </div>

</div>

</body>
<%--jQery file, import belofre bootstrap.min.js file--%>
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<%--apply CDN get public js http://www.bootcdn.cn/--%>
<%--jQuery Cookie operation plug-in unit--%>
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<%--jQuery countDown plug-in unit--%>
<script src="http://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>


<script type="text/javascript">
    $(function () {
        
        seckill.detail.init({
            seckillId:${seckill.seckillId},
            startTime:${seckill.startTime.time},
            endTime:${seckill.endTime.time}
        });
    })
</script>
</html>