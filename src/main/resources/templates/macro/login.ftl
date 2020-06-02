<#macro login path>
    <form action="${path}"  enctype="application/x-www-form-urlencoded">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Username:</label>
            <div class="col-sm-6">
                <input type="text" name="username" class="form-control" placeholder="username" />
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Password:</label>
            <div class="col-sm-6">
                <input type="password" name="password" class="form-control" placeholder="Password" />
            </div>
        </div>
        <div><button class="btn btn-primary" onclick="func()" >Принять</button></div>
    </form>
    <script type="text/javascript">
       var func = function () {
           $.ajax({
               "async": true,
               "crossDomain": true,
               "url": "http://localhost:8080/api/auth/login",
               "method": "POST",
               "headers": {

                   "content-type": "application/json",
                   "cache-control": "no-cache",
               },
               "processData": false,
               "data": "{\n\t\"username\" : \"manager\",\n\t\"password\" : \"pass\"\n}"
           });
           window.location.href = "";
        }

    </script>
</#macro>
