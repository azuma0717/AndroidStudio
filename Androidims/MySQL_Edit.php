<?php

  $id = $_POST['id'];
  $name = $_POST['name'];
  $email = $_POST['email'];
  $pass = $_POST['pass'];

  $conn = mysqli_connect('localhost','root','root','Android1st');
  $query = 'update userinfo4 set name = "'.$name.'", email = "'.$email.'",pass = "'.$pass.'" where id = "'.$id.'"';

  $result = mysqli_query($conn,$query);


?>
