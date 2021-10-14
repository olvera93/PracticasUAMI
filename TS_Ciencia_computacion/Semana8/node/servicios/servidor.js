var i=0;
const express = require("express");
const app = express();

app.get('/', function (req, res) {
  res.sendFile(__dirname + '/semaforos.html');
});



app.get('/semaforoizt', function (req, res) {
   
   var file;
   const fs = require('fs');
   file='semaforos_iztapalapa.json'
   let rawdata = fs.readFileSync(file);
   let semaforo = JSON.parse(rawdata)
   res.json(semaforo);
   
})
app.get('/semaforoizc', function (req, res) {
   
   var file;
   const fs = require('fs');
   file='semaforos_iztacalco.json'
   let rawdata = fs.readFileSync(file);
   let semaforo = JSON.parse(rawdata)
   res.json(semaforo);
   
})
app.get('/semaforomh', function (req, res) {
   
   var file;
   const fs = require('fs');
   file='semaforos_miguelhidalgo.json'
   let rawdata = fs.readFileSync(file);
   let semaforo = JSON.parse(rawdata)
   res.json(semaforo);
   
})


app.listen(3000, () => {
   'use strict';

});
