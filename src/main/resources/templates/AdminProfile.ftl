<#import "macro/common.ftl" as c>


<@c.page>
    <h3 style="margin: 10px">Кабинет администратора:  ${user.getUsername()}</h3>
    <div>
        <div>
            <div class="row" style="margin:10px 10px; ">
                <div class="col-sm-8">
                    <form method="post" action="/api/admin/updateUser">
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Username:</label>
                            <div class="col-sm-6">
                                <input type="text" name="username" class="form-control" placeholder="username" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Password:</label>
                            <div class="col-sm-6">
                                <input type="password" name="password" class="form-control" placeholder="Password" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Email:</label>
                            <div class="col-sm-6">
                                <input type="email" name="email" class="form-control" placeholder="some@some.com" value="${email!''}" />
                            </div>
                        </div>
                        <button class="btn btn-primary" type="submit">Save</button>
                    </form>
                </div>
                <a href="/api/admin/userList"><button class="btn btn-outline-primary" type="submit">Список пользователей</button></a>
        </div>
    </div>

</@c.page>
