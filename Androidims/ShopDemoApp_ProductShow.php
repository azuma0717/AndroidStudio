<?php

    $pid = $_POST["pid"];
    // $pid = 1;
    $conn = mysqli_connect('localhost','root','root','ShopDemoApp');
    $query = 'select * from products where cid = "'.$pid.'"';
    $result = mysqli_query($conn,$query);

    $response = array();
    if(mysqli_num_rows($result) > 0){

      while ($row = mysqli_fetch_assoc($result)) {
        array_push($response,$row);
      }

    }
    else{

        echo "Not find. Try again";
    }

    echo json_encode(array("data"=>$response));

?>
