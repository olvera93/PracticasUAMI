"use strict";
/*(function() {
    
    var mensaje = "Hola";
    const URL = "constantes!!!";

    let variable = "México";

    if (true) {
        var mensaje = "Mundo";
        let variable = "Lindo";
    }

    console.log(mensaje + " " + variable);


})();


(() => {

    function facotrial(n:number): number{

        let i:number;
        let fact:number = 1;

        for(i = 1; i <= n; i++) {
            fact = fact*i;
        }
        return fact;
    }

    console.log(facotrial(5));
})();

(()=>{


    function factorial(n:number):number{

        let i:number;
        let fact:number=1;
        for(i=1;i<=n;i++)
            fact=fact*i;
        return fact;
    }

    function potencia(a:number, b:number):number{

        let i:number;
        let pot:number=1;
        for(i=1;i<=b;i++)
            pot=pot*a;
        return pot;
    }


    function exponencial(x:number=1,n?:number):number{
        
        let i:number=1;
        let iteraciones:number, suma:number=0;
        if(n){
            iteraciones=n;
        }else
            iteraciones=5;
        for(i=0;i<=iteraciones;i++){
            suma=suma+potencia(x,i)/factorial(i);
        }
        return suma;

    }

    console.log(exponencial());
    console.log(exponencial(2));
    console.log(exponencial(2,10));

})();

(function () {

    const f = function(s:string) {

        return s.toUpperCase();

    }


    const g = (s:string) => s.toUpperCase();

    const sumar_js = function(a:number, b:number) {
        return a+b;
    }

    const sumar_ts = (a:number, b:number) => a+b;

    const persona ={

        nombre: 'JL',
        getNombre() {
            setTimeout(()=> {
                console.log(`${this.nombre} ok !!!`);
            }, 1000);
        }

    }

    persona.getNombre();
    console.log(g("Hola"));

})();


(function(){
    const nombre = "Luis";
    const apellido ="Aguilar";
    const edad =33;

    function getEdad(){

        return 100+200;
    }

    let salida = `${nombre} ${apellido}(${edad})`;

    console.log(salida)

    salida = `
    ${nombre}
    ${apellido}
    (${edad})`;

    console.log(salida)

    salida = `El nombre es ${nombre}$ y su apellido ${apellido}(${edad+100})`;

    console.log(salida)

    salida = `${nombre}${apellido}(${getEdad()})`;

    console.log(salida)

})();

(() => {


    const gato = {

        nombre:"bigotes",
        color: "cafe",
        raza: "siamés"

    }

    console.log(gato.nombre);
    console.log(gato.color);
    console.log(gato.raza);

    const {nombre, color, raza} = gato;

    console.log(nombre);
    console.log(color);
    console.log(raza);

    const extraer = ({nombre, color}:any) => {
        console.log(nombre);
    console.log(color);
    }
    
    const modelos:string[] = ["Rio", "Sentra", "Versa"];

    const [,sentra,] = modelos;

    console.log(sentra);
    
    const getModelos = ([kia, nissan,]:string[]) => {
        console.log(kia);
        console.log(nissan);
    }

    getModelos(modelos);
    




})();

(() => {

    class Automovil {

        private color:string;

        constructor(color="") {

            if(color == ""){
                this.color="rojo";
            } else {
                this.color = color;
            }

        }


        public getColor() {
            return this.color;
        }

        public setColor(color:string){
            this.color=color;
        }

    }

    var auto = new Automovil();

    console.log(auto.getColor());

})();


(()=> {


    interface AutoBase {

        getColor():string;
        getVelocidad():number;
    }

    class Automovil implements AutoBase {

        private color:string;
        private velocidad:number;

        constructor(color:string, velocidad:number) {
            this.color = color;
            this.velocidad = velocidad;
        }

        public getColor():string {
            return this.color;
        }

        public getVelocidad():number{
            return this.velocidad;
        }

    }

        class Rio extends Automovil {
            constructor () {
            super("rojo" ,5);
            }
        
        }
        
        var auto = new Rio();
        console.log(auto);



})(); */
Object.defineProperty(exports, "__esModule", { value: true });
(function () {
    console.log("Inicio");
    var prom1 = function (n) {
        return new Promise(function (resolve, reject) {
            var i;
            var fact;
            fact = 1;
            if (n >= 0) {
                for (i = 1; i <= n; i++) {
                    fact = fact * i;
                }
                resolve(fact);
            }
            else {
                reject(-1);
            }
        });
    };
    prom1(5)
        .then(function (mensaje) {
        console.log("La operación fue exitosa: ");
        console.log(mensaje);
    })
        .catch(function (err) {
        console.log("La operación fue un fracaso");
        console.warn(err);
    });
    prom1(-5)
        .then(function (mensaje) { return console.log(mensaje); })
        .catch(function (err) { return console.warn(err); });
    console.log("fin");
})();
