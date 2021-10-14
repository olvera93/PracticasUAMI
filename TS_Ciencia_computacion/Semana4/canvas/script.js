const CREACION = 100;
const PRECARGA = 200;
const INICIO   = 300;

const TIPOS_NAVES = 4;
const TOTAL_NAVES = 60;
const VELOCIDAD = 8;

class NaveEspacial{

   constructor(x, y,imagen){
      this.x = x;
      this.y = y;
      this.velocidad = Math.floor(Math.random() * VELOCIDAD) + 1;
      this.imagen=imagen;
      this.gdireccion=null;
      this.sdireccion=null;
   }      	
   getX() {
     return this.x;
   }
   getY(){
     return this.y;
   }
   getVelocidad(){
      return this.velocidad;
   }    
   setX(x){
      this.x = x;
   }
   setY(y) {
      this.y = y;
   }  
   setVelocidad(velocidad){
      this.velocidad=velocidad;
   }     
   setImagen(imagen) {
      this.imagen = imagen;
   }
   getImagen() {
      return this.imagen;
   }

   

   dibujar(ctx) {
   /*
   Parametros:
      context.drawImage(img,fx(fuente x),fy,fwidth,fheight,x,y,width,height);
   */

     ctx.drawImage(this.getImagen(),0,0,this.getImagen().width,this.getImagen().height,this.getX(),this.getY(),this.getImagen().width,this.getImagen().height); // Dibuja la imagen
   
   }
 }

function Animacion(){
   
   this.estado = CREACION;
   this.naves = [TOTAL_NAVES]; // Array de naves
   this.imagenes  = new Array();
   this.canvas = document.getElementById("canvas");
   this.contexto = this.canvas.getContext("2d");
   this.auxcanvas = document.createElement("canvas");
   this.auxcontexto = this.auxcanvas.getContext("2d")
     
   // Es para que el canvas sea redimensionable
   this.canvas.width=document.body.clientWidth;
   this.canvas.height=document.body.clientHeight;
   this.auxcanvas.width=document.body.clientWidth; 
   this.auxcanvas.height=document.body.clientHeight;

  
   this.naveNodrisa = null; // nave nodrisa
   var objeto=this; // es para que el this de la funcion sea el objeto de la clase
   
   this.cargarImagenes = function(){      
      for (var i=0;i<TIPOS_NAVES;i++){
         this.imagenes[i]=new Image();
         this.imagenes[i].src="img/nave"+i+".png";
      } 
      
   }


   this.random = function(min, max) {
      return Math.floor(Math.random() * (max - min + 1)) + min;
   }
  
   this.actualizacion = function(){
   /*
    context.clearRect(x,y,width,height);
   */
      this.auxcontexto.clearRect(0, 0, this.canvas.width, this.canvas.height); // Limpia el canvas
      this.contexto.clearRect(0, 0, this.canvas.width, this.canvas.height); // Limpia el canvas

      this.naveNodrisa.dibujar(this.auxcontexto); // Dibuja la nave en el auxiliar

         
   /*
   Parametros:
      context.drawImage(img,fx(fuente x),fy,fwidth,fheight,x,y,width,height);
   */
      this.contexto.drawImage(this.auxcanvas,0,0,this.auxcanvas.width,this.auxcanvas.height,0,0,this.canvas.width,this.canvas.height); // Dibuja la nave en el canvas
  

      // Mueve la nave nodrisa hacia direferntes lados
     
      this.naveNodrisa.sdireccion((this.naveNodrisa.gdireccion()) +  this.naveNodrisa.getVelocidad()); // Mueve la nave

      var i;
      for (i=0;i<this.naves.length;i++)
         this.naves[i].dibujar(this.auxcontexto);
         this.contexto.drawImage(this.auxcanvas,0,0,this.auxcanvas.width,this.auxcanvas.height,0,0,this.canvas.width,this.canvas.height); // Dibuja la nave en el canvas
         
          // Todas las naves se mueven hacia arriba, pero algunas se mueven hacia izquierda y otras hacia derecha
          if (i%2 == 0){ //
            this.naves[i].sdireccion((this.naves[i].gdireccion()) -  this.naves[i].getVelocidad()); // Mueve la nave
         }else{
            this.naves[i].sdireccion((this.naves[i].gdireccion()) +  this.naves[i].getVelocidad()); // Mueve la nave
         }

         if(i%2 == 1){ 
            this.naves[i].setY(this.naves[i].getY() + this.naves[i].getVelocidad()); // Mueve la nave
            this.naves[i].sdireccion((this.naves[i].gdireccion()) -  this.naves[i].getVelocidad()); // Mueve la nave
         }    

         if((this.naves[i].getX()>this.canvas.width - this.naves[i].getImagen().width)){ // Si la nave sale por la derecha
            this.naves[i].setX(this.canvas.width - this.naves[i].getImagen().width);
            this.naves[i].setVelocidad(this.naves[i].getVelocidad()*-1);            
         }

         if( (this.naves[i].getX() <= 0)){ // Si la nave sale por la izquierda
            this.naves[i].setX(0);
            this.naves[i].setVelocidad(this.naves[i].getVelocidad()*-1);
         }

         if( (this.naves[i].getY()>=this.canvas.height - this.naves[i].getImagen().height)){ // si la nave sale por la parte abajo
            this.naves[i].setY(this.canvas.height - this.naves[i].getImagen().height);
            this.naves[i].setVelocidad(this.naves[i].getVelocidad()*-1);
         }

         if( (this.naves[i].getY()<=0)){ // si la nave sale por la parte arriba
            this.naves[i].setY(0);
            this.naves[i].setVelocidad(this.naves[i].getVelocidad()*-1);
         }
      }


      if((this.naveNodrisa.getX()>this.canvas.width - this.naveNodrisa.getImagen().width)){ // Si la nave sale por la derecha
         this.naveNodrisa.setX(this.canvas.width - this.naveNodrisa.getImagen().width);
         this.naveNodrisa.setVelocidad(this.naveNodrisa.getVelocidad()*-1);
      }

      if( (this.naveNodrisa.getX() <= 0)){ // Si la nave sale por la izquierda
         this.naveNodrisa.setX(0);
         this.naveNodrisa.setVelocidad(this.naveNodrisa.getVelocidad()*-1);   
      }

      if( (this.naveNodrisa.getY()>=this.canvas.height - this.naveNodrisa.getImagen().height)){ // si la nave sale por la parte abajo
         this.naveNodrisa.setY(this.canvas.height - this.naveNodrisa.getImagen().height);
         this.naveNodrisa.setVelocidad(this.naveNodrisa.getVelocidad()*-1);
      }  
      
      if( (this.naveNodrisa.getY()<=0)){ // si la nave sale por la parte arriba
         this.naveNodrisa.setY(0);
         this.naveNodrisa.setVelocidad(this.naveNodrisa.getVelocidad()*-1);
      }
   }

   this.desplazamiento = function(e) {

      e = e || window.event;

      if (e.keyCode == '38'|| e.keyCode == '40') {
         //arriba
         objeto.naveNodrisa.sdireccion=objeto.naveNodrisa.setY;
         objeto.naveNodrisa.gdireccion=objeto.naveNodrisa.getY; 


         if (e.keyCode == '38'){ //Arriba
            objeto.naveNodrisa.setVelocidad(-3);

         }else{//Abajo
            objeto.naveNodrisa.setVelocidad(3);   
      
         }
      }
      else if (e.keyCode == '37' || e.keyCode == '39') {
         objeto.naveNodrisa.sdireccion=objeto.naveNodrisa.setX;
         objeto.naveNodrisa.gdireccion=objeto.naveNodrisa.getX;
         
         if (e.keyCode == '37'){ //izquierda
            objeto.naveNodrisa.setVelocidad(-3);

     
         }else{//derecha
            objeto.naveNodrisa.setVelocidad(3);   
            
         }
      }
 }

   this.ejecutarMaquinadeEstados = function(){
      var imagenesCargadas=true;
      console.log("Estado: Entro "+objeto.estado);
      if (objeto.estado == CREACION) {
         objeto.cargarImagenes();
         objeto.estado = PRECARGA
         setTimeout(objeto.ejecutarMaquinadeEstados, 100);
         console.log("Estado: creacion");

      } else {
         if(objeto.estado==PRECARGA){

            console.log("Estado: precarga");
            for(var i=0;i<objeto.imagenes.length;i++) // recorre el array de imagenes
               if(objeto.imagenes[i].complete!=true) // si no esta cargada
                  imagenesCargadas=false;                  
            if(imagenesCargadas==true){ // si todas las imagenes estan cargadas
             
               objeto.naveNodrisa = new NaveEspacial(objeto.random(0,objeto.canvas.width-objeto.imagenes[3].width),objeto.random(0,objeto.canvas.height-objeto.imagenes[3].height),objeto.imagenes[3]); // crea la nave
               objeto.naveNodrisa.gdireccion=objeto.naveNodrisa.getX; // establece la funcion que devuelve la posicion en x
               objeto.naveNodrisa.sdireccion=objeto.naveNodrisa.setX; // establece la funcion que modifica la posicion en x
               document.onkeydown = objeto.desplazamiento;

               for( var i=0;i<TOTAL_NAVES;i++){ // crea las naves 
                  objeto.naves[i] = new NaveEspacial(objeto.random(0,objeto.canvas.width-objeto.imagenes[i%(TIPOS_NAVES-1)].width),objeto.random(0,objeto.canvas.height-objeto.imagenes[i%(TIPOS_NAVES-1)].height),objeto.imagenes[i%(TIPOS_NAVES-1)]);
                  objeto.naves[i].gdireccion=objeto.naves[i].getX;
                  objeto.naves[i].sdireccion=objeto.naves[i].setX;
               }

            objeto.estado = INICIO; // cambia el estado

            }
            setTimeout(objeto.ejecutarMaquinadeEstados, 100); // ejecuta la funcion de nuevo
         }else{
            if(objeto.estado==INICIO){
               console.log("Estado: inicio de la animacion");              
               objeto.actualizacion();
               setTimeout(objeto.ejecutarMaquinadeEstados, 100);
            }
         }
      }
   }

}

animacion= new Animacion();


animacion.ejecutarMaquinadeEstados();








