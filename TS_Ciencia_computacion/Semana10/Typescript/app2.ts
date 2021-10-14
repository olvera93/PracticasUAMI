(function () {

    //Tipo String
    let mensaje: string = "Hola";

    // Tipo numero
    let numero: number = 123;

    // Tipo boolean
    let booleano: boolean = true;

    let dia:Date = new Date();

    // Tipo any, un tipo especial
    let otra;

    // Se le puede asignar cualquier cosa a any
    otra = mensaje;
    otra = numero;

    // Se le puede asignar solo cadenas y enteros
    let otro: string|number;
    otro = mensaje;
    otro = numero;

    let punto={
        x:0,
        y:0
    }

    punto = {
        x:6,
        y:6
    }

    console.log(punto);
})();