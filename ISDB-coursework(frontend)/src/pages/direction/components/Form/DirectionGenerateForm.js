import React, {useState } from 'react';
import axios from 'axios';


import './DirectionForm.css';

const src = "http://localhost:8000/direction-generate";

function GenerateForm({onChange}) {

  const [data, setData] = useState({ count: "" }, []);
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
        <input placeholder='Количество клонов' name='count' value={data.count} onChange={handleChange}></input>
        <button type='button' onClick={() => handleOnClick()}>Создать</button>
     </form>
  );
}

export default GenerateForm;
