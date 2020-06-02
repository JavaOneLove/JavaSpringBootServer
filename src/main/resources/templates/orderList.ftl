<#import "macro/common.ftl" as c>


<@c.page>

    <#list orders as order>
        <div>
            <tr>
                <td class="table-primary">${order.getWork()}</td>
                <td class="table-primary">${order.getDate()}</td>
            </tr>
        </div>
    </#list>
</@c.page>