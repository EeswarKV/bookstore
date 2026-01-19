import { Link } from "react-router-dom";
import "./NavBar.css";

function NavBar({ cartCount }) {
  return (
    <header className="topbar">
      <div className="topbar-inner">
        <div className="brand">BookStore</div>

        <nav className="navlinks">
          <Link to="/books">Books</Link>
          <Link to="/cart">
            Cart <span className="badge">{cartCount}</span>
          </Link>
          <Link to="/checkout">Checkout</Link>
        </nav>
      </div>
    </header>
  );
}

export default NavBar;
