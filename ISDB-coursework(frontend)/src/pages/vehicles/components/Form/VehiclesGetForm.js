import React, {useState } from 'react';
import axios from 'axios';


import './VehiclesForm.css';

const src = "http://localhost:8000/vehicles-get";

function GetForm({onChange}) {

  const [data, setData] = useState({ count: "", battalion: "", vehicle: "" }, []);
  const [response, setResponse] = useState("");

  const handleChange = (event) => {
   const { name, value } = event.target;
   setData((prevData) => ({
     ...prevData,
     [name]: value
   }));
 };

	let buf = [];

  const handleOnClick = (event) => {
   	axios
      .post(src, data, { headers: { 'Content-Type': 'application/x-www-form-urlencoded' } })
      .then((response) => {
        setResponse(response.data);
        buf = response.data;
        onChange(buf);
      })
      .catch((error) => {
        console.log(error);
      });
  }

  return (
     <form>
        <input placeholder='Количество записей' name='count' value={data.count} onChange={handleChange}></input>
        <input placeholder='Батальон' name='batallion' value={data.battalion} onChange={handleChange}></input>
        <input placeholder='Транспорт' name='vehicle' value={data.vehicle} onChange={handleChange}></input>
        <button type='button' onClick={() => handleOnClick()}>Отправить</button>
     </form>
  );
}

export default GetForm;
