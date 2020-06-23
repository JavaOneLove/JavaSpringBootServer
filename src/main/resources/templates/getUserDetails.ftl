<#import "macro/common.ftl" as c>


<@c.page>
    <form action="/api/admin/updateUser2" method="post">
        <input type="text" name="username" value="${user.username}">
        <#list roleList as role>
            <div>
                <label><input id="checkb" type="checkbox" name=${role} ${role}>${role}</label>
            </div>
        </#list>
        <input type="hidden" value="${user.id}" name="userId">
        <input id="roleU" type="hidden" value="${user.id}" name="roleU">
        <button id="butt" onclick="f()" type="submit">Save</button>
    </form>

    <script>
        f = function() {
            var val = document.getElementById('checkb').name;
            document.getElementById("roleU").value = val;
        };
    </script>
</@c.page>