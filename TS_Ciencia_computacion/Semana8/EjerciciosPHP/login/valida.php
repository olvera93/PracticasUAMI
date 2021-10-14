<?php

    include('config.php');
    $username = $_POST['user'];
    $password = $_POST['pass'];

    $sql = "SELECT * FROM users WHERE nickname = '$username' AND password = '$password'";

    $result = mysqli_query($con, $sql);
    $count = mysqli_num_rows($result);

    if($count == 1){ 
        echo "<h1><center> Login exitoso </center></h1>";
        echo "<h2><center> Bienvenido $username </center></h2>";
        
    }else{
        echo "<h1><center> Error: Usuario o contraseña incorrectos </center></h1>";
        echo "<h3><center> <a href='index.php'> Volver al inicio </a> </center></h3>";

    }

?>