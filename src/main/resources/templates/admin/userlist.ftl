<#include "../import/top.ftl">
    <div class="panel">
        <div class="panel-body">
            <form class="form-horizontal" action="/Ica269/user/list" method="post">
                <div class="form-group">
                    <label for="userName" class="col-sm-2">Username: </label>
                    <input type="text" class="form-control" name="userName" id="userName" placeholder="Username">
                </div>
                <div class="col-sm-1">
                    <button type="submit">search</button>
                </div>
            </form>
        </div>
    </div>
    <#if userPage?? && userPage.list? size gt 0  >
        <h4><i class="icon icon-info-sign"></i>Frozen user cannot log in!</h4>

        <div class="panel">
            <div class="panel-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Registration Date</th>
                        <th>Username</th>
                        <th>Acount status (1 for inactive)</th>
                        <th>Operation</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list userPage.list as user>
                        <tr>
                            <td>${(user.userRegisterTime!)?string ("yyyy-MM-dd: HH:mm:ss")}</td>
                            <td>${user.userName!}</td>
                            <td>${user.userFrozen!}</td>
                            <#if (user.userFrozen)?? && (user.userFrozen)==1>
                                <span clsss="label label-danger">Account Frozen! </span>
                                <#else>
                                    <span clsss="label label-success">Active Account </span>
                            </#if>
                            <td>
                                <button class="btn btn-mini"><i class="icon icon-cog"></i>modify</button>
                                <button class="btn btn-mini"><i class="icon icon-remove"></i>delete</button>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>

        <#else>
            <div style="text-align: center;">
                <h3>No data available</h3>
            </div>
    </#if>
<#include "../import/bottom.ftl">