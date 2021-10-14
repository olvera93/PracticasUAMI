/*
npm install express
npm install mathjs

*/
const express = require("express");
const app = express();
app.use(express.urlencoded({
extended: true
}))
const { evaluate } = require('mathjs')

app.use(express.static(__dirname + '/src')); 

app.get('/', function (req, res) { // Pagina inicial 
  res.sendFile(__dirname + '/calculadora.html');
});


app.post('/calc', function (req, res) {
   
  console.log(req.body.expresion);
  var r;
  try{
  
    var r = evaluate(req.body.expresion); 
    console.log(r);
  
  }catch(e){
  
    r="Error";
  }
  
  res.send(r+'');
   
})

app.listen(3000, () => { // Puerto
   'use strict';

});
