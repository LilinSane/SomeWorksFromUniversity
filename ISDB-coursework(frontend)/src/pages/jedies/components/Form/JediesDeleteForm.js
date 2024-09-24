import React, {useState } from 'react';
import axios from 'axios';


import './JediesForm.css';

const src = "http://localhost:8000/jedi-del";

function DeleteForm() {

  const [data, setData] = useState({id: ""}, []);
  const [response, setResponse] = useState("");

  const handleChange = (event) => {
   const { name, value } = event.target;
   setData((prevData) => ({
     ...prevData,
     [name]: value
   }));
 };

  const handleOnClick = (event) => {
    console.log(data);
   axios
      .post(src, data, { headers: { 'Content-Type': 'application/x-www-form-urlencoded' } })
      .then((response) => {
        setResponse(response.data);
        console.log(response.data)
      })
      .catch((error) => {
        console.log(error);
      });
  
  }

  return (
     <>
    <form>
        <input placeholder='Айди' name='id' value={data.id} onChange={handleChange}></input>
        <button type='button' onClick={() => handleOnClick()}>Удалить</button>
    </form>
    </>
    
  );
}

export default DeleteForm;
