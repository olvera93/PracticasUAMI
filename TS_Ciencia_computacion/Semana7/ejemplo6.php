<?php

    class Contacto {
        public $nombre;
        public $fecha;
        public $correo;

        function __construct($nombre, $fecha, $correo) {
            $this->nombre = $nombre;
            $this->fecha = $fecha;
            $this->correo = $correo;
        }

        function getNombre() {
            return $this->nombre;
        }

        function setNombre($nombre) {
            $this->nombre = $nombre;
        }

        function getFecha() {
            return $this->fecha;
        }

        function setFecha($fecha) {
            $this->fecha = $fecha;
        }

        function getCorreo() {
            return $this->correo;
        }

        function setCorreo($correo) {
            $this->correo = $correo;
        }

    }

    $fecha = new DateTime("12/31/2019");
    $c = new Contacto("Gonzallo", $fecha, "olvera@correo.com");
    echo $c->getNombre();
    echo "<br>";
    echo $c->getFecha()->format("m/d/Y");
    echo "<br>";
    echo $c->getCorreo();
?>