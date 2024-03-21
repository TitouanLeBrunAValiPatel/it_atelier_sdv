export function getEntries() {
  return JSON.parse(localStorage.getItem("cart")) ?? []
}

export function clearCart() {
  localStorage.removeItem("cart")
}

export function addToCart(id, qty) {
  let cart = getEntries()

  let entry = cart.find(entry => entry.id === id)
  if (!entry) {
    cart.push({ id, qty })
  } else {
    entry.qty += qty
  }

  localStorage.setItem("cart", JSON.stringify(cart))
}

export function removeFromCart(id, qty) {
  let cart = getEntries()

  let entry = cart.find(entry => entry.id === id)
  if (entry) {
    entry.qty -= qty
    if (entry.qty <= 0) {
      cart = cart.filter(entry => entry.id !== id)
    }
  }

  localStorage.setItem("cart", JSON.stringify(cart))
}
