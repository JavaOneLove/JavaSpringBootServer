<#import "macro/common.ftl" as c>


<@c.page>
    <h3>Список запчастей</h3>
    <td style="padding-bottom: 10px;padding-left: 10px"><a href="/api/manager/addSparePart"><button class="btn btn-outline-primary" type="submit">Добавить</button></a></td>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Mark</th>
            <th>Model</th>
            <th>Value</th>
        </tr>
        </thead>
        <tbody>
        <#list SparePartList as list>
            <#if list_has_next>
            <tr>
                <td style="margin: 4px">${list.getId()}</td>
                <td style="margin: 4px">${list.name}</td>
                <td style="margin: 4px">${list.mark}</td>
                <td style="margin: 4px">${list.model}</td>
                <td style="margin: 4px">${list.value}</td>
            </tr>
            </#if>
        </#list>
        </tbody>
    </table>
</@c.page>