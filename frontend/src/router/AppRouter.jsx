import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom'
import { useMemo, useState } from 'react'
import NavBar from '../components/NavBar'
import BooksPage from '../pages/BooksPage'
import BookDetailsPage from '../pages/BookDetailsPage'
import CartPage from '../pages/CartPage'
import CheckoutPage from '../pages/CheckoutPage'

function loadCart() {
  try {
    const raw = localStorage.getItem('cart')
    return raw ? JSON.parse(raw) : []
  } catch {
    return []
  }
}

function saveCart(cart) {
  localStorage.setItem('cart', JSON.stringify(cart))
}

export default function AppRouter() {
  const [cart, setCart] = useState(() => loadCart())

  const cartCount = useMemo(
    () => cart.reduce((sum, item) => sum + (item.quantity || 0), 0),
    [cart]
  )

  function addToCart(book) {
    setCart(current => {
      const existing = current.find(i => i.id === book.id)
      const next = existing
        ? current.map(i =>
            i.id === book.id ? { ...i, quantity: i.quantity + 1 } : i
          )
        : [...current, { ...book, quantity: 1 }]
      saveCart(next)
      return next
    })
  }

  function updateQuantity(bookId, quantity) {
    setCart(current => {
      const next = current
        .map(i => (i.id === bookId ? { ...i, quantity } : i))
        .filter(i => i.quantity > 0)
      saveCart(next)
      return next
    })
  }

  function removeFromCart(bookId) {
    setCart(current => {
      const next = current.filter(i => i.id !== bookId)
      saveCart(next)
      return next
    })
  }

  function clearCart() {
    setCart([])
    saveCart([])
  }

  return (
    <BrowserRouter>
      <NavBar cartCount={cartCount} />

      <Routes>
        <Route path="/" element={<Navigate to="/books" replace />} />

        <Route path="/books" element={<BooksPage onAddToCart={addToCart} />} />
        <Route path="/books/:id" element={<BookDetailsPage />} />
        <Route
          path="/cart"
          element={
            <CartPage
              cart={cart}
              onUpdateQuantity={updateQuantity}
              onRemove={removeFromCart}
            />
          }
        />

        <Route
          path="/checkout"
          element={<CheckoutPage cart={cart} onCheckoutComplete={clearCart} />}
        />

        <Route path="*" element={<h2>Page not found</h2>} />
      </Routes>
    </BrowserRouter>
  )
}
