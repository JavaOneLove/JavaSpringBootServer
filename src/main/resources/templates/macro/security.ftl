<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    isAdmin = user.isAdmin()
    isStudent = user.isStudent()
    isTeacher = user.isTeacher()
    >
<#else >
    <#assign
    name = "unknown"
    isAdmin = false
    isTeacher = false
    isStudent = false
    >
</#if>