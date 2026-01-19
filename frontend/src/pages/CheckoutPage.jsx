import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { createOrder } from '../api/orders'
import './CheckoutPage.css'

export default function CheckoutPage({ cart, onCheckoutComplete }) {
  const navigate = useNavigate()
  const [submitting, setSubmitting] = useState(false)
  const [orderId, setOrderId] = useState(null)
  const [error, setError] = useState(null)

  const total = (cart || []).reduce(
    (sum, item) => sum + (item.price || 0) * (item.quantity || 0),
    0
  )

  async function handleCheckout() {
    setSubmitting(true)
    setError(null)

    try {
      const items = (cart || []).map(i => ({
        bookId: i.id,
        quantity: i.quantity
      }))

      const order = await createOrder(items)
      setOrderId(order.orderId)

      if (onCheckoutComplete) onCheckoutComplete()
    } catch (e) {
      setError(e.message || 'Checkout failed')
    } finally {
      setSubmitting(false)
    }
  }

  if (!cart || cart.length === 0) {
    return (
      <div className="container">
        <h1 className="page-title">Checkout</h1>
        <p>Your cart is empty</p>
      </div>
    )
  }

  if (orderId) {
    return (
      <div className="container">
        <h1 className="page-title">Order confirmed</h1>

        <div className="card checkout-card">
          <p><strong>Order ID:</strong> {orderId}</p>
          <button className="btn btn-primary" onClick={() => navigate('/books')}>
            Back to books
          </button>
        </div>
      </div>
    )
  }

  return (
    <div className="container">
      <h1 className="page-title">Checkout</h1>

      <div className="card checkout-card">
        <ul className="checkout-list">
          {cart.map(item => (
            <li className="checkout-item" key={item.id}>
              {item.title} × {item.quantity}
            </li>
          ))}
        </ul>

        <div className="checkout-actions">
          <strong>Total: €{total.toFixed(2)}</strong>

          <button className="btn btn-primary" onClick={handleCheckout} disabled={submitting}>
            {submitting ? 'Placing order…' : 'Place Order'}
          </button>
        </div>

        {error && <p className="alert" role="alert">{error}</p>}
      </div>
    </div>
  )
}
