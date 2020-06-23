<#import "macro/common.ftl" as c>


<@c.page>
    <form action="/api/manager/ValidateOrder" method="post">
        <b><label >Work: </label></b><label >${order.getWork()}</label>
        <p><b><label >Status: </label></b><label >${order.getStatus()}</label></p>
        <p><b><label >Comment: </label></b><label >${order.getComment()}</label></p>
        <p><b><label >Date: </label></b><label >${order.getDate()}</label></p>
        <#list status as stat>
            <div>
                <label><input id="checkb" type="checkbox" name=${stat} ${stat}>${stat}</label>
            </div>
        </#list>
        <input type="hidden" value="${order.id}" name="orderId">
        <input id="statU" type="hidden" name="statU">
        <button id="butt" onclick="f()" type="submit">Save</button>
    </form>

    <script>
        f = function() {
            var val = document.getElementById('checkb').name;
            document.getElementById("statU").value = val;
        };
    </script>
</@c.page>