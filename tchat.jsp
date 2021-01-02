<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style1.css">
<meta charset="ISO-8859-1">
<title>Tchat jsp</title>
</head>
<body>
	<div id="principal">
	
    <div id="users">
    </div>
    <div id="messages">
      <div class="message" id="msgtpl" style="display:none;">
        <img src="{{{user.avatar}}}">
        <div class="info">
          <p><strong>{{user.username}}</strong></p>
          <p>{{message}}</p>
          <span class="date">{{h}}:{{m}}</span>
        </div>
      </div>
    </div>

    <div id="login">
      <form action="" id="loginform">
        <h1>Bienvenue</h1>
<!--         <p>Ceci est un test de tchat pour Node.JS, entrez votre pseudo et votre email (utilis&eacute; pour l'avatar gravatar)</p> -->
        <br><input type="text" name="login" id="username" placeholder="Nom d'utilisateur">
        <br><input type="mail" name="mail" id="mail" placeholder="E-mail">
        <br><input type="submit" value="Envoyer">
      </form>
    </div>

    <form action="" id="form">
      <input type="text" id="message" class="text"/>
      <input type="submit" id="send" value="Envoyer mon message !" class="submit"/>
    </form>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <script src="js/mustache.js"></script>
    <script src="http://localhost:1337/socket.io/socket.io.js"></script>
    <script src="js/client.js"></script>
	
	</div>
</body>
</html>