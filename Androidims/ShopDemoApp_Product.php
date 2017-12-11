<?php

      header('Content-type : bitmap; charset = utf-8');

      $cid = $_POST['cid'];
      $name = $_POST['name'];
      $price = $_POST['price'];
      $img = $_POST['img'];

      $decoded_img = base64_decode($img);
      $path ="images/".$name;
      $file = fopen($path,"wb");
      $is_written = fwrite($file,$decoded_img);
      fclose($file);


      $conn = mysqli_connect('localhost','root','root','ShopDemoApp');
      $query = 'insert into products values("","'.$cid.'","'.$name.'","'.$price.'","'.$path.'")';
      $result = mysqli_query($conn,$query);




?>
