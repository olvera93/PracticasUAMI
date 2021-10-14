function insertar(num) {
    var resultadoActual = document.getElementById("resultado").value;
   
    document.getElementById("resultado").value = resultadoActual + num;

    //Se debe de quitar el 0 del resultado
    if (resultadoActual == 0) {
        document.getElementById("resultado").value = num;
    }

}

function limpiar() {
    document.getElementById("resultado").value = 0;
}

function regresar() {
    var resultadoActual = document.getElementById("resultado").value;
    document.getElementById("resultado").value = resultadoActual.substring(0, resultadoActual.length - 1);
}