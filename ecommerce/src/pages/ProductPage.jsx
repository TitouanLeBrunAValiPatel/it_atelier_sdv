import { useEffect, useState } from 'react';
import { FaStar } from 'react-icons/fa';
import { useParams } from 'react-router-dom';
import { addToCart } from '../lib/cart';

export default function() {
  const { id } = useParams()
  const [product, setProduct] = useState({})
  const [quantity, setQuantity] = useState(1)

  useEffect(() => {
    fetch(`http://localhost:8080/api/products/${id}`)
    .then(res => res.json())
    .then(setProduct)
  }, [])

  function incrQty(e) {
    e.preventDefault()
    setQuantity(old => old + 1)
  }

  function decrQty(e) {
    e.preventDefault()
    if (quantity > 1) {
      setQuantity(old => old - 1)
    }
  }

  function changeQuantity(e) {
    const qty = Number(e.target.value)
    if (qty > 0) {
      setQuantity(qty)
    }
  }

  function onAddToCart(e) {
    e.preventDefault()
    addToCart(product.id, quantity)
  }

  return (

  <>
      <div className="product">

        <img src="https://picsum.photos/250" />
        <div className="infos">
          <div className="name-rating">
            <h1>{product.name}</h1>
          </div>
          {product.category ? <h2 className="rating"> Category : {product.category.name}</h2> : null}

          <span className="price">{product.price}€</span>
          <div className="stock-cart">
            <span className="stock">Stock: {product.stock}</span>
            <form onSubmit={onAddToCart}>
              <button onClick={decrQty}>-</button>
              <input value={quantity} onChange={changeQuantity} type="number" name="quantity" />
              <button onClick={incrQty}>+</button>
              <input type="submit" value="Add to cart" />
            </form>
          </div>
        </div>
      </div>
      <h2>Description du produit :</h2>
      <p>{product.description}</p>

    </>
  )
}
