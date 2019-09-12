<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="br.edu.insper.*,java.util.*,br.edu.insper.DAO.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<% 
	String id = (String)request.getAttribute("id");

	%> 
	<h1>Adicionar nova review</h1>
	<form action="posta" method="post">
		<p>matéria:<input type="text" name="materia"></input></p>
	
		<p>professor:<input type="text" name="professor"></input></p>
	
		<p>mensagem:<input type="text" name="mensagem"></input></p>
		
 		<input type = "hidden" name="id" value = "<%= id%>"></input>
		
		 
		<input type="submit" name="review"></input>
		
	
	</form>
</body>
</html>