<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a style="padding-left: 120px" class="navbar-brand" href="/"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">

    </div>
</nav>
<style>
    nav ul {
        padding:0;
        margin:0;
        list-style: none;
        position: relative;
    }
    /* стилизуем ссылки */
    nav a {
        display:block;
        padding:0 10px;
        color: rgba(0,0,0,.5);
        font-size:18px;
        line-height: 20px;
        text-decoration:none;
    }
    nav ul ul {
        display: none;
        position: absolute;
        top: 100%;
    }
    /* отображаем выпадающий список при наведении */
    nav ul li:hover > ul {
        display:inherit;
        background-color: #f8f9fa;
    }
    /* первый уровень выпадающего списка */
    nav ul ul li {
        min-width:170px;
        float:none;
        display:list-item;
        position: relative;
    }
</style>