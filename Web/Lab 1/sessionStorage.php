<?php
	session_start();
	$cflag = (int) $_GET['cflag'];
	if (!$cflag) {
		$arr = array();
		if(isset($_SESSION['x'])){
			for ($i=0; $i < count($_SESSION['x']); $i++) { 
				$arr[$i]['x'] = $_SESSION['x'][$i];
				$arr[$i]['y'] = $_SESSION['y'][$i];
				$arr[$i]['r'] = $_SESSION['r'][$i];
				$arr[$i]['isHit'] = $_SESSION['isHit'][$i];
				$arr[$i]['interval'] = $_SESSION['interval'][$i];
				$arr[$i]['time'] = $_SESSION['time'][$i];
			}
		}
	echo json_encode($arr);
	}
	else{
		session_unset();
		if (!isset($_SESSION['x'])) {
			echo 'Очистка прошла успешно';
		}
		else{
			echo 'Данные не очищены';
		}
	}
	

?>
