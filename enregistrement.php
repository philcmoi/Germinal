<!doctype html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Signin Template · Bootstrap</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.2/examples/sign-in/">

    <!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
  </head>
  <body class="text-center">


<form class="form-signin" action="traitement2.php" method="post" >;
    <img class="mb-4" src="/docs/4.2/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
   
    <h1 for="inputEmail" class="sr-only"></h1>
   
    <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Entrer votre email" required autofocus>
    <h1 for="inputPassword" class="sr-only"></h1>
    <input type="text" name="nom" id="inputEmail" class="form-control" placeholder="Entrer votre nom" required autofocus>
    <input type="text" name="prenom" id="inputEmail" class="form-control" placeholder="Entrer votre prenoml" required autofocus>
    <input type="text" name="password" id="inputPassword" class="form-control" placeholder="Password" required><br>
    <input type="text" name="password2" id="inputPassword" class="form-control" placeholder="Password de confirmation" required>
    </br>
<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
<?php 

   if (isset($_GET['erreure']))   
   {$error=htmlspecialchars($_GET['erreure']);

switch ($error) {
    case 1:

        echo " email existant ";
        break;
        
    case 2:

        echo " mots de passe non identiques ";
        break;
        
    case 3:
        echo "vous avez ete deconnecte";
        break;
        
    case 4:
        echo "New record created successfully";
        break;
        
        
        
        
              }
}
?>
  <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
   
</form>
       
    
    
    
    
    
    
    
    
    
    
