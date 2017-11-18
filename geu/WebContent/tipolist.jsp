<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html >
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Gerenciador de Espa�os</title>
	
	<link href="/geu/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="/geu/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
	<link href="/geu//css/app.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	
</head>

<body>
<c:import url="topo.jsp"></c:import>
<div class="container">
<div class="page-header">
<h1> Lista Tipos </h1>
</div>

<table class="table" >
<tr>
<th> Nome </th>
<th> Descri��o </th>


</tr>

<c:forEach var="e" items="${lista}">
<tr>
 <td> ${e.nome} </td>
 <td> ${e.descricao} </td>
 
<tr>
</c:forEach>
</table>
</div>

<c:import url="rodape.jsp"></c:import>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

    <script src="/geu/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>