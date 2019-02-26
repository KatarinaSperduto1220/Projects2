var emptyrow = 3;
var emptycol = 3;
var row = 0
var col = 0
var right = 0
var top = 0

$(document).ready(function(){

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


  $(".puzzlepiece").hover(function(){
    $(this).addClass("Mpiece");
    console.log($(this).attr("id"));
  });

});

function legal (piece){
  // Turn piece into id number
  var piece2 = int($(this).attr('id'));
  // Get row and column from id number
  var piece2row = Math.floor(index/4);
  var piece2col = (index%4);
//determine if piece is legal
  if (Math.abs(emptycol - "piece2col") + Math.abs(emptyrow - "piece2row") == 1) {
    return true
    ;}
  else
    return false
// Whenever a <td> element is clicked, call this function.
} $('piece2').mousedown(function() {

  // switch blank with clicked square
  if (Math.abs(emptycol - 1) + Math.abs(emptyrow - 1) == 1){

  else
    return false;
});

function shufflePuzzle(){
  var piecesArray = [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15];
  for (var i=puzzle.length; i>0; i){
      var j = Math.floor(Math.random() * i);
      var x = piecesArray[--i];
      var test = piecesArray[j];
   }
 }
 $("#shufflebutton").click(function(shufflePuzzle){
    });
function movepiece(){

}
