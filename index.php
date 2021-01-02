<?php 
session_start();

//if (isset($_COOKIE["token"]) AND isset($_COOKIE["emmail"]) AND !empty($_COOKIE["token"]) AND !empty($_COOKIE["'email"]) ) {
 
// echo password_hash("mot_de_passe", PASSWORD_DEFAULT);
// echo "<br/>";
// $hash = password_hash("mot_de_passe", PASSWORD_DEFAULT);
// echo $hash;
// echo "<br/>";
// if (password_verify('mot_de_passe', $hash)) {
//     echo 'Le mot de passe est valide !';
// } else {
//     echo 'Le mot de passe est invalide.';
// }
   
if (!empty($_COOKIE["token"]) AND !empty($_COOKIE["email"])) {
        
     $mysqli = new mysqli('127.0.0.1', 'root', '', 'philippe');
     
     $token = htmlspecialchars($_COOKIE["token"]);
     
     $email = htmlspecialchars($_COOKIE["email"]);
         
    $sql = "SELECT email, token FROM membre WHERE email = '".$email."' AND token = '".$token."'";
        
 if (!$result = $mysqli->query($sql)) {
      
      
    }

   if ($result->num_rows === 0) {
      

   }
        
   if ($data = mysqli_fetch_array($result))
   {  mysqli_close($mysqli);
   
   $result->close();
   header('Location: bienvenue.php');}
            else {header('Location: index.php?error=1') ;}
   

}
?>  

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
<link href="csspersonnel/csspersonnel.css" rel="stylesheet">

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

  <form class="form-signin" action="traitement.php" method="post" >
<!--   <img class="mb-4" src="/docs/4.2/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72"> -->
  <h1 class="h3 mb-3 font-weight-normal">Connexion</h1>
  <h1 for="inputEmail" class="sr-only"></h1>
  <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Entrer votre email" required autofocus>
  <h1 for="inputPassword" class="sr-only"></h1>
  <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
  <input type="hidden" name="token" value=""/>
  </br>
  <?php 

  if (isset($_GET['error'])) {$error=htmlspecialchars($_GET['error']);

switch ($error) {
    case 1:

        echo " Donnees incorrectes ";
        break;
        
    case 2:

        echo " Donnees incorrectes";
        break;
        
    case 3:
        echo "vous avez ete deconnecte";
        break;
        
    case 4:
        echo "New record created successfully";
        break;
              }

  ;}
?>
  <div class="checkbox mb-3">
  
  <label>
  <input type="checkbox" name="rememberme" >se souvenir de moi
  
  </label>
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
  <a href="enregistrement.php" title="S enregistrer" target="_blank" rel="noopener noreferrer">S enregistrer</a>
  <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
</form>
 
  

</body>
</html>







