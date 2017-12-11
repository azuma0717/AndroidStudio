<?php

      $cname = $_POST['cname'];
      $conn = mysqli_connect('localhost','root','root','ShopDemoApp');
      $query = 'insert into category values("","'.$cname.'")';
      $result = mysqli_query($conn,$query);

?>
