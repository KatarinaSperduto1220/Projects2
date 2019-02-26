var frame = 0;
var string;
var quotes = [];
  quotes[0] = "Impressive, most Impressive.";
  quotes[1] = "Apology accepted, Captain Needa.";
  quotes[2] = "There is no escape. Don't make me destroy you.";
  quotes[3] = "Nooooooooooooooooooooooooooooooooooooooooooo!";
  quotes[4] = "You have failed me for the last time Admiral."
  quotes[5] = "The force is strong with this one."
var images = [];
    images[0] = "vader.jpg";
    images[1] = "DV-crossarms.jpg";
    images[2] = "DV.jpg";
    images[3] = "episode3DV.jpg";

window.onload=function(){
  var time = setInterval(timer, 3000);
  var button1 = document.getElementById("quote");
  button1.onclick = quote;
}
function quote(){
  var num = Math.floor(Math.random()*quotes.length);
  quote = quotes[num];
  string = document.getElementById('quotetext');
  string.innerHTML = quote;
}


function timer (){
  var images2 = document.getElementById("DV");
  if (frame != images.length) {
    images2.src = images[frame];
    frame++;
  }
  else {
    frame = 0;

  }
  }
