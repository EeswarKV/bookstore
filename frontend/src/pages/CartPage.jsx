import { Link } from 'react-router-dom'
import './CartPage.css'

export default function CartPage({ cart, onUpdateQuantity, onRemove }) {
  if (!cart || cart.length === 0) {
    return <div className="container"><p>Your cart is empty</p></div>
  }

  const total = cart.reduce(
    (sum, item) => sum + (item.price || 0) * (item.quantity || 0),
    0
  )

  return (
    <div className="container">
      <h1 className="page-title">Cart</h1>

      <div className="card cart-card">
        <ul className="cart-list">
          {cart.map(item => (
            <li className="cart-item" key={item.id}>
              <div>
                <strong>{item.title}</strong>
                <span style={{ color: 'var(--muted)' }}>€{item.price}</span>
              </div>

              <input
                className="input"
                style={{ width: '4.5rem' }}
                type="number"
                min="1"
                value={item.quantity}
                onChange={e => onUpdateQuantity(item.id, Number(e.target.value))}
              />

              <button className="btn btn-danger" onClick={() => onRemove(item.id)}>
                Remove
              </button>
            </li>
          ))}
        </ul>

        <div className="cart-total">
          <strong>Total</strong>
          <strong>€{total.toFixed(2)}</strong>
        </div>

        <div className="cart-footer">
          <Link className="btn btn-primary" to="/checkout">
            Proceed to checkout
          </Link>
        </div>
      </div>
    </div>
  )
}
