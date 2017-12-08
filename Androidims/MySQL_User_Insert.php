<?php

    $name = $_POST['name'];
    $email = $_POST['email'];
    $phone = $_POST['phone'];
    $city = $_POST['city'];
    $dob = $_POST['dob'];
    $photo = $_POST['photo'];


    $conn = mysqli_connect('localhost','root','root','Android1st');
    $query = 'insert into userinfo3 values("","'.$name.'","'.$email.'","'.$phone.'","'.$city.'","'.$dob.'","'.$photo.'")';
    $result = mysqli_query($conn,$query);

    if($result){
      echo"ok";
    }else{
      echo"NG";
    }

?>
