<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>
	Hello Shivam !!!
	
	<form action="add" method="post">
		id : <input name="id" type="text"><br>
		name : <input name="name" type="text"><br>
		score : <input name="metascore" type="text"><br>
		<input value="addGame" type="submit">
	</form>
	
	<hr>
	
	Get Game by ID 
	<form action="getGameById">
		id : <input name="id" type="text"><br>
		<input type="submit">
	</form>
	
	<hr>
	Get Game by Name 
	<form action="getGameByName" method="post">
		name : <input name="name" type="text"><br>
		<input type="submit">
	</form>
	
</body>
</html>