<?php
    
    $json = array();

    if(isset($_GET['nombre'])){ // Si existe el nombre
        if($_GET['nombre'] == "Juan"){ // Si el nombre es Juan

            $json['success'] = true;
            $json['message'] = "Hola! El nombre recibido es correcto.";
        }else{ // Si el nombre no es Juan
            $json['success'] = false;
            $json['message'] = "Hola! El nombre recibido es incorrecto.";
        }

        //Aunque el content-type no sea un problema en la mayorio de casos,
        // es recomendable especificarlo para que el navegador no lo tome como texto plano

        header('Content-type: application/json; charset=utf-8');
        echo json_encode($json);
        exit();
    }
?>
