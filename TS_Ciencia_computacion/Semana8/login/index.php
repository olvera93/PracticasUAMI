<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Inicio</title>
    <link rel="stylesheet" href="style/style.css">
</head>
<body>
    
    <div class="contenedor">
        <form action="valida.php" method="post">
            <div id="div_login">
                <h1>Login</h1>
                <div>
                    <input type="text" class="caja" name="user" id="user" placeholder="Usuario" required>
                </div>

                <div>
                    <input type="password" class="caja" name="pass" id="pass" placeholder="Contraseña" required>
                </div>

                <div>
                    <input type="submit" id="btn" value="Login">
                </div>
            </div>
        </form>
    </div>
</body>
</html>