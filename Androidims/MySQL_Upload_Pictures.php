<?php
  header('Content-type : bitmap; charset = utf-8');

  $img_name = $_POST['img_name'];
  $encoded_string = $_POST["img_path"];
  $decoded_string = base64_decode($encoded_string);
  $path ="images/".$img_name;
  $file = fopen($path,"wb");
  $is_written = fwrite($file,$decoded_string);
  fclose($file);

  $conn = mysqli_connect('localhost','root','root','Android1st');
  $query = 'insert into upload_pictures values("","'.$img_name.'","'.$path.'")';
  $result = mysqli_query($conn,$query);


?>
