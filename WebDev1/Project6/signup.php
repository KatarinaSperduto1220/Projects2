<?php include("top.html"); ?>

    <form action="signup-submit.php">
      <fieldset>
        <legend> New User Signup:</legend>
        <strong> Name:</strong><input type="text" name="name" size="16" />
      </br>
        <strong>Gender:</strong><input type="radio" name="gen" value="male" checked="checked"/> Male
        <input type="radio" name="gen" value="female"/> Female
      </br>
        <strong> Age:</strong><input type="text" name="age" size="6" maxlength="2" />
      </br>
        <strong> Personality Type:</strong><input type="text" name="personality" size="6" maxlength="4" />
        (<a href="http://www.humanmetrics.com/cgi-win/JTypes2.asp">Don't know your type?</a>)
      </br>
        <strong> Favorite OS:</strong><select name = "favoriteos">
          <option selected = "selected"> Windows </option>
          <option> Linux </option>
          <option> Mac OS X </option>
        </select>
      </br>
        <strong> Seeking Age:</strong><input type="text" name="seek" size="6" maxlength="2" placeholder="min"/>
        to
        <input type="text" name="seek2" size="6" maxlength="2"  placeholder= "max"/>
      </br>
      <strong>Seeking Gender</strong><input type="checkbox" name="m_gen2" value="male"/> Male
      <input type="checkbox" name="f_gen2" value="female"/> Female
    </br>
        <input type="submit" value="Sign Up" />
      </fieldset>
    </form>

<?php include("bottom.html"); ?>
