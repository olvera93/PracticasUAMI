
$(document).ready(function(){

  var alcaldias =['iztapalapa','iztacalco','miguel-hidalgo','xochimilco', 'metro'];
  var centro_alcaldias =[{latitud:19.360490,longitud:-99.093359},{latitud:19.395728,longitud:-99.095369},{latitud:19.407475,longitud:-99.192375},{latitud:19.263226,longitud:-99.106257}, {latitud:19.429156, longitud:-99.132966}];
 
  var mapas = new Array();
  var color =['orange','red','green','yellow', 'blue'];
  var iconos=new Array();
 
  function crearIcono(img,imgs,a,b,c,d,e){
    return new L.Icon({
       
      iconUrl: 'assets/'+img,
      shadowUrl: 'assets/'+imgs,
      iconSize: [a, b],
      iconAnchor: [c, b],
      popupAnchor: [d, e],
      shadowSize: [b, b]
    });
     
  }
  for(i=0;i<color.length;i++){
     iconos.push(crearIcono('marker-icon-2x-'+color[i]+'.png','marker-shadow.png',25,41,12,1,-34));
  }


  for(i=0;i<alcaldias.length;i++){
   var mapa = L.map('map'+alcaldias[i]).setView([centro_alcaldias[i].latitud,centro_alcaldias[i].longitud], 13);
   
   L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
      maxZoom: 18,
      attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
         '<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
         'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
      id: 'mapbox/streets-v11'
   }).addTo(mapa);
   mapas.push(mapa);
  }


  $.get("/metro", function(data, status){
   for(i=0;i<data[0].features.length;i++){
      longitud=data[0].features[i].properties.geometry.coordinates[0]
      latitud=data[0].features[i].properties.geometry.coordinates[1];
      L.marker([latitud,longitud],{icon: iconos[2]}).addTo(mapas[4]); 
   }  
});

$.get("/ciudad", function(data, status){
    
   lineas=new Array();
   limite=data[0].geo_shape.coordinates[0].length;
   console.log(limite);
   for(j=0;j<limite;j++){
      longitud=data[0].geo_shape.coordinates[0][j][0];
      latitud=data[0].geo_shape.coordinates[0][j][1];
      lineas.push([latitud,longitud]);
   }
   L.polygon(lineas).addTo(mapas[4]);
  
 }); 

  

 $.get("/izta", function(data, status){
    var marker;
    for(i=0;i<data.length;i++){
       L.marker([data[i].latitud, data[i].longitud],{icon: iconos[0]}).addTo(mapas[0]);                   
    }   
 });

// Dibujar en el mapa el poligono de la zona de la alcaldia de Iztapalapa
 $.get("/iztapa", function(data, status){
   lineas2=new Array();
  limite=data[0].geo_shape.coordinates[0].length;
  console.log(limite);
  for(j=0;j<limite;j++){
     longitud=data[0].geo_shape.coordinates[0][j][0];
     latitud=data[0].geo_shape.coordinates[0][j][1];
     lineas2.push([latitud,longitud]);
  }
  L.polygon(lineas2).addTo(mapas[0]);

});

 $.get("/iztc", function(data, status){
    var marker;
    for(i=0;i<data.length;i++){
       L.marker([data[i].latitud, data[i].longitud],{icon: iconos[1]}).addTo(mapas[1]);                   
    }   
 });

// Dibujar en el mapa el poligono de la zona de la alcaldia de Iztapalapa
$.get("/iztaca", function(data, status){
   lineas2=new Array();
  limite=data[0].geo_shape.coordinates[0].length;
  console.log(limite);
  for(j=0;j<limite;j++){
     longitud=data[0].geo_shape.coordinates[0][j][0];
     latitud=data[0].geo_shape.coordinates[0][j][1];
     lineas2.push([latitud,longitud]);
  }
  L.polygon(lineas2).addTo(mapas[1]);

});

 $.get("/mihi", function(data, status){
    var marker;
    for(i=0;i<data.length;i++){
       L.marker([data[i].latitud, data[i].longitud],{icon: iconos[2]}).addTo(mapas[2]);                   
    }   
 }); 

 // Dibujar en el mapa el poligono de la zona de la alcaldia de Iztapalapa
$.get("/mihig", function(data, status){
   lineas2=new Array();
  limite=data[0].geo_shape.coordinates[0].length;
  console.log(limite);
  for(j=0;j<limite;j++){
     longitud=data[0].geo_shape.coordinates[0][j][0];
     latitud=data[0].geo_shape.coordinates[0][j][1];
     lineas2.push([latitud,longitud]);
  }
  L.polygon(lineas2).addTo(mapas[2]);

});

 
 $.get("/xoch", function(data, status){
    

   lineas=new Array();
   limite=data[0].geo_shape.coordinates[0].length;
   console.log(limite);
   for(j=0;j<limite;j++){
      longitud=data[0].geo_shape.coordinates[0][j][0];
      latitud=data[0].geo_shape.coordinates[0][j][1];
      lineas.push([latitud,longitud]);
   }
   L.polygon(lineas).addTo(mapas[3]);
  
 }); 
 

});
