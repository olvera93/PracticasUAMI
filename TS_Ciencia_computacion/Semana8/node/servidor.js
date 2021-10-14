var http = require('http');

http.createServer(function (req, res) {
  res.writeHead(200, {'Content-Type': 'text/html'});
  res.end('<html><body><p>Esta es mi pagina web</p></body></html>');
}).listen(3000); 
