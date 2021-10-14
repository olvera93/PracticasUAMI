const DERECHA   =   10;
const IZQUIERDA =   20;
const ARRIBA    =   30;
const ABAJO     =   40;

const TIPOS_COMIDAS = 6;


const TECLA_DERECHA   =   "39";
const TECLA_IZQUIERDA =   "37";
const TECLA_ARRIBA    =   "38";
const TECLA_ABAJO      =   "40";
      
const CARGA    =  100;
const RECARGA  =  200;      
const INICIO   =  300;      
$(document).ready(function(){
     

   function JuegoSerpiente(){
 
      //SE OBTIENE EL CANVAS Y SU CONTEXTO
      this.canvas = null;
      this.ctx = null;
      this.w = 0;
      this.h = 0;  
      //VARIABLE PARA ALMACENAR LA SERPIENTE
      this.serpiente=null;
      this.comida=null;
      this.score=0; //PUNTOS
      this.escala=0.05; // ESCALA DE LA SERPIENTE
      this.cw = 0; // ANCHO DEL CANVAS
      this.imagenComida = new Array();

      this.aleatorio = null

      this.imageHead = new Array();
      this.imageBody = new Array();
      this.imageTail = new Array();
      this.imagenFondo = new Array();

      
      this.estado=CARGA;
      
      var objeto=this;
      

      this.crearSerpiente = function(){
         var tamanio_inicial = 5;
         this.serpiente = []; 
         for(var i = tamanio_inicial-1; i>=0; i--){ //SE CREA LA SERPIENTE
            //SE GUARDAN AL FINAL DEL ARREGLO TOPE [0,0][1,0][2,0][3,0][4,0] 
            
            this.serpiente.push({x: i, y:0}); //SE CREA LA SERPIENTE EN LA POSICION INICIAL
         }
      }  

      
      

        
       
      this.crearComida = function(){ //SE CREA LA COMIDA
         this.aleatorio = Math.floor(Math.random() * this.imagenComida.length);
         this.comida = {
            x: Math.round(Math.random()*(this.w-this.cw)/this.cw), // SE GENERA LA COMIDA EN UNA POSICION ALEATORIA
            y: Math.round(Math.random()*(this.h-this.cw)/this.cw),
            comida: this.aleatorio
             };
                     
      }
 
      this.dibujar = function(){

         var nx,ny,celda_nueva,i,c;
         //SE BORRA EL CANVAS
         objeto.ctx.fillStyle = "white"; 
         objeto.ctx.fillRect(0, 0, objeto.w, objeto.h);

         //SE TOMA EL ELEMENTO EN EL TOPE/INICIO DEL ARREGLO			
         nx = objeto.serpiente[0].x;
         ny = objeto.serpiente[0].y;

         objeto.fondo();
	
         switch(objeto.sentido){ //SE TOMA EL SENTIDO DE LA SERPIENTE
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
         if(nx < 0 || nx*objeto.cw > objeto.w || ny < 0 || ny*objeto.cw > objeto.h || objeto.detectaColision(nx, ny, objeto.serpiente)){
           
            objeto.estado=RECARGA;
            
            return;
         }
         //SI LA COMIDA ESTA EN EL CAMINO DE LA SERPIENTE, ENTONCES SE CREA UNA
         //NUEVA CELDA PARA LA SERPIENTE Y SE CREA UNA NUEVA COMIDA
         if(nx == objeto.comida.x && ny == objeto.comida.y){
            celda_nueva = {x: nx, y: ny};
            objeto.score++;
            objeto.crearComida();
           
         }else{
         //SI LA COMIDA NO ESTA EN EL CAMINO DE LA SERPIENTE, SE QUITA EL ELEMENTO 
         //EN EL TOPE (COLA DE LA SERPIENTE) Y SE AGREGA UN ELEMENTO EN LA CABEZA
         
            celda_nueva = objeto.serpiente.pop(); 
            celda_nueva.x = nx; 
            celda_nueva.y = ny;
         }
         //SE AGREGA AL INICIO DEL ARREGLO (CABEZA)			
         objeto.serpiente.unshift(celda_nueva);
         
         //SE DIBUJA CADA CELDA DE LA SERPIENTE DE LA SERPIENTE
         for(i = 0; i < objeto.serpiente.length; i++){
            c = objeto.serpiente[i];
            objeto.dibujaCelda(c.x, c.y);
         }
         //console.log(objeto.serpiente.length+" ["+"("+objeto.serpiente[0].x+","+objeto.serpiente[0].y+"),"+"("+objeto.serpiente[1].x+","+objeto.serpiente[1].y+"),"+ "("+objeto.serpiente[2].x+","+objeto.serpiente[2].y+"),"+ "("+objeto.serpiente[3].x+","+objeto.serpiente[3].y+"),"+ "("+objeto.serpiente[4].x+","+objeto.serpiente[4].y+")"+"]"          );
		      
         //SE DIBUJA LA COMIDA
         objeto.dibujaCelda(objeto.comida.x, objeto.comida.y);
         
         
         //objeto.ctx.fillStyle = "black";
         //SE DIBUJA EL SCORE
         var score_text = "Score: " + objeto.score;
         objeto.ctx.font=objeto.h*objeto.escala+"px Arial";
         objeto.ctx.fillText(score_text, objeto.h*objeto.escala, objeto.h-5);
         
      }
 
      this.dibujaCelda = function(x, y){ //SE DIBUJA LA CELDA 
      
         // La cabeza de la serpiente cambia a la dirección de movimiento
         if(objeto.sentido == ABAJO){
            if(x == objeto.serpiente[0].x && y == objeto.serpiente[0].y){
               this.imageHead["headDown"] = new Image();  
               this.imageHead["headDown"].src = "img/headSnakeDown.png";
               this.ctx.drawImage(this.imageHead["headDown"], x*this.cw, y*this.cw, this.cw, this.cw);
            }

            // El cuerpo de la serpiente cambia a la dirección de movimiento
            for(var i = 1; i < objeto.serpiente.length -1; i++){
               if(x == objeto.serpiente[i].x && y == objeto.serpiente[i].y){
                  this.imageBody["bodyDown"] = new Image();
                  this.imageBody["bodyDown"].src = "img/bodySnakeUp.png";
                  this.ctx.drawImage(this.imageBody["bodyDown"], x*this.cw, y*this.cw, this.cw, this.cw);
               }
            }

            // La cola de la serpiente cambia a la dirección de movimiento
            if(x == objeto.serpiente[objeto.serpiente.length -1].x && y == objeto.serpiente[objeto.serpiente.length -1].y){ 
               this.imageTail["tailDown"] = new Image();
               this.imageTail["tailDown"].src = "img/tailSnakeDown.png";
               this.ctx.drawImage(this.imageTail["tailDown"], x*this.cw, y*this.cw, this.cw, this.cw);
            }

         

         } else if(objeto.sentido == ARRIBA){
            if(x == objeto.serpiente[0].x && y == objeto.serpiente[0].y){
               this.imageHead["headUp"] = new Image();
               this.imageHead["headUp"].src = "img/headSnakeUp.png";
               this.ctx.drawImage(this.imageHead["headUp"], x*this.cw, y*this.cw, this.cw, this.cw);
            } 

            for(var i = 1; i < objeto.serpiente.length -1; i++){
               if(x == objeto.serpiente[i].x && y == objeto.serpiente[i].y){
                  this.imageBody["bodyUp"] = new Image();
                  this.imageBody["bodyUp"].src = "img/bodySnakeUp.png";
                  this.ctx.drawImage(this.imageBody["bodyUp"], x*this.cw, y*this.cw, this.cw, this.cw);
               }
            }

            // La cola de la serpiente cambia a la dirección de movimiento
            if(x == objeto.serpiente[objeto.serpiente.length -1].x && y == objeto.serpiente[objeto.serpiente.length -1].y){ 
               this.imageTail["tailUp"] = new Image();
               this.imageTail["tailUp"].src = "img/tailSnakeUp.png";
               this.ctx.drawImage(this.imageTail["tailUp"], x*this.cw, y*this.cw, this.cw, this.cw);
            }

         } else if(objeto.sentido == DERECHA){
            if(x == objeto.serpiente[0].x && y == objeto.serpiente[0].y){
               this.imageHead["headRight"] = new Image();
               this.imageHead["headRight"].src = "img/headSnakeRight.png";
               this.ctx.drawImage(this.imageHead["headRight"], x*this.cw, y*this.cw, this.cw, this.cw);
            }

            for(var i = 1; i < objeto.serpiente.length -1; i++){
               if(x == objeto.serpiente[i].x && y == objeto.serpiente[i].y){
                  this.imageBody["bodyRight"] = new Image();
                  this.imageBody["bodyRight"].src = "img/bodySnake.png";
                  this.ctx.drawImage(this.imageBody["bodyRight"], x*this.cw, y*this.cw, this.cw, this.cw);
               }
            }

            // La cola de la serpiente cambia a la dirección de movimiento
            if(x == objeto.serpiente[objeto.serpiente.length -1].x && y == objeto.serpiente[objeto.serpiente.length -1].y){ 
               this.imageTail["tailRight"] = new Image();
               this.imageTail["tailRight"].src = "img/tailSnakeRight.png";
               this.ctx.drawImage(this.imageTail["tailRight"], x*this.cw, y*this.cw, this.cw, this.cw);
            }

         } else if(objeto.sentido == IZQUIERDA){
            if(x == objeto.serpiente[0].x && y == objeto.serpiente[0].y){
               this.imageHead["headLeft"] = new Image();
               this.imageHead["headLeft"].src = "img/headSnakeLeft.png";
               this.ctx.drawImage(this.imageHead["headLeft"], x*this.cw, y*this.cw, this.cw, this.cw);
            }

            for(var i = 1; i < objeto.serpiente.length -1; i++){
               if(x == objeto.serpiente[i].x && y == objeto.serpiente[i].y){
                  this.imageBody["bodyLeft"] = new Image();
                  this.imageBody["bodyLeft"].src = "img/bodySnake.png";
                  this.ctx.drawImage(this.imageBody["bodyLeft"], x*this.cw, y*this.cw, this.cw, this.cw);
               }
            }

            // La cola de la serpiente cambia a la dirección de movimiento
            if(x == objeto.serpiente[objeto.serpiente.length -1].x && y == objeto.serpiente[objeto.serpiente.length -1].y){ 
               this.imageTail["tailLeft"] = new Image();
               this.imageTail["tailLeft"].src = "img/tailSnakeLeft.png";
               this.ctx.drawImage(this.imageTail["tailLeft"], x*this.cw, y*this.cw, this.cw, this.cw);
            }

         }  

            


         // LA COMIDA ES UNA IMAGEN 
         if(x == objeto.comida.x && y == objeto.comida.y){
            for(var i = 0; i < TIPOS_COMIDAS; i++){
               this.imagenComida[i] = new Image();
               this.imagenComida[i].src = "frutas/fruta"+i+".png";
            }
            this.ctx.drawImage(this.imagenComida[this.aleatorio], x*this.cw, y*this.cw, this.cw, this.cw);      
         }
      }
           

      this.detectaColision = function(nx, ny, serpiente){ //SE DETECTA LA COLISION
         var i;
         for(i = 0; i < serpiente.length; i++){ //SE RECORRE EL ARREGLO
            if(serpiente[i].x == nx && serpiente[i].y == ny) //SI LA CELDA ESTA EN EL CAMINO DE LA SERPIENTE
               return true; 
         }
         return false;
      }        


      this.resizeCanvas = function() { //FUNCION PARA REDIMENSIONAR EL CANVAS
      
         objeto.canvas.width = window.innerWidth; //SE REDIMENSIONA EL CANVAS
         objeto.canvas.height = window.innerHeight;
         

         // Agregar un fondo de pantalla en el body
      
         objeto.w = $("#canvas").width(); //SE TOMA EL ANCHO DEL CANVAS
         objeto.h = $("#canvas").height();  //SE TOMA EL ALTO DEL CANVAS
         
         objeto.cw = objeto.h*objeto.escala; //SE TOMA EL ANCHO DE LA CELDA
         objeto.ctx.font=objeto.h*objeto.escala+"px Arial"; //SE CAMBIA EL TAMAÑO DE LA FUENTE DEL SCORE
        
      }

       
      this.move = function(){ //FUNCION PARA MOVER LA SERPIENTE
         //SE CAPTURAN LO EVENTO DEL TECLADO
       $(document).keydown(function(e){
         var tecla = e.which;
               
         if(tecla == TECLA_IZQUIERDA && objeto.sentido != DERECHA) 
            objeto.sentido = IZQUIERDA;
         else 
            if(tecla == TECLA_ARRIBA && objeto.sentido != ABAJO) 
               objeto.sentido = ARRIBA;
            else 
               if(tecla == TECLA_DERECHA && objeto.sentido != IZQUIERDA) 
                  objeto.sentido = DERECHA;
              else 
                  if(tecla == TECLA_ABAJO && objeto.sentido != ARRIBA) 
                     objeto.sentido = ABAJO;
                     
     
      ;})  
      
      var mc = new Hammer(document.getElementById('canvas'));
      mc.get('swipe').set({ direction: Hammer.DIRECTION_ALL });

    mc.on("swipeleft swipeup swiperight swipedown", function (ev) {        
        if (ev.type === 'swipeleft' && objeto.sentido !== DERECHA) {
         objeto.sentido = IZQUIERDA;
        } else if (ev.type === 'swipeup' && objeto.sentido !== ABAJO) {
         objeto.sentido = ARRIBA;
        } else if (ev.type === 'swiperight' && objeto.sentido !== IZQUIERDA) {
         objeto.sentido = DERECHA;
        } else if (ev.type === 'swipedown' && objeto.sentido !== ARRIBA) {
         objeto.sentido = ABAJO;
        }
    });

      
      }
       
       
      
       
       //SE AGREGAN LO EVENTOS PARA CUANDO CAMBIA EL TAMANIO DE LA VENTANA             
       $(window).resize(function(e){
              objeto.resizeCanvas();
              
       ;}) 
       
       this.inicializa = function(){ //FUNCION PARA INICIALIZAR EL JUEGO
     
           this.canvas = $("#canvas")[0];
           this.canvas.width = window.innerWidth;
           this.canvas.height = window.innerHeight;   
     
           this.ctx = canvas.getContext("2d");
           this.w = $("#canvas").width(); //ANCHO DEL CANVAS
           this.h = $("#canvas").height(); //ALTO DEL CANVAS
           this.cw = this.h*this.escala; 
           this.ctx.font=this.h*this.escala+"px Arial"; //SE ESTABLECE EL TAMANIO DE LA LETRA
       } 

       this.fondo = function(){ //FUNCION PARA EL FONDO DEL CANVAS
            this.imagenFondo["background"] = new Image();
            this.imagenFondo["background"].src = "img/background.jpg";
           this.ctx.drawImage(this.imagenFondo["background"], 0, 0, this.w, this.h);
       }
       
      this.maquinaDeEstados = function(){ //FUNCION PARA LA MAQUINA DE ESTADOS
   
         if(objeto.estado==CARGA){ //ESTADO DE CARGA
            objeto.inicializa(); 
            objeto.sentido = DERECHA; 
            objeto.crearSerpiente();
            objeto.move();
            objeto.crearComida(); 
            objeto.score = 0;
            objeto.estado=INICIO;
            setInterval(objeto.maquinaDeEstados, 80); 
         }else{
            if(objeto.estado==RECARGA){ //SE RECARGA EL JUEGO
               objeto.sentido = DERECHA; 
               objeto.crearSerpiente();
               objeto.move();
               objeto.crearComida(); 
               objeto.score = 0;
               objeto.estado=INICIO;
            }else{
                objeto.dibujar();
            
            }                
         }              
      }
  }

   s = new JuegoSerpiente();
   s.maquinaDeEstados();
})



