<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Welcome Page!
	<form action="getUser">
		<input type="text" name="id" />
		<button>Submit</button>
	</form>
	
	<h1>File Upload</h1>
	<form action="uploadFile" method="post" enctype="multipart/form-data">
		<input type="file" name="file" multiple />
		<button>Submit</button>
	</form>
</body>
</html>