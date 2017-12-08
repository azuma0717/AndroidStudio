<?php

    $name = $_POST['name'];
    $pass = $_POST['pass'];

    // $name = "yuki";
    // $pass = "1";

    $conn = mysqli_connect('localhost','root','root','Android1st');
    $query = 'select * from userinfo4 where name ="'.$name.'" and pass = "'.$pass.'"';
    $result = mysqli_query($conn,$query);

    $response = array();
    if(mysqli_num_rows($result) > 0){
        echo "login completed.";

    }else{
        echo "login failed.";
    }


?>
