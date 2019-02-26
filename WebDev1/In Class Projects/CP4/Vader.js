function background(){
  var random1 = Math.floor(Math.random()*255);
  var random2 = Math.floor(Math.random()*255);
  var random3 = Math.floor(Math.random()*255);
    $("body").css("background-color","rgb("+random1+","+random2+","+random3+")");
};

$(document).ready(function(){
   $("li").css("background-color","black");
   $("li").css("color","red");

   $("#quote").click(background);
 });
