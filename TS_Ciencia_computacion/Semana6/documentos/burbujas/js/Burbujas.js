    const
    INICIALIZACION = 100;
    const
    ETAPA1 = 200;
    const
    BURBUJAS = 10;


    function Burbuja(x, y, radio) {
        this.x = x;
        this.y = y;
        this.radio = radio;
        this.color = "blue";
        this.velocidad = 10;

        this.getX = function() {
            return this.x;
        };
        this.getY = function() {
            return this.y;
        };
        this.getRadio = function() {
            return this.radio;
        };
        this.getColor = function() {
            return this.color;
        };
        this.getVelocidad = function() {
            return this.velocidad;
        };
        this.setX = function(x) {
            this.x = x;
        };
        this.setY = function(y) {
            this.y = y;
        };
        this.setRadio = function(radio) {
            this.radio = radio;
        };
        this.setColor = function(color) {
            this.color = color;
        };
        this.setVelocidad = function(velocidad) {
            this.velocidad = velocidad;
        };
        this.dibujar = function(ctx) {

            ctx.save();
            ctx.fillStyle = this.color;
            ctx.beginPath();
            ctx.arc(this.x, this.y, this.radio, 0, Math.PI * 2, true);
            ctx.fill();

            ctx.fillStyle = "white";
            ctx.beginPath();
            ctx.arc(this.x + this.radio / 3, this.y - this.radio / 3,
            this.radio / 4, 0, Math.PI * 2, true);
            ctx.fill();
            ctx.restore();
        };

        this.coordenadas = function(x, y) {

            var ax=this.getX()-this.getRadio();
            var ay=this.getY()-this.getRadio();
            return (x>=ax)
            && (x<=(ax + 2*this.getRadio()))
            && (y>=ay)
            && (y<=(ay + 2*this.getRadio()));

        };

    }

    function animacionBurbujas() {

        var burbujas= new Array();
        var arrayColores;
        var canvas = document.getElementById("canvas");
        var ctx = canvas.getContext('2d');
        var estado = INICIALIZACION;
        var app = this;

        canvas.width = window.innerWidth;
        canvas.height = window.innerHeight;

        this.click = function(e){
	
            var x = e.x ||  e.pageX || e.clientX;
            var y = e.y ||  e.clientY || e.pageY  ;
            var i;
            var bandera = false;

            for(i=0;i<burbujas.length;i++){
                aux=burbujas[i];
                if (aux.coordenadas(x, y)) {
                    bandera = true;
                    break;
                }
            }

            if (bandera) {
               aux.setY(0);
            }
        


        }

        canvas.addEventListener('mousedown',this.click,false);


        this.realizarAnimacion = function() {

        var i,aux;

        ctx.clearRect(0, 0, canvas.width, canvas.height);

        for(i=0;i<burbujas.length;i++){
             aux=burbujas[i];
             if (aux.getY() < canvas.height) {
                aux.setY(aux.getY()+ aux.getVelocidad());
             } else {
                    aux.setY(0);
                    aux.setColor(arrayColores[Math.floor(Math.random() * 4)]);
             }
             aux.dibujar(ctx);

        }


        setTimeout(app.realizarAnimacion, 100);

        };

        this.crearBurbujas = function() {

        var burbuja;

        var i;

        for (i = 1; i <= BURBUJAS; i++) {
            burbuja = new Burbuja(canvas.width * (i / BURBUJAS),
                0, this.generaAleatorio(Math
                    .floor(canvas.width / 20)));
            burbuja.setVelocidad(10);
            burbuja.setColor(arrayColores[this.generaAleatorio(4)]); 
            burbujas.push(burbuja);

        }

        };

        this.generaAleatorio = function(num) {

           return Math.floor(Math.random() * num);

        };

        this.initColor = function() {

            arrayColores[0] = "#C923C9";
            arrayColores[1] = "#FAEF20";
            arrayColores[2] = "#20ECFA";
            arrayColores[3] = "#FA209C";

        };

        this.maquinaEstados = function() {

          if (estado == INICIALIZACION) {

            arrayColores = new Array();
            this.initColor();
            this.crearBurbujas();
            estado = ETAPA1;
            setTimeout(app.maquinaEstados, 100);
          } else {

            app.realizarAnimacion();

          }

        };

        this.maquinaEstados();

    }

    new animacionBurbujas();
