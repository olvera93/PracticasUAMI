function insertar(num){
    var resultadoActual = document.getElementById('resultado').value;
    document.getElementById('resultado').value = resultadoActual + num;
}
function limpiar(){
    document.getElementById('resultado').value = 0;
}
function regresar(){
    var resultadoActual = document.getElementById('resultado').value;
    document.getElementById('resultado').value = resultadoActual.substring(0, resultadoActual.length -1);
}

function enviar(){

   $.post("/calc",
    {
      expresion: $("#resultado").val()
    },
    function(data,status){
      console.log(data);
       $("#resultado").val(data);
    });
    
}

