<?php
	$movie = $_GET["film"];
#getting informtaion from info.txt
	$info = file("moviefiles/".$movie."/info.txt");
	$title = $info[0];
	$year = $info[1];
	$percent = $info[2];

?>
<!DOCTYPE html>
<html>
	<head>
		<title><?= $title ?> - Rancid Tomatoes</title>
		<meta charset="utf-8" />
		<link href="movie.css" type="text/css" rel="stylesheet" />
		<link href="rotten.gif" type="image/gif" rel="shortcut icon" />
	</head>

	<body>
		<div id="topbanner">
			<img src="banner.png" alt="Rancid Tomatoes" />
		</div>

		<h1>
			<?= $title ?>
			<?= $year ?>
		</h1>

		<div id="overall">
			<div id="generaloverview">
				<img src="moviefiles/<?=$movie?>/overview.png" alt="general overview" />

				<dl>
		      <?php
						$overviews = file("moviefiles/".$movie."/overview.txt");

						foreach ($overviews as $over){
							$overview = explode(":", $over);
							$title = $overview[0];
							$info = $overview[1];
							?>
							<dt><?=$title?></dt>
							<dd><?=$info?></dd>
						<?php }; ?>
		    </dl>
			</div>

			<div id="reviews">
				<div id="rottenpane">
					<?php
					if ($percent > 50){
					?>
					<img class="icon" src="freshbig.png" alt="big rating" />
					<?php }; ?>
					<?php
					if ($percent < 50){
						?>
					<img class="icon" src="rottenbig.png" alt="big rating" />
					<?php }; ?>
					<span class="rating"><?= trim($percent) ?>%</span>

				</div>
				<div class="column">
					<?php
				 $review = glob("moviefiles/".$movie."/review*.txt");
				 for ($i=0; $i<count($review)/2;$i++){

					 $reviews = $review[$i];
					 $content = file($reviews);
					 $rev = $content[0];
					 $rate = trim($content[1]);
					 $name = $content [2];
					 $pub = $content [3];
					 ?>
					<div class="review">
						<p class="quotebubble">

							<?php
							if ($rate == "FRESH"){
							?>
							<img class="icon" src="fresh.gif" alt="Rotten" />
							<?php }; ?>
							<?php
							if ($rate == "ROTTEN"){
							?>
							<img class="icon" src="rotten.gif" alt="Rotten" />
							<?php }; ?>
							<q><?= $rev ?></q>
						</p>

						<p>
							<img class="icon" src="critic.gif" alt="Critic" />
							<?= $name ?><br />
							<span class="publication"><?= $pub ?></span>
						</p>

					</div>
					<?php }; ?>
				</div>

				<div class="column">
					<?php
				 $review = glob("moviefiles/".$movie."/review*.txt");
				 for ($i<count($review)/2; $i<count($review);$i++){

					 $reviews = $review[$i];
					 $content = file($reviews);
					 $rev = $content[0];
					 $rate = trim($content[1]);
					 $name = $content [2];
					 $pub = $content [3];
					 ?>
					<div class="review">
						<p class="quotebubble">

							<?php
							if ($rate == "FRESH"){
							?>
							<img class="icon" src="fresh.gif" alt="Rotten" />
							<?php }; ?>
							<?php
							if ($rate == "ROTTEN"){
							?>
							<img class="icon" src="rotten.gif" alt="Rotten" />
							<?php }; ?>
							<q><?= $rev ?></q>
						</p>

						<p>
							<img class="icon" src="critic.gif" alt="Critic" />
							<?= $name ?><br />
							<span class="publication"><?= $pub ?></span>
						</p>

					</div>
					<?php }; ?>
				</div>
			</div>
		<p id="footer">
		(1-<?= count($review)?>) of <?=count($review)?></p>
	</div>

		<div id="w3c">
			<a href="https://webster.cs.washington.edu/validate-html.php"><img src="http://webster.cs.washington.edu/w3c-html.png" alt="Valid HTML5" /></a> <br />
			<a href="https://webster.cs.washington.edu/validate-css.php"><img src="http://webster.cs.washington.edu/w3c-css.png" alt="Valid CSS" /></a>
		</div>

	</body>
</html>
