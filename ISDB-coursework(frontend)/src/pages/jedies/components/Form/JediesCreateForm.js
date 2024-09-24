import React, {useState } from 'react';
import axios from 'axios';


import './JediesForm.css';

const src = "http://localhost:8000/jedi-add";


function CreateForm() {

  const [data, setData] = useState({ name: "", surname: "", batallion: "", rank: "", is_general: false }, []);
  const [response, setResponse] = useState("");

  const handleChange = (event) => {
   const { name, value, type, checked } = event.target;
   setData((prevData) => ({
     ...prevData,
     [name]: type === 'checkbox' ? checked : value
   }));
 };

  const handleOnClick = (event) => {
    console.log(data)
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
          <input placeholder='Имя' name='name' value={data.name} onChange={handleChange}></input>
          <input placeholder='Фамилия' name='surname' value={data.surname} onChange={handleChange}></input>
          <input placeholder='Батальон' name='batallion' value={data.batallion} onChange={handleChange}></input>
          <input placeholder='Звание' name='rank' value={data.rank} onChange={handleChange}></input>
          <label htmlFor='isGeneral'>Генерал?</label>
          <input type='checkbox' id='isGeneral' name='is_general' value={data.is_general} onChange={handleChange}></input>
          <button type='button' onClick={() => handleOnClick()}>Добавить</button>
    </form>
    </>
    
  );
}

export default CreateForm;
