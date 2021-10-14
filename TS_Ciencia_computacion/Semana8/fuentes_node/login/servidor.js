/*
npm install express
npm install mathjs

*/
const express = require("express");
const app = express();
app.use(express.urlencoded({
extended: true
}))


const mysql = require('mysql');

var con = mysql.createConnection({
  host: "localhost",
  user: "uwebsql",
  password: "2021uwebts-sql",
  database: "usuarios"
});

con.connect(function(err) {
  if (err) throw err;
  console.log("Connected!");
  con.query("SELECT * FROM users", function (err, result, fields) {
    if (err) throw err;
    console.log(result);
  });
});
   


app.use(express.static(__dirname + '/src'));

app.get('/', function (req, res) {
  res.sendFile(__dirname + '/index.html');
});


app.post('/valida', function(req, response) {

   var usuario = req.body.user;
   var password = req.body.pass;
   console.log(usuario);
   console.log(password);
   if (usuario && password) {
      con.query('SELECT * FROM users WHERE nickname = ? AND password = ?', [usuario, password], function(error, results, fields) {
                  console.log(results);
	  if (results.length > 0) {
	     response.send('Bienvenido!!!');
	  } else {
	     response.send('Usuario o password incorrectos!');
                  }			
	  response.end();
       });
    } else {
        response.send('Ingresa un usuario y un password');
        response.end();
   }
})


app.listen(3000, () => {
   'use strict';

});
