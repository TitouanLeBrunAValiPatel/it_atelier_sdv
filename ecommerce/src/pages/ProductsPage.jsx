import { useEffect, useState } from "react";
import ProductCard from "../components/ProductCard";

export default function() {
  const [products, setProducts] = useState([])

  useEffect(() => {
    fetch('http://localhost:8080/api/products/')
    .then(res => res.json())
    .then(data => setProducts(data));
  }, [])


  return (
    <>
      <h1>Products:</h1>
      <div id="products">
        { products.map(product => <ProductCard product={product} key={product.id} />) }
      </div>
    </>
  )
}
