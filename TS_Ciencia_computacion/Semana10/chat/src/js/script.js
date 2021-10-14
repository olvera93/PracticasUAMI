var socket = io();

var mensajes = document.getElementById('mensajes');
var form = document.getElementById('form');
var input = document.getElementById('input');

form.addEventListener('submit', function(e) {
   e.preventDefault();
   if (input.value) {
      //Se origina el evento enviar
      socket.emit('enviar', input.value);
      input.value = '';
   }
});

//Se escuha el evento intercambio
socket.on('intercambio', function(msg) {
  var item = document.createElement('li');
  item.textContent = msg;
  mensajes.appendChild(item);
  window.scrollTo(0, document.body.scrollHeight);
});
