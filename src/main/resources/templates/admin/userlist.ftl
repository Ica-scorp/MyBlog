<#include "../import/top.ftl">
    <div class="panel">
        <div class="panel-body">
            <form class="form-horizontal" action="/Ica269/user/list" method="get">
                <div class="form-group">
                    <label for="userName" class="col-sm-1">Username: </label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" name="userName" id="userName" placeholder="Username Input">
                    </div>
                    <div class="col-sm-1">
                        <button type="submit" class="btn btn-success">Search</button>
                    </div>
                    <div class="col-sm-1">
                        <a href="/Ica269/user/list" class="btn btn-success">Search All</a>
                    </div>
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
                            <td>
                                <#if (user.userFrozen)?? && (user.userFrozen)==1>
                                    <span class="label label-danger">Account Frozen! </span>
                                    <#else>
                                        <span class="label label-success">Active Account </span>
                                </#if>
                            </td>
                            <td>
                                <button onclick="userUpdate('${(user.userId)!}','${(user.userName)!}','${(user.userFrozen)!}','${(user.userPublishArticle)!}')"
                                        type="button" class="btn btn-mini"><i class="icon-cog"></i> Modify
                                </button>
                                <button onclick="delUser('${(user.userId)!}')" type="button" class="btn btn-mini"><i
                                            class="icon-remove"></i> Delete
                                </button>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="panel">
            <div class="panel-body" style="padding: 0;">
                <div class="col-sm-12" style="padding: 0;text-align: center;">
                    <ul class="pager" style="margin-top: 10px;margin-bottom: 10px;">
                        <li class="previous" onclick="getNewData(1)">
                            <a href="javascript:void(0)"><i class="icon-step-backward"></i></a>
                        </li>

                        <#if userPage.pageNumber lte 1>
                            <li class="previous disabled">
                                <a href="javascript:void(0)"><i class="icon-chevron-left"></i></a>
                            </li>
                        <#else>
                            <li class="previous" onclick="getNewData('${userPage.pageNumber-1}')">
                                <a href="javascript:void(0)"><i class="icon-chevron-left"></i></a>
                            </li>
                        </#if>
                        <li>
                            <a href="javascript:void(0)" class="btn">
                                ${userPage.pageNumber} Page /Total ${userPage.totalPage} Pages</a>
                        </li>
                        <#if userPage.pageNumber gte userPage.totalPage>
                            <li class="next disabled">
                                <a href="javascript:void(0)"><i class="icon-chevron-right"></i></a>
                            </li>
                        <#else>
                            <li class="next" onclick="getNewData('${userPage.pageNumber+1}')">
                                <a href="javascript:void(0)"><i class="icon-chevron-right"></i></a>
                            </li>
                        </#if>
                        <li class="previous" onclick="getNewData('${userPage.totalPage}')">
                            <a href="javascript:void(0)"><i class="icon-step-forward"></i></a>
                        </li>


                        <li class="next">
                            <a href="javascript:void(0)">
                                <input type="number" id="renderPageNumber" maxlength="5"
                                       style="width:50px;height: 20px;" oninput="value=value.replace(/[^\d]/g,'')">
                            </a>
                        </li>
                        <li class="next">
                            <a href="javascript:void(0)" onclick="renderPage()"
                               style="padding-left: 2px;padding-right: 2px;">
                                跳转
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    <#else>
        <div style="text-align: center;">
            <h3>No data available</h3>
        </div>

    </#if>


    <script type="text/javascript">
        function userUpdateAction() {
            let userId = $("#userId").val();
            let userName = $("#userNameUpdate").val();
            let userPassword = $("#userPassword").val();
            let userFrozen = $("input[name='userFrozen']:checked").val();
            let userPublishArticle = $("input[name='userPublishArticle']:checked").val();

            if (!checkNotNull(userId)) {
                zuiMsg("程序出错，刷新重试");
                return;
            }
            if (!checkNotNull(userFrozen)) {
                zuiMsg("请选择是否冻结用户");
                return;
            }
            if (!checkNotNull(userPublishArticle)) {
                zuiMsg("请选择是否运行发布文章");
                return;
            }
            $.post("/Ica269/user/update", {
                    userId: userId,
                    userPassword: userPassword,
                    userFrozen: userFrozen,
                    userPublishArticle: userPublishArticle
                },
                function (data) {
                    if (data.code == 200) {
                        alert(data.message)
                        location.reload();
                        return;
                    }

                    zuiMsg(data.message);
                });
        }


        function userUpdate(userId, userName, userFrozen,userPublishArticle) {
            $('#userUpdateModal').modal('toggle', 'center');
            $("#userId").val(userId);
            $("#userNameUpdate").val(userName);
            $(":radio[name='userFrozen'][value='" + userFrozen + "']").prop("checked", "checked");
            $(":radio[name='userPublishArticle'][value='" + userPublishArticle + "']").prop("checked", "checked");
        }


        function delUser(userId) {
            if (confirm("Please confirm that you want to delete this user.")) {
                if (!checkNotNull(userId)) {
                    zuiMsg('There is an error, please refresh the page!');
                    return;
                }
                $.post("/Ica269/user/del", {
                        userId: userId
                    },
                    function (data) {
                        if (data.code == 200) {
                            alert(data.message)
                            location.reload();
                            return;
                        }
                        new $.zui.Messager(data.message, {
                            type: 'warning',
                            placement: 'center'
                        }).show();
                    });
            }
        }
        function getNewData(pageNumber) {
            if (!checkNotNull(pageNumber)) {
                pageNumber = 1;
            }
            window.location.href = "/Ica269/user/list?pageNumber=" + pageNumber + "<#if (userName?? && userName?length>0)>&userName=${userName!}</#if>";
        }

        function renderPage() {
            let renderPageNumber = $("#renderPageNumber").val();
            if (!checkNotNull(renderPageNumber)) {
                zuiMsg("Please enter the page you want to go to:");
                return;
            }
            let totalPage = '${userPage.totalPage}';
            if (parseInt(renderPageNumber) > parseInt(totalPage)) {
                renderPageNumber = totalPage;
            }
            getNewData(renderPageNumber);
        }
        function checkNotNull(str){
            if(str == null || str == "" || str.length < 1){
                return false;
            }
            return true;
        }


    </script>
<#include "../import/bottom.ftl">