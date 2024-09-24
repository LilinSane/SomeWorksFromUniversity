import React, {useState} from 'react';

import Table from './components/Table/ClonesTable';
import GetForm from './components/Form/ClonesGetForm';
import CreateForm from './components/Form/ClonesCreateForm';
import DeleteForm from './components/Form/ClonesDeleteForm';
import UpdateForm from './components/Form/ClonesUpdateForm';

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
