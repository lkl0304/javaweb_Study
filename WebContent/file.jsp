<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<form action="upload" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>上传者：</td>
				<td colspan="2"><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>选择文件：</td>
				<td><input type="file" name="file"></td>
				<td><input type="submit" value="上传"></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>