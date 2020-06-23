<#import "macro/common.ftl" as c>


<@c.page>
    <h3>Список пользователей</h3>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Role</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list userList as user>
            <tr>
                <td style="margin: 4px">${user.username}</td>
                <td style="margin: 4px">${user.getEmail()}</td>
                <td style="margin: 4px"><#list user.roles as role>${role.getName()}<#sep>, </#list></td>
                <td style="padding-bottom: 10px;padding-left: 10px"><a href="/api/admin/userDetails/${user.getId()}"><button class="btn btn-outline-primary" type="submit">Изменить</button></a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>