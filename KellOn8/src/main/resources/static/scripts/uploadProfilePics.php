<?php
$host = ${DB_URL};
$user = ${DB_USER};
$pass = ${DB_PASSWORD};

mysql_connect($host, $user, $pass);

mysql_select_db('kellon8');

$upload_image=$_FILES[" myimage "][ "name" ];

$folder="../uploadedProfilePics";

move_uploaded_file($_FILES[" myimage "][" tmp_name "], "../uploadedProfilePics".$_FILES[" myimage "][" name "]);

$insert_path="INSERT INTO image_table VALUES('$folder','$upload_image')";

$var=mysql_query($insert_path);
?>