//use strict
//variables
var emptyrow = 3;
var emptycol = 3;
var row = 0
var col = 0
var left = 0
var top = 0
var temprow = 0
var tempcol = 0


//function for shufflebutton
function Shuffle (){
  var random = Math.floor(Math.random()*100 +1);
  for (var i = 0; i < random; i++){
    $(".puzzlepiece").each(movable);
  }
 };

//function for hover and highlight
function tile (){
  var id = $(this).attr("id");
  var id = parseInt(id.substring(5));
  var idrow = Math.floor(id/4);
  var idcol = (id%4);
  if((idrow == emptyrow-1 && idcol == emptycol) || (idrow == emptyrow && idcol == emptycol-1) || (idrow == emptyrow && idcol == emptycol+1) || (idrow == emptyrow+1 && idcol == emptycol)){
    $(this).addClass("Mpiece");
  }
  else {
    $(this).removeClass("Mpiece");
 }
}

//function for movable pieces
function movable (){
  var id = $(this).attr("id");
  var id = parseInt(id.substring(5));
  var idrow = Math.floor(id/4);
  var idcol = (id%4);
  tempcol = idcol;
  temprow = idrow;

  if((temprow == emptyrow-1 && tempcol == emptycol) || (temprow == emptyrow && tempcol == emptycol-1) || (temprow == emptyrow && tempcol == emptycol+1) || (temprow == emptyrow+1 && tempcol == emptycol)){
  $(this).css("left", (emptycol*100)+"px");
  $(this).css("top", (emptyrow*100)+"px");

  var newid = "piece" + (emptyrow * 4 + emptycol);
  $(this).attr('id', newid);

   emptyrow = temprow;
   emptycol= tempcol;
 }
}

$(document).ready(function(){

//aligning the picture with the correct divs
  $("#puzzlearea div").each(function(index){
    var row = Math.floor(index/4);
    var col = (index%4);
    var left = col*100;
    var top = row*100;

    $(this).addClass("puzzlepiece");
    var id = "piece" + index;
    $(this).attr('id', id);

    $(this).css({
      "left":left + "px",
      "top":top + "px",
      "background-position": (-1*left) + "px " + (-1*top) + "px"
    });
  });

// calling the hover and/or highlight function
  $(".puzzlepiece").hover(tile);

// calling the shuffle function
  $("#shufflebutton").click(Shuffle);

//calling the movable function
  $(".puzzlepiece").click(movable);

});
