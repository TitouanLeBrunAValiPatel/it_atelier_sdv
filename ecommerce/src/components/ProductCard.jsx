import { Link } from "react-router-dom";

export default function({ product }) {
  return (
    <div className="product-card">
      <img width="250" src="https://picsum.photos/250"/>

      <div className="infos">
        <div className="name-price">
          <span className="name">
            <Link to={"/products/" + product.id}>
              {product.name}
            </Link>
          </span>
          <span className="price">{product.price}€</span>
        </div>
        <p>{product.description}</p>
      </div>
    </div>
  )
}
