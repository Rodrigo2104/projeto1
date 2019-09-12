<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
<style type="text/css">
body{
background-color:#afeeee;
}
h1 {color:black;
	font-size:3em;
	font-family: "Times New Roman", Times, serif;
	}
p {color:grey;
	font-size:2em;
	font-family: Arial, Helvetica, sans-serif;
	}
	
</style>
</head>

<body>
	<h1>Cadastro</h1>
	<form action="cadastro" method="post">
		<p>nome:<input type="text" name="nome"></input></p>
	
		<p>senha:<input type="password" name="senha"></input></p>
	
		<p>confirmar senha:<input type="password" name="confirmar senha"></input></p>
		
		<input type="submit" name="cadastro"></input>
		
	
	</form>
	
		<h1>Login</h1>
	<form action="login" method="post">
		<p>nome:<input type="text" name="nome"></input></p>
	
		<p>senha:<input type="password" name="senha"></input></p>
	
		<input type="submit" name="login"></input>
	</form>

</body>
</html>