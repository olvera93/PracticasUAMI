const express = require("express");
const app = express();
app.use(express.urlencoded({
extended: true
}))

app.use(express.static(__dirname + '/src'));

app.get('/', function (req, res) {
  res.sendFile(__dirname + '/principal.html');
});



const mongo = require('mongodb').MongoClient;
const url = "mongodb://localhost:27017/";


app.get('/metro', function(req, res) {

  mongo.connect(url, function(err, db) {
    if (err) throw err;
      var dbo = db.db("georref");
    dbo.collection("metro").find({}).toArray(function(err, result) {
    if (err) throw err;
      console.log(result);
    db.close();
    res.json(result);
    });
  });
})

app.get('/ciudad', function(req, res) {

  mongo.connect(url, function(err, db) {
    if (err) throw err;
      var dbo = db.db("georref");
    dbo.collection("cdmx").find({'nomgeo': { $eq: 'Miguel Hidalgo', $eq: 'Xochimilco' } }).toArray(function(err, result) {
    if (err) throw err;
      console.log(result);
    db.close();
    res.json(result);
    });
  });
})


app.get('/izta', function(req, res) {

  mongo.connect(url, function(err, db) {
    if (err) throw err;
      var dbo = db.db("georref");
    dbo.collection("semaforos").find({'alcaldia': { $eq: "Iztapalapa" }}).toArray(function(err, result) {
    if (err) throw err;
      console.log(result);
    db.close();
    res.json(result);
    });
  });
})

app.get('/iztapa', function(req, res) {
  mongo.connect(url, function(err, db) {
    if (err) throw err;
      var dbo = db.db("georref");
    dbo.collection("cdmx").find({'nomgeo': { $eq: 'Iztapalapa' } }).toArray(function(err, result) {
    if (err) throw err;
      console.log(result);
    db.close();
    res.json(result);
    });
  });

})
  

app.get('/iztc', function(req, res) {

  mongo.connect(url, function(err, db) {
    if (err) throw err;
      var dbo = db.db("georref");
    dbo.collection("semaforos").find({'alcaldia': { $eq: "Iztacalco" }}).toArray(function(err, result) {
    if (err) throw err;
      console.log(result);
    db.close();
    res.json(result);
    });
  });	
})

app.get('/iztaca', function(req, res) {
  mongo.connect(url, function(err, db) {
    if (err) throw err;
      var dbo = db.db("georref");
    dbo.collection("cdmx").find({'nomgeo': { $eq: 'Iztacalco' } }).toArray(function(err, result) {
    if (err) throw err;
      console.log(result);
    db.close();
    res.json(result);
    });
  });

})


app.get('/mihi', function(req, res) {

  mongo.connect(url, function(err, db) {
    if (err) throw err;
      var dbo = db.db("georref");
    dbo.collection("semaforos").find({'alcaldia': { $eq: "Miguel Hidalgo" }}).toArray(function(err, result) {
    if (err) throw err;
      console.log(result);
    db.close();
    res.json(result);
    });
  });
})


app.get('/mihig', function(req, res) {
  mongo.connect(url, function(err, db) {
    if (err) throw err;
      var dbo = db.db("georref");
    dbo.collection("cdmx").find({'nomgeo': { $eq: 'Miguel Hidalgo' } }).toArray(function(err, result) {
    if (err) throw err;
      console.log(result);
    db.close();
    res.json(result);
    });
  });

})

app.get('/xoch', function(req, res) {

  mongo.connect(url, function(err, db) {
    if (err) throw err;
      var dbo = db.db("georref");
    dbo.collection("cdmx").find({'nomgeo': { $eq: 'Xochimilco' } }).toArray(function(err, result) {
    if (err) throw err;
      console.log(result);
    db.close();
    res.json(result);
    });
  });
})


app.listen(3000, () => {
   'use strict';

});






