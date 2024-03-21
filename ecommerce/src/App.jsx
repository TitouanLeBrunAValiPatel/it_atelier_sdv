import { useState } from 'react';
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom'
import HomePage from './pages/HomePage';
import ProductsPage from './pages/ProductsPage';
import ProductPage from './pages/ProductPage';
import { FaBars } from 'react-icons/fa';

function App() {
  const [navOpen, setNavOpen] = useState(true)

  function burgerClick() {
    setNavOpen(old => !old)
  }

  return (
    <BrowserRouter>
      <nav>
        <button id="burger" onClick={burgerClick}>
          <FaBars />
        </button>
        <ul id="links" className={navOpen ? "open" : ""}>
          <li><Link to="/">Home</Link></li>
          <li><Link to="/products">Products</Link></li>
        </ul>
      </nav>
      <div id="main">
        <Routes>
          <Route path="/" Component={HomePage} />
          <Route path="/products" Component={ProductsPage} />
          <Route path="/products/:id" Component={ProductPage} />
        </Routes>
      </div>
    </BrowserRouter>
  )
}

export default App
