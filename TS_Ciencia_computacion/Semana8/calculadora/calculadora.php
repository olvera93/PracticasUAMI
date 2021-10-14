<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style/calculadora.css">
    <script src="js/calculadora.js"></script>
    <title>Calculadora PHP</title>
</head>
<body>

    <div class="fondo">
        <div class="calculadora">
            <h1>Calculadora</h1>
            <form method="GET" action="calc.php">
                <input type="text" name="resultado" id="resultado" 
                value="
                <?php
                    if(!empty($_GET['total'])){
                        $r = $_GET['total'];
                        echo $r;
                    } else {
                        $total = '';
                        echo $total;
                    }
                ?>
                ">
               

            <table>
                    <tr>
                        <td><button type="button" onclick="limpiar()" class="boton">C</button></td>
                        <td><button type="button" onclick="regresar()" class="boton"><</button></td>
                        <td><button type="button" onclick="insertar('/')" class="boton">/</button></td>
                        <td><button type="button" onclick="insertar('*')" class="boton">*</button></td>
                    </tr>

                    <tr>
                        <td><button type="button" onclick="insertar('7')" class="boton">7</button></td>
                        <td><button type="button" onclick="insertar('8')" class="boton">8</button></td>
                        <td><button type="button" onclick="insertar('9')" class="boton">9</button></td>
                        <td><button type="button" onclick="insertar('-')" class="boton">-</button></td>
                    </tr>

                    <tr>
                        <td><button type="button" onclick="insertar('4')" class="boton">4</button></td>
                        <td><button type="button" onclick="insertar('5')" class="boton">5</button></td>
                        <td><button type="button" onclick="insertar('6')" class="boton">6</button></td>
                        <td><button type="button" onclick="insertar('+')" class="boton">+</button></td>
                    </tr>

                    <tr>
                        <td><button type="button" onclick="insertar('1')" class="boton">1</button></td>
                        <td><button type="button" onclick="insertar('2')" class="boton">2</button></td>
                        <td><button type="button" onclick="insertar('3')" class="boton">3</button></td>

                        <td rowspan="2"><button type="submit" style="height: 106px;" class="boton">=</button></td>

                    </tr>

                    <tr>
                        <td colspan="2"><button type="button" style="width: 106px;" onclick="insertar('0')" class="boton">0</button></td>
                        <td><button type="button" onclick="insertar('.')" class="boton">.</button></td>
                    </tr>


                </table>
            </form>
        </div>
    </div>

    
</body>
</html>