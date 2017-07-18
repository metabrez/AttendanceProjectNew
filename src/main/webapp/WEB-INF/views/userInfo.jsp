<%@include file="/WEB-INF/views/template/header.jsp" %>


<div>

Search User<input type="text" name="search" placeholder="Search..">


</div>


<div><button type="button" class="btn btn-primary">Create User</button></div>

<div class="container-wrapper">
    <div class="container">
        <div id="login-box">
        
        
            <h2>User Details Information</h2>
            
            <table class="table table-striped table-hover" border="1">

    <thead>
    <tr class="bg-success">
<!-- <th>Photo Thumb</th> -->
<th>UserName(ID)</th>
        <th>password</th>
        <th>Role</th>
        
        
    </tr>

    </thead>
    <c:forEach items="${users}" var="user">

    <tr>
        
         <td>${user.userId}</td>
        <td>${user.password}</td>
         <td>${user.role}</td>
        
       
    </tr>
    </c:forEach>
</table>

        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>