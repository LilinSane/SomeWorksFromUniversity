import React from 'react';
import { Routes, Route } from 'react-router-dom';

import './App.css';
import Header from './Header/Header';
import ClonesPage from '../pages/clones/ClonesPage'
import DirectionPage from '../pages/direction/DirectionPage'
import JediesPage from '../pages/jedies/JediesPage'
import VehiclesPage from '../pages/vehicles/VehiclesPage'

function App() {
  return (
      <div>
        <Routes>
          <Route path="/" element={ <Header />}>
            <Route index  element={ <></> }/>
            <Route path="clones" element={<ClonesPage />} />
            <Route path="direction" element={<DirectionPage />} />
            <Route path="jedies" element={<JediesPage />} />
            <Route path="vehicles" element={<VehiclesPage />} />
          </Route>
        </Routes>
      </div>
  );
}

export default App;
