<?php

    function prompt($prompt_msj) {
        echo("<script type='text/javascript'> var r = prompt('".$prompt_msj."'); </script>");

        $result = "<script type='text/javascript'> document.write(r); </script>";

        return $result;
    }

    $prompt_msj = "Ingrese su nombre: ";
    $nombre = prompt($prompt_msj);

    $salida = "Hola " .$nombre. "!";
    echo ($salida);
?>