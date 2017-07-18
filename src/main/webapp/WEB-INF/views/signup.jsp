<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div id="login-box">
            <h2>Login with Username and Password.</h2>

            <div class="bg-danger" th:if="${param.error}">
                Invalid username and secret.
            </div>
            <div class="bg-danger" th:if="${param.logout}">
                You have been logged out.
            </div>

            <form class="form-signin" th:action="@{/index}" method="post">
                <h2 class="form-signin-heading">Please sign in</h2>
                <div class="form-group">
                    <label for="username" class="sr-only">Username</label>
                    <input type="text" roleId="username" class="form-control" placeholder="Username" name="username"
                           id="username"
                           required="required" autofocus="autofocus"/>
                </div>
                <div class="form-group">
                    <label for="password" class="sr-only">Password</label>
                    <input type="password" roleId="inputPassword" class="form-control" placeholder="Password"
                           id="password"
                           name="password" required="required"/>
                </div>
                <div class="form-group">
                    <input type="checkbox" name="remember-me" id="remember-me"/> &nbsp; Remember me
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </form>

            <hr />

            <div class="form-group ">
                <a type="submit" class="btn btn-info btn-lg btn-block login-button" th:href="@{/signup}">Sign up!</a>
            </div>

            <%-- <c:if test="${not empty msg}">
                 <div class="msg">${msg}</div>
             </c:if>

             <form name="loginForm" action="<c:url value="/login"/> " method="post">
                 <c:if test="${not empty error}">
                     <div class="error" style="color:#ff0000;">${error}</div>
                 </c:if>
                 <div class="form-group">
                     <label for="username">User:</label>
                     <input type="text" id="username" name="username" class="form-control"/>
                 </div>
                 <div class="form-group">
                     <label for="password">Password</label>
                     <input type="password" id="password" name="password" class="form-control"/>
                 </div>

                 <input type="submit" value="Submit" class="btn btn-default"/>

                 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
             </form>--%>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>