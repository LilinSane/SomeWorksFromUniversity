import React, {useState } from 'react';
import axios from 'axios';



import './ClonesForm.css';

//const src = "https://jsonplaceholder.typicode.com/users";
const src = "http://localhost:8000/clones-get";

function GetForm({onChange}) {

  /*
     const data1 = [
      {
        id: 1,
        prefix: "CT-7567",
        name: "Rex",
        batallion: 101,
        rank: 201,
        equipment: 301
      },
      {
        id: 2,
        prefix: "CT-5555",
        name: "Fives",
        batallion: 101,
        rank: 202,
        equipment: 302
      },
      {
        id: 3,
        prefix: "CT-327",
        name: "Bly",
        batallion: 102,
        rank: 203,
        equipment: 303
      },
      {
        id: 4,
        prefix: "CT-7567",
        name: "Rex",
        batallion: 101,
        rank: 201,
        equipment: 301
      },
      {
        id: 5,
        prefix: "CT-5555",
        name: "Fives",
        batallion: 101,
        rank: 202,
        equipment: 302
      },
      {
        id: 6,
        prefix: "CT-327",
        name: "Bly",
        batallion: 102,
        rank: 203,
        equipment: 303
      },
      {
        id: 7,
        prefix: "CT-7567",
        name: "Rex",
        batallion: 101,
        rank: 201,
        equipment: 301
      },
      {
        id: 8,
        prefix: "CT-5555",
        name: "Fives",
        batallion: 101,
        rank: 202,
        equipment: 302
      },
      {
        id: 9,
        prefix: "CT-327",
        name: "Bly",
        batallion: 102,
        rank: 203,
        equipment: 303
      },
      {
        id: 10,
        prefix: "CT-7567",
        name: "Rex",
        batallion: 101,
        rank: 201,
        equipment: 301
      },
      {
        id: 11,
        prefix: "CT-5555",
        name: "Fives",
        batallion: 101,
        rank: 202,
        equipment: 302
      },
      {
        id: 12,
        prefix: "CT-327",
        name: "Bly",
        batallion: 102,
        rank: 203,
        equipment: 303
      },
      {
        id: 13,
        prefix: "CT-327",
        name: "Bly",
        batallion: 102,
        rank: 203,
        equipment: 303
      },
      {
        id: 14,
        prefix: "CT-327",
        name: "Bly",
        batallion: 102,
        rank: 203,
        equipment: 303
      },
      {
        id: 15,
        prefix: "CT-327",
        name: "Bly",
        batallion: 102,
        rank: 203,
        equipment: 303
      }
];
*/

  const [data, setData] = useState({ count: "", name: "", batallion: "" }, []);
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
   //onChange(data1);
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
        <input placeholder='Имя' name='name' value={data.name} onChange={handleChange}></input>
        <input placeholder='Батальон' name='batallion' value={data.batallion} onChange={handleChange}></input>
        <button type='button' onClick={() => handleOnClick()}>Отправить</button>
     </form>
  );
}

export default GetForm;


// const handleOnClick = (event) => {
//       console.log(data);
//       axios
//          .get(src)
//          .then((response) => {
//            //setResponse(response.data);
//            console.log(response);
//            console.log(response.data);
//          })
//          .catch((error) => {
//            console.log(error);
//          });
//      }
