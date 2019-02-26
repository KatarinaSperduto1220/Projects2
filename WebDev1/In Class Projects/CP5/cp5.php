<?php
  $data = $_GET["data"];
  $info = file("datafixed.csv");
 ?>

 <!DOCTYPE html>
 <html>
 	<head>
 		<title><?= $title ?>Look-up</title>
 		<meta charset="utf-8" />
 	</head>

  <body>
    <div>

    <?php

    foreach ($info as $person) {
      list($first_name,$last_name,$address,$city,$county,$state,$zip,$phone1,$phone2,$email,$web) = explode(",", $person);
    if ($state == $data){
        ?>
      <h2><?=$first_name." ",$last_name?></h2>
      <p><?=$phone1?></p>
      <a href = "mailto:"<?=$email?>"" ><?=$email?></a></br>
      <a href = "<?=$web?>"><?=$web?></a>
    <?php }}; ?>
  </div>
  </body>
</html>
