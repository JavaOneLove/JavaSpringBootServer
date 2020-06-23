<#import "macro/common.ftl" as c>


<@c.page>
    <h3>Список заказов</h3>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th>Id</th>
            <th>Work</th>
            <th>Status</th>
            <th>Date</th>
            <th>Comment</th>
        </tr>
        </thead>
        <tbody>
        <#list orders as order>
            <tr>
                <td style="margin: 4px">${order.getId()}</td>
                <td style="margin: 4px">${order.getWork()}</td>
                <td style="margin: 4px">${order.getStatus()}</td>
                <td style="margin: 4px">${order.getDate()}</td>
                <td style="margin: 4px">${order.getComment()}</td>
                <td style="padding-bottom: 10px;padding-left: 10px"><a href="/api/manager/orderDetails/${order.getId()}"><button class="btn btn-outline-primary" type="submit">Обработка</button></a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>