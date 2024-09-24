import React, {useState} from 'react';

import Table from './components/Table/JediesTable';
import GetForm from './components/Form/JediesGetForm';
import CreateForm from './components/Form/JediesCreateForm';
import DeleteForm from './components/Form/JediesDeleteForm';
import UpdateForm from './components/Form/JediesUpdateForm';

function ClonesPage() {

  const [value, setValue] = useState([]);

  const handleChange = (value) => {
    setValue(value);
  }



  return (
    <>
    <div>
      <main><Table value={value}/></main>
      <aside><GetForm onChange={handleChange}/></aside>
      <main className='container'>
        <CreateForm />
        <DeleteForm />
        <UpdateForm />
      </main>
    </div>
    
    </>
  );
}

export default ClonesPage;
