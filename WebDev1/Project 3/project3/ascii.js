"use strict";
var timerObj;
var frame;
var animations;
var string;
var turbo=250;
window.onload=function(){
  var button1 = document.getElementById("start");
  button1.onclick = start;
  var button2 = document.getElementById("stop");
  button2.onclick = stop;
  var drop1 = document.getElementById("animations");
  drop1.onchange = droplist1
  var drop2 = document.getElementById("size");
  drop2.onchange = droplist2
  var check = document.getElementById('turbo');
  check.onclick = checkmark
}
function start(){
  timerObj = setInterval(timer,turbo);
  frame = 0;
  string = document.getElementById('displayarea').value;
  animations = string.split('=====\n');
  document.getElementById('displayarea').value = animations[frame];
  var button1 = document.getElementById("start");
  button1.disabled = true;
  var button2 = document.getElementById("stop");
  button2.disable = false;
}
function stop(){
  clearInterval(timerObj);
  document.getElementById('displayarea').value = string;
  var button1 = document.getElementById("start");
  button1.disabled = false;
  var button2 = document.getElementById("stop");
  button2.disable = true;
}
function droplist1 (){
  var drop1 = document.getElementById("animations");
  var box = document.getElementById("displayarea");
  box.value = ANIMATIONS[drop1.value];
  var button1 = document.getElementById("start");
  button1.disabled = false;
  var button2 = document.getElementById("stop");
  button2.disable = true;
  var drop1 = document.getElementById("animations");
  drop1.disabled = false;
  
}
function droplist2() {
  var drop2 = document.getElementById("size");
  var box = document.getElementById("displayarea");
  box.style.fontSize = drop2.value;
}
function checkmark (){
  if (turbo == 50){
    turbo = 250;
  }
  else {
    turbo = 50;
  }
  clearInterval(timerObj);
  timerObj = setInterval(timer,turbo);

}
function animations (){
  var box = document.getElementById("displayarea");
  var x = document.getElementById("displayarea").value;
  var y = document.getElementById("displayarea");
}

function timer (){
  var box = document.getElementById("displayarea");
  frame = frame+1;
  if (frame == animations.length) {
    frame=0;
  }
    box.value = animations[frame];
}
