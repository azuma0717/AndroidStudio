<?php

  //  $a = $_POST['id'];
      // $a = 1;


    $conn = mysqli_connect('localhost','root','root','Android1st');
    $query = 'SELECT * FROM userinfo3 WHERE id = (SELECT MAX(id) FROM userinfo3);';
    $result = mysqli_query($conn,$query);

    if(mysqli_num_rows($result) > 0){

      $row = mysqli_fetch_assoc($result);
      $id = $row[id];

      echo $id;

    }
    else{

        echo "Not find. Try again";


    }

?>
