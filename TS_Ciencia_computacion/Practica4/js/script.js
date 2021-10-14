const DERECHA = 10;
const IZQUIERDA = 20;
const ARRIBA = 30;
const ABAJO = 40;

const TECLA_DERECHA = "39";
const TECLA_IZQUIERDA = "37";
const TECLA_ARRIBA = "38";
const TECLA_ABAJO = "40";

/* Maquinas de estados */
const CARGA = 100;
const RECARGA = 200;
const INICIO = 300;

$(document).ready(function () {


   function JuegoSerpiente() {

      //SE OBTIENE EL CANVAS Y SU CONTEXTO
      this.canvas = null;
      this.ctx = null;
      this.w = 0;
      this.h = 0;
      //VARIABLE PARA ALMACENAR LA SERPIENTE
      this.serpiente = null;
      this.comida = null;
      this.score = 0;
      this.escala = 0.03; /* escala del cuadro a manejar */
      this.cw = 0; /* es el width que va a tener la comida o los cuadros de la serpiernte */
      //VARIABLES PARA LAS IMAGENES DE LA COMIDA
      this.imgComida1 = new Image();
      this.imgComida1.src = "img/fruta1.png";
      this.imgComida2 = new Image();
      this.imgComida2.src = "img/fruta2.png";
      this.imgComida3 = new Image();
      this.imgComida3.src = "img/fruta3.png";
      this.imgComida4 = new Image();
      this.imgComida4.src = "img/fruta4.png";
      this.imgComida5 = new Image();
      this.imgComida5.src = "img/turtle.png";
      var arregloFrutas = [this.imgComida1,this.imgComida2,this.imgComida3,this.imgComida4,this.imgComida5];
      var frutaRandom = Math.floor(Math.random()*5);
      //VARIABLES PARA LA CABEZA Y CUERPO DE LA SERPIENTE
      this.imgCabeza = new Image();
      this.imgCabeza.src = "img/snakeHead2.png";//derecha
      this.imgCabezaIzquierda = new Image();
      this.imgCabezaIzquierda.src = "img/snakeHeadLeft2.png";
      this.imgCabezaArriba = new Image();
      this.imgCabezaArriba.src = "img/snakeHeadUp2.png";
      this.imgCabezaAbajo = new Image();
      this.imgCabezaAbajo.src = "img/snakeHeadDown2.png";
      this.imgCuerpo = new Image();
      this.imgCuerpo.src = "img/snakeBody2.png";
      
      this.estado = CARGA;

      var objeto = this; //hace referencia al objeto para el contexto del objeto juego serp.

      this.crearSerpiente = function () {
         var tamanio_inicial = 5;
         this.serpiente = [];
         for (var i = tamanio_inicial - 1; i >= 0; i--) {
            //SE GUARDAN AL FINAL DEL ARREGLO TOPE [0,0][1,0][2,0][3,0][4,0] 

            this.serpiente.push({ x: i, y: 0 });
         }
      }

      this.crearComida = function () {
         //* se crea un objeto de dos entradas
         this.comida = {
            // se crean de forma aleatoria
            x: Math.round(Math.random() * (this.w - this.cw) / this.cw),
            y: Math.round(Math.random() * (this.h - this.cw) / this.cw),
         };//
      }

      this.dibujar = function () {

         var nx, ny, celda_nueva, i, c;
         //SE BORRA EL CANVAS
         objeto.ctx.fillStyle = "white";
         objeto.ctx.fillRect(0, 0, objeto.w, objeto.h);
         //VAMOS A DIBUJAR LA IMAGEN DE FONDO PARA EL CANVAS
         var imgFondo = new Image();
         imgFondo.src = "img/fondo2.jpg"
         this.ctx.drawImage(imgFondo, 0, 0, this.canvas.width, this.canvas.height);
         //SE TOMA EL ELEMENTO EN EL TOPE/INICIO DEL ARREGLO			
         nx = objeto.serpiente[0].x;
         ny = objeto.serpiente[0].y;

         switch (objeto.sentido) {
            case DERECHA:
               nx++;
               break;
            case IZQUIERDA:
               nx--;
               break;
            case ARRIBA:
               ny--;
               break;
            case ABAJO:
               ny++;
               break;
         }
         //SE REINICIA EL JUEGO	
         if (nx < 0 || nx * objeto.cw > objeto.w || ny < 0 || ny * objeto.cw > objeto.h || objeto.detectaColision(nx, ny, objeto.serpiente)) {
            objeto.estado = RECARGA;
            frutaRandom = Math.floor(Math.random()*5);
            return;
         }
         //SI LA COMIDA ESTA EN EL CAMINO DE LA SERPIENTE, ENTONCES SE CREA UNA
         //NUEVA CELDA PARA LA SERPIENTE Y SE CREA UNA NUEVA COMIDA
         if (nx == objeto.comida.x && ny == objeto.comida.y) {
            celda_nueva = { x: nx, y: ny };
            objeto.score++;
            frutaRandom = Math.floor(Math.random()*5);
            objeto.crearComida();
         } else {
            //SI LA COMIDA NO ESTA EN EL CAMINO DE LA SERPIENTE, SE QUITA EL ELEMENTO 
            //EN EL TOPE (COLA DE LA SERPIENTE) Y SE AGREGA UN ELEMENTO EN LA CABEZA
            celda_nueva = objeto.serpiente.pop();
            celda_nueva.x = nx;
            celda_nueva.y = ny;
         }
         //SE AGREGA AL INICIO DEL ARREGLO (CABEZA)			
         objeto.serpiente.unshift(celda_nueva);
         //SE DIBUJA CADA CELDA DE LA SERPIENTE DE LA SERPIENTE
         for (i = 0; i < objeto.serpiente.length; i++) {
            c = objeto.serpiente[i];
            //objeto.dibujaCeldaSnake(c.x, c.y);
            objeto.dibujaCeldaSnake();
            //if (objeto.sentido == DERECHA || objeto.sentido == IZQUIERDA || objeto.sentido == ARRIBA || objeto.sentido == ABAJO)
              // this.ctx.drawImage(this.imgCuerpo,objeto.serpiente[i+1].x*this.cw, objeto.serpiente[i+1].y*this.cw, this.cw, this.cw);
         }
         //console.log(objeto.serpiente.length + " [" + "(" + objeto.serpiente[0].x + "," + objeto.serpiente[0].y + ")," + "(" + objeto.serpiente[1].x + "," + objeto.serpiente[1].y + ")," + "(" + objeto.serpiente[2].x + "," + objeto.serpiente[2].y + ")," + "(" + objeto.serpiente[3].x + "," + objeto.serpiente[3].y + ")," + "(" + objeto.serpiente[4].x + "," + objeto.serpiente[4].y + ")" + "]");

         //SE DIBUJA LA COMIDA
         objeto.dibujaCeldaComida(objeto.comida.x, objeto.comida.y);

         //SE DIBUJA EL SCORE
         var score_text = "Score: " + objeto.score;
         objeto.ctx.font = objeto.h * objeto.escala + "px Arial";
         objeto.ctx.fillText(score_text, objeto.h * objeto.escala, objeto.h - 5);
      }
      //DIBUJA LA COMIDA
      this.dibujaCeldaComida = function (x, y) {
         this.ctx.drawImage(arregloFrutas[frutaRandom],x*this.cw, y*this.cw, this.cw, this.cw);
      }
      //se dibuja el cuerpo y cabeza de la serpiente
      this.dibujaCeldaSnake = function (x, y) {
         if (objeto.sentido == DERECHA){
            this.ctx.drawImage(this.imgCabeza,objeto.serpiente[0].x*this.cw, objeto.serpiente[0].y*this.cw, this.cw, this.cw);
         }else if (objeto.sentido == IZQUIERDA){
            this.ctx.drawImage(this.imgCabezaIzquierda,objeto.serpiente[0].x*this.cw, objeto.serpiente[0].y*this.cw, this.cw, this.cw);
         }else if (objeto.sentido == ARRIBA){
            this.ctx.drawImage(this.imgCabezaArriba,objeto.serpiente[0].x*this.cw, objeto.serpiente[0].y*this.cw, this.cw, this.cw);
         }else if (objeto.sentido == ABAJO){
            this.ctx.drawImage(this.imgCabezaAbajo,objeto.serpiente[0].x*this.cw, objeto.serpiente[0].y*this.cw, this.cw, this.cw);
         }
         for (i = 1; i < objeto.serpiente.length; i++) {
            if (objeto.sentido == DERECHA || objeto.sentido == IZQUIERDA || objeto.sentido == ARRIBA || objeto.sentido == ABAJO)
               this.ctx.drawImage(this.imgCuerpo,objeto.serpiente[i].x*this.cw, objeto.serpiente[i].y*this.cw, this.cw, this.cw);
         }
      }
      
      this.detectaColision = function (nx, ny, serpiente) {
         var i;
         for (i = 0; i < serpiente.length; i++) {
            if (serpiente[i].x == nx && serpiente[i].y == ny)
               return true;
         }
         return false;
      }

      this.resizeCanvas = function () {

         objeto.canvas.width = window.innerWidth;
         objeto.canvas.height = window.innerHeight;

         objeto.w = $("#canvas").width();
         objeto.h = $("#canvas").height();

         objeto.cw = objeto.h * objeto.escala;
         objeto.ctx.font = objeto.h * objeto.escala + "px Arial";

      }

      //PARA EL TOUCH
      var elemento = document.getElementById('canvas');
      var mc = new Hammer(elemento);
      mc.get('swipe').set({ direction: Hammer.DIRECTION_ALL });
      //mc.on("panleft panright panup pandown tap press", function(ev) {
      mc.on("swipeleft swiperight swipeup swipedown tap press", function(ev) {
         var tecla=ev.type;
         if(tecla == "swipeleft" && objeto.sentido != DERECHA) 
            objeto.sentido = IZQUIERDA;
         else 
            if(tecla == "swipeup" && objeto.sentido != ABAJO) 
               objeto.sentido = ARRIBA;
            else 
               if(tecla == "swiperight" && objeto.sentido != IZQUIERDA) 
                  objeto.sentido = DERECHA;
               else 
                  if(tecla == "swipedown" && objeto.sentido != ARRIBA) 
                     objeto.sentido = ABAJO;
         //console.log(objeto.sentido); 
      });
      //FINPARA EL TOUCH

      //SE CAPTURAN LO EVENTO DEL TECLADO
      $(document).keydown(function (e) {
         var tecla = e.which;
         if (tecla == TECLA_IZQUIERDA && objeto.sentido != DERECHA)
            objeto.sentido = IZQUIERDA;
         else
            if (tecla == TECLA_ARRIBA && objeto.sentido != ABAJO)
               objeto.sentido = ARRIBA;
            else
               if (tecla == TECLA_DERECHA && objeto.sentido != IZQUIERDA)
                  objeto.sentido = DERECHA;
               else
                  if (tecla == TECLA_ABAJO && objeto.sentido != ARRIBA)
                     objeto.sentido = ABAJO;

         ;
      })

      //SE AGREGAN LO EVENTOS PARA CUANDO CAMBIA EL TAMANIO DE LA VENTANA             
      $(window).resize(function (e) {
         objeto.resizeCanvas();

         ;
      })

      this.inicializa = function () {
         this.canvas = $("#canvas")[0];
         this.canvas.width = window.innerWidth;
         this.canvas.height = window.innerHeight;
         this.ctx = canvas.getContext("2d");
         this.w = $("#canvas").width();
         this.h = $("#canvas").height();
         this.cw = this.h * this.escala;
         this.ctx.font = this.h * this.escala + "px Arial";
      }

      this.maquinaDeEstados = function () {

         if (objeto.estado == CARGA) {
            objeto.inicializa();
            objeto.sentido = DERECHA;
            objeto.crearSerpiente();
            objeto.crearComida();
            objeto.score = 0;
            objeto.estado = INICIO;
            setInterval(objeto.maquinaDeEstados, 80);
         } else {
            if (objeto.estado == RECARGA) {

               objeto.sentido = DERECHA;
               objeto.crearSerpiente();
               objeto.crearComida();
               objeto.score = 0;
               objeto.estado = INICIO;
            } else {
               objeto.dibujar();

            }
         }
      }
   }
   s = new JuegoSerpiente();
   s.maquinaDeEstados();
})