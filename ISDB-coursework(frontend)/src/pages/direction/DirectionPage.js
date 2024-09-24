import React, {useState} from 'react';

import GetTable from './components/Table/DirectionGetTable';
import GetForm from './components/Form/DirectionGetForm';
import GenerateTable from './components/Table/DirectionGenerateTable';
import GenerateForm from './components/Form/DirectionGenerateForm';


function ClonesPage() {

  const [getValue, setGetValue] = useState([]);
  const [generateValue, setGenerateValue] = useState([]);

  const handleGetChange = (getValue) => {
    setGetValue(getValue);
  }

  const handleGenerateChange = (generateValue) => {
    setGenerateValue(generateValue);
  }





  return (
    <>
    <div>
      <main><GetTable value={getValue}/></main>
      <aside><GetForm onChange={handleGetChange}/></aside>
      <main className='container'></main>
      <main><GenerateTable value={generateValue}/></main>
      <aside><GenerateForm onChange={handleGenerateChange}/></aside>
    </div>
    
    </>
  );
}

export default ClonesPage;
