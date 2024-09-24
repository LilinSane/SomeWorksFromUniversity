<?php
session_start();
$start_time = new DateTime('now');

function saveSessionData($xcoord, $ycoord, $rnum, $isHit, $interval, $time){
	$_SESSION['x'][] = $xcoord;
	$_SESSION['y'][] = $ycoord;
	$_SESSION['r'][] = $rnum;
	$_SESSION['isHit'][] = $isHit;
	$_SESSION['interval'][] = $interval;
	$_SESSION['time'][] = $time;
}

	function isRadioValid($inputData){
      	    if($inputData >= -3 && $inputData <= 3 && is_int($inputData)){
	return true;
      	    }
      	    else{
	return false;
      	    }
      	}
        
    function isTextValid($inputData){
           if($inputData >= -5 && $inputData <= 4 && is_int($inputData)){
	return true;
           }
           else{
	return false;
           }
    }
        
    function isSelectValid($inputData){
           if($inputData >= 1 && $inputData <= 3 && is_numeric($inputData)){
	return true;
           }
           else{
	return false;
           }
    }
   
    function handle($xcoord, $ycoord, $rnum){
    	if ($xcoord <= 0 && $ycoord >= 0){
    	    if ($xcoord <= $rnum && $ycoord <= ($rnum/2)){
    	        return 1;
    	    }
    	}elseif ($xcoord >= 0 && $ycoord >= 0) {
    	    if ($ycoord <= (-1)*$xcoord + ($rnum/2)){
    	        return 1;
    	    }
    	}elseif ($xcoord >= 0 && $ycoord <= 0) {
    	    if (pow($xcoord, 2) + pow($ycoord, 2) <= pow($rnum, 2)){
    	        return 1;
    	    }
    	} 
    	return 0;
    }

$xcoord = (int) $_GET['xcoord'];    
$ycoord = (int) $_GET['ycoord'];
$rnum = (float) $_GET['rnum'];
 


if(isRadioValid($xcoord) && isTextValid($ycoord) && isSelectValid($rnum)){
	$end_time = new DateTime('now');
	$interval = $start_time->diff($end_time);
	$isHit = handle($xcoord, $ycoord, $rnum);
	$data[] = array($isHit, $interval->format('%f'), date_format($end_time,"H:i:s"));
	$json = json_encode($data);
	header('Content-type: application/json');
	echo $json;
	saveSessionData($xcoord, $ycoord, $rnum, $isHit, $interval->format('%f'), date_format($end_time,"H:i:s"));
}
 else {
 	$end_time = new DateTime('now');
	$interval = $start_time->diff($end_time);
	$data[] = array(2, $interval->format('%f'));
	$json = json_encode($data);
	header('Content-type: application/json');
   	echo $json;
}

?>

