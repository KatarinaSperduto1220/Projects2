<?php
  $names = $_GET["name"];
  $genders = $_GET["gen"];
  $ages = $_GET["age"];
  $pts = $_GET["personality"];
  $os = $_GET["favoriteos"];
  $min = $_GET["seek"];
  $max = $_GET["seek2"];
  $interests = "";

  if ($genders == "female"){
      $genders = "F";
    }
  if ($genders == "male"){
    $genders = "M";
    }

  if (isset($_GET["m_gen2"])){
      $m_interests = "M";
      $new_user = implode(",",array($names,$genders,$ages,$pts,$os,$min,$max,$m_interests."\n"));

  }
  if (isset($_GET["f_gen2"])){
      $f_interests = "F";
      $new_user = implode(",",array($names,$genders,$ages,$pts,$os,$min,$max,$f_interests."\n"));
  }
  if (isset($_GET["m_gen2"]) && isset($_GET["f_gen2"])) {
      $interests = "MF";
      $new_user = implode(",",array($names,$genders,$ages,$pts,$os,$min,$max,$interests."\n"));
}
  $file = "singles_advanced.txt";
  $add = file_put_contents($file,$new_user,FILE_APPEND);
?>

<?php include("top.html"); ?>

<p><strong>Thank You</strong></p>
<p> Welcome to Nerd Luv <?=$names?></p>

<?php include("bottom.html"); ?>
