import React from 'react';
import logo from '../../img/logo.png'

import './Header.css';
import { Link, Outlet } from 'react-router-dom';

function Header() {
  return (
      <>
      <header>
      <nav><img src={logo} />
        <ul>
          <li><Link to='/clones'>Клоны</Link></li>
          <li><Link to='/jedies'>Джедаи</Link></li>
          <li><Link to='/direction'>Руководство</Link></li>
          <li><Link to='/vehicles'>Транспорт</Link></li>
        </ul>
      </nav>
    </header>
    <Outlet />
    </>
  );
}

export default Header;
