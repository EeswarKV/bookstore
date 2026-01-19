import { Link } from 'react-router-dom'
import './Header.css'

export default function Header({ cartCount }) {
  return (
    <header className="header">
      <div className="header-inner">
        <div className="logo">📚 BookStore</div>

        <nav className="nav">
          <Link to="/">Books</Link>
          <Link to="/cart">
            Cart
            {cartCount > 0 && (
              <span className="cart-badge">{cartCount}</span>
            )}
          </Link>
        </nav>
      </div>
    </header>
  )
}
