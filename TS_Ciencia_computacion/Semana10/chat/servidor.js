const express = require('express');
const app = express();
app.use(express.urlencoded({
extended: true
}))
app.use(express.static(__dirname + '/src'));
const http = require('http').Server(app);
const io = require('socket.io')(http);
const port = process.env.PORT || 3000;

app.get('/', (req, res) => {
  res.sendFile(__dirname + '/index.html');
});

io.on('connection', (socket) => {
  //Se escucha el evento
  socket.on('enviar', msg => {
    io.emit('intercambio', msg);
  });
});

http.listen(port, () => {
  console.log(`Socket.IO en la URL http://localhost:${port}/`);
});
