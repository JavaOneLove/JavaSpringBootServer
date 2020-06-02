<#import "macro/common.ftl" as c>


<@c.page>
    <h3 style="margin: 10px">Список пользователей</h3>
    <#list userList as user>
        <div>
            <tr>
                <td class="table-primary">${user.getEmail()}</td>
                <td class="table-primary">${user.getUsername()}</td>
            </tr>
        </div>
    </#list>
</@c.page>