<?php

   $a = $_POST['id'];
      // $a = 1;


    $conn = mysqli_connect('localhost','root','root','Android1st');
    $query = 'select * from userinfo2 where id = "'.$a.'"';
    $result = mysqli_query($conn,$query);

    if(mysqli_num_rows($result) > 0){

      $row = mysqli_fetch_assoc($result);
      $name = $row[name];
      $phone = $row[phone];
      $email = $row[email];
      $city = $row[city];
      $dob = $row[dob];

      echo "Find Success ".$name.$phone.$email.$city.$dob;

    }
    else{

        echo "Not find. Try again";


    }

?>
