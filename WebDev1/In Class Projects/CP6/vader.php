<?php
	$cookie_name = "visits2";
	$cookie_value = 1;
	$times = "times";

	if (isset($_COOKIE[$cookie_name])){
		$cookie_value = $_COOKIE[$cookie_name ]+1;
		$times = "times";
	}
	if (!isset($_COOKIE[$cookie_name])){
		$times = "time";
	}
	setcookie($cookie_name, $cookie_value);

 ?>
<!DOCTYPE html>
<html>
	<head>
    <meta charset="utf-8" />
		<title>An Ode to Vader</title>
		<link href="vader.css" type="text/css" rel="stylesheet" />
  </head>

	<body>
	<div class="content">
		<h1>Darth Vader</h1>

		<img src="vader.jpg" alt="Darth Vader" class="image" />

		<h2>Who Is He?</h2>

		<p>Darth Vader, also known by his birth name Anakin Skywalker, is a fictional character in the Star Wars franchise. Vader appears in the original film trilogy as a pivotal antagonist whose actions drive the plot, while his past as Anakin Skywalker and the story of his corruption are central to the narrative of the prequel trilogy.

		The character was created by George Lucas and has been portrayed by numerous actors. His appearances span the first six Star Wars films, as well as Rogue One, and his character is heavily referenced in Star Wars: The Force Awakens. He is also an important character in the Star Wars expanded universe of television series, video games, novels, literature and comic books. Originally a Jedi prophesied to bring balance to the Force, he falls to the dark side of the Force and serves the evil Galactic Empire at the right hand of his Sith master, Emperor Palpatine (also known as Darth Sidious). He is also the father of Luke Skywalker and Princess Leia Organa, secret husband of Padmé Amidala and grandfather of Kylo Ren.</p>

		<h2>Why He Is Awesome</h2>
		<ol type="A">
		  <li>Dark lord of the Sith</li>
		  <li>Red lightsaber</li>
		  <li>Doesn’t put up with failure</li>
		  <li>James Earl Jones</li>
		</ol>

		<h2>Vader Quotes</h2>

		<blockquote>
			<p id="quotetext">Impressive, most impressive.</p>
			<p>-- Darth Vader</p>
		</blockquote>

		<button id="quote">New Background</button>

		<p id="footer">This page has been visited <strong><?= $cookie_value ?></strong> <?= $times ?></p>
	</div>
</body>
</html>
