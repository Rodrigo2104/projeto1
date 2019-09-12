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
h1 {
	color:black;
	font-size:3em;
	font-family: "Times New Roman", Times, serif;
	}
p {
	color:grey;
	font-size:2em;
	font-family: Arial, Helvetica, sans-serif;
	}
td{
	color:black;
	font-size:1em;
	font-family: Arial, Helvetica, sans-serif;
	background-color:white;
}
</style>
</head>
<body>

	<% 
	List<postagem> postagens = (List<postagem>) request.getAttribute("postagens");
	%> 
	<h1>Comentários
	</h1>
	
	

	<table border='1'>
	<% for (postagem post : postagens ) { %>
	 <tr>
	 <td><%=post.getMateria()%></td>
	 <td><%=post.getProfessor()%></td>
	 <td><%=post.getReview()%></td>
	 
	 <td>
	 <form action="deletar" method="post">
	 	<input type="submit" value="apagar"></input>
	 	<input type="hidden" value="<%=post.getId()%>" name=id></input>
	 	</form>
	 	</td>
	 <td>
	 <form action="atualizar" method="post">
	 <input type="submit" value="atualizar"></input>
	 <input type="hidden" value="<%=post.getId()%>" name=id></input>

	 
	 </form>
	 </td>
	 
	 </tr>
	<% } %>
	</table>

</body>
</html>