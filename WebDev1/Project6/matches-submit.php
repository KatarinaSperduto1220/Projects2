<?php
  $names = $_GET["name"];
  $info = file("singles_advanced.txt");
  foreach ($info as $person) {
    list($name, $gender, $age, $personality, $os, $minage, $maxage, $interest) = explode(",", $person);
    if ($names == $name){
      break;
  }
}

?>

    <?php include("top.html"); ?>

    <div>
      <p><strong> Matches for <?=$names?> </strong></p>
      <?php
        foreach ($info as $person) {
          list($m_name, $m_gender, $m_age, $m_personality, $m_os, $m_minage, $m_maxage, $m_interest) = explode(",", $person);
        if ($m_name == $name){
          continue;
        }
        $g_interest = similar_text($m_gender,$interest);
        if ($g_interest == 0){
          continue;
        }
        $g_interest = similar_text($gender,$m_interest);
        if ($g_interest == 0){
          continue;
        }
        if ($m_os != $os){
          continue;
        }
        if ($m_minage < $minage){
          continue;
        }
        if ($m_maxage > $maxage){
          continue;
        }
        $type = similar_text($personality,$m_personality);
        if ($type < 2){
          continue;
        }
        $pic_name = str_replace(" ", "_",$m_name);
        $picture = strtolower($pic_name);

        if (!(file_exists("images/$picture.jpg"))){
          $picture = "user.jpg";
        }
        else{
          $picture = "images/$picture.jpg";
        }

        ?>

        <div class = "match">

        <p><img src = <?=$picture?> alt = "person" />
          <?=$m_name?></p>
          <ul>
            <li><strong>gender:</strong><?=$m_gender?></li>
            <li><strong>age:</strong><?=$m_age?></li>
            <li><strong>type:</strong><?=$m_personality?></li>
            <li><strong>OS:</strong><?=$m_os?></li>
          </ul>
        </div>
        <?php }; ?>

    </div>

    <?php include("bottom.html"); ?>
