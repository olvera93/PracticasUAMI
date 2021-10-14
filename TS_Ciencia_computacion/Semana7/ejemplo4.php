<?php

    function factorial($numero) {
        $fact = 1;
        for ($i = 1; $i <= $numero; $i++) {
            $fact = $fact * $i;
        }
        return $fact;
    }

    $numero = 5;
    $resultado = factorial($numero);
    echo "El factorial de $numero es $resultado";
?>