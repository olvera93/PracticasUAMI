<?php

    try {
        $total = eval('return ' . $_GET['resultado']. ';');

        if (!is_numeric($total)) {
            $total = 'Error, no numerico';
        }

    } catch (ParseError $e) {
        $total = 'Error';
    }

    header("Location: calculadora.php?total=" .$total);
?>