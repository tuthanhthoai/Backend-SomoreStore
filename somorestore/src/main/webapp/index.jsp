<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>Please Login</h2>
		<br />
	</div>
	<div>
		<h4>
			<a th:href="/@{/login/oauth2/code/google}">Login with Google</a>
		</h4>
	</div>
	<div>
		<p>OR</p>
	</div>

	<form th:action="@{/login}" method="post"
		style="max-width: 400px; margin: 0 auto;">
		<div class="border border-secondary rounded p-3">
			<div th:if="${param.error}">
				<p class="text-danger">Invalid username or password.</p>
			</div>
			<div th:if="${param.logout}">
				<p class="text-warning">You have been logged out.</p>
			</div>
			<div>
				<p>
					<input type="email" name="email" required class="form-control"
						placeholder="E-mail" />
				</p>
			</div>
			<div>
				<p>
					<input type="password" name="pass" required class="form-control"
						placeholder="Password" />
				</p>
			</div>
			<div>
				<p>
					<input type="submit" value="Login" class="btn btn-primary" />
				</p>
			</div>
		</div>
	</form>
</body>
</html>