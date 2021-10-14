<?php

    $d = date("D");

    if ($d == "Mon")
        echo "Buen inicio de semana!";
    
    else 
        if ($d == "Fri")
            echo "Buen fin de semana!";
        
        else 
            echo "Buen dia!";
?>