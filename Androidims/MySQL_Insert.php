<?php

    $name = $_POST['name'];
    $email = $_POST['email'];
    $phone = $_POST['phone'];

    $conn = mysqli_connect('localhost','root','root','Android1st');
    $query = 'insert into userinfo values("","'.$name.'","'.$email.'","'.$phone.'")';
    $result = mysqli_query($conn,$query);

    if($result){
      echo"ok";
    }else{
      echo"NG";
    }

?>
