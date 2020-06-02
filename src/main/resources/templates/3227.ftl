<#import "macro/login.ftl" as l>
<#import "macro/common.ftl" as c>


<@c.page>
<h3 style="margin: 10px">Авторизоваться</h3>
<@l.login "/api/auth/login" />
<a href="/api/reg/registration">Зарегестрироваться</a>
</@c.page>
