"use strict";
(function () {
    //Tipo String
    var mensaje = "Hola";
    // Tipo numero
    var numero = 123;
    // Tipo boolean
    var booleano = true;
    var dia = new Date();
    // Tipo any, un tipo especial
    var otra;
    // Se le puede asignar cualquier cosa a any
    otra = mensaje;
    otra = numero;
    // Se le puede asignar solo cadenas y enteros
    var otro;
    otro = mensaje;
    otro = numero;
    var punto = {
        x: 0,
        y: 0
    };
    punto = {
        x: 6,
        y: 6
    };
    console.log(punto);
})();
