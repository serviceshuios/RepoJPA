<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="AjouterContact">
			<fieldset id="section-1">
				<legend>Informations personnelles</legend>
				<label for="nom">Saisir votre nom :</label>
				<input type="text" name="nom" id="nom"/><br/>
				<label for="prenom">Saisir votre prenom :</label>
				<input type="text" name="prenom" id="prenom"/><br/>
				<label for="email">Saisir votre email :</label>
				<input type="text" name="email" id="email"/><br/>
			</fieldset>
			
			<fieldset id="section-1">
				<legend>Adresse</legend>
				<label for="rue">Saisir la rue :</label>
				<input type="text" name="rue" id="rue"/><br/>
				<label for="ville">Saisir la ville :</label>
				<input type="text" name="ville" id="ville"/><br/>
				<label for="cp">Saisir le code postal :</label>
				<input type="text" name="cp" id="cp"/><br/>
			</fieldset>
			<input type="submit" value="valider"/>
		</form>
		

</body>
</html>