<?php

  //  $a = $_POST['id'];
      $a = 5;


    $conn = mysqli_connect('localhost','root','root','Android1st');
    $query = 'SELECT * FROM userinfo3 WHERE id ="'.$a.'"';
    $result = mysqli_query($conn,$query);

    if(mysqli_num_rows($result) > 0){

      // $row = mysqli_fetch_assoc($result);
      // $name = $row[name];
      // $phone = $row[phone];
      // $email = $row[email];
      // $city = $row[city];
      // $dob = $row[dob];
      // $photo = $row[photo];

      $user= array();
        while ($row = mysqli_fetch_assoc($result)) {
          
          $name = $row[name];
          $phone = $row[phone];
          $email = $row[email];
          $city = $row[city];
          $dob = $row[dob];
          $photo = $row[photo];

          $user[] = array(
              'name'=> $name
              ,'phone' => $phone
              ,'email' => $email
              ,'city' => $city
              ,'dob' => $dob
              ,'photo' => $photo
            );
          }
        //jsonとして出力
        header('Content-type: application/json');
        echo json_encode($user);
    }
    else{

        echo "Not find. Try again";


    }

?>
