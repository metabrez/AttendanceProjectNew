<%@include file="/WEB-INF/views/template/header.jsp"%>


<div>

	Search User<input type="text" name="search" placeholder="Search..">

</div>

<div>
	<button type="button" class="btn btn-primary">Create User</button>
</div>

<div class="container-wrapper">
	<div class="container">
		<div id="login-box">

			<h2>User Details Information</h2>

			<table class="table table-striped table-hover" border="1">

				<thead>
					<tr class="bg-success">
						<th>UserName(ID)</th>
						<th>password</th>
						<th>Role</th>
						<th>User ID</th>
						<th>Update</th>
						<th>Delete</th>
					</tr>
				</thead>

				<c:forEach items="${userList}" var="user">

					<tr>
						<td>${user.userName}</td>
						<td>${user.password}</td>
						<td>${user.roleId}</td>
						<td>${user.userId}</td>
						
						<td>
							 <a href="<spring:url value="/userInfo/edit/${user.userId}"/>">
								<span class="glyphicon glyphicon-pencil"></span>
							</a>
						</td>
<td>
							<a href="<spring:url value="/userInfo/delete/${user.userId}" />"> 
								<span class="glyphicon glyphicon-remove"></span>
							</a>
						</td>
					</tr>
				</c:forEach>

			</table>

		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>