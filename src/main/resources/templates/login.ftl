<#import "macro/common.ftl" as c>

<@c.page>
    <h3 style="margin: 10px">Авторизоваться</h3>
    <form id="Form1"  enctype="application/x-www-form-urlencoded">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Username:</label>
            <div class="col-sm-6">
                <input id="username" type="text" name="username" class="form-control" placeholder="username" />
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Password:</label>
            <div class="col-sm-6">
                <input id="password" type="password" name="password" class="form-control" placeholder="Password" />
            </div>
        </div>
        <div><button class="btn btn-primary" onclick="func()" >Принять</button></div>
    </form>

    <script type="text/javascript">
        var func = function () {

            var fd = new FormData();
            fd.append('username', $("#username").val());
            fd.append('password', $("#password").val())
            var username = JSON.stringify($("#username").val());

            var pass = JSON.stringify($("#password").val());
            $.ajax({
                "async": true,
                "crossDomain": true,
                "url": "http://localhost:8080/api/auth/login",
                "method": "POST",
                "headers": {
                    "content-type": "application/json",
                },
                "processData": false,
                "data": fd
            });
        }

    </script>
    <a href="/api/reg/registration">Зарегестрироваться</a>
</@c.page>