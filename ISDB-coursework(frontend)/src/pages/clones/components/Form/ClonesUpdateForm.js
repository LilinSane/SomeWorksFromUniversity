import React, {useState} from 'react';
import axios from 'axios';


import './ClonesForm.css';

const src = "http://localhost:8000/clones-upd";

function UpdateForm() {

  const [data, setData] = useState({ id: "", prefix: "", name: "", batallion: "", rank: "", equipment: "" }, []);
  const [response, setResponse] = useState("");

  const handleChange = (event) => {
   const { name, value } = event.target;
   setData((prevData) => ({
     ...prevData,
     [name]: value
   }));
 };

  const handleOnClick = (event) => {
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
          <input placeholder='Префикс' name='prefix' value={data.prefix} onChange={handleChange}></input>
          <input placeholder='Имя' name='name' value={data.name} onChange={handleChange}></input>
          <input placeholder='Батальон' name='batallion' value={data.batallion} onChange={handleChange}></input>
          <input placeholder='Звание' name='rank' value={data.rank} onChange={handleChange}></input>
          <input placeholder='Снаряжение' name='equipment' value={data.equipment} onChange={handleChange}></input>
          <button type='button' onClick={() => handleOnClick()}>Изменить</button>
    </form>
    </>

  );
}

export default UpdateForm;
