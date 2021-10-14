<?php
    $host = 'localhost'; /* Conexion local */
    $user = 'uwebsql'; /* Usuario */
    $pass = '2021uwebts-sql'; /* Contraseña */
    $db_name = 'usuarios'; /* Base de datos */

    $con = mysqli_connect($host, $user, $pass, $db_name);

    //Se verifica la conexión
    if(!$con){
        die("Falló la conexion a la base de datos: " . mysqli_connect_error());
    }

?>