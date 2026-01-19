import { useState } from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import BooksPage from "./pages/BooksPage";
import CartPage from "./pages/CartPage";
import CheckoutPage from "./pages/CheckoutPage";
import NavBar from "./components/NavBar";

function App() {
  const [cart, setCart] = useState([]);

  const addToCart = (book) => {
    setCart(current => {
      const existing = current.find(item => item.id === book.id);

      if (existing) {
        return current.map(item =>
          item.id === book.id
            ? { ...item, quantity: item.quantity + 1 }
            : item
        );
      }

      return [...current, { ...book, quantity: 1 }];
    });
  };

  const updateQuantity = (id, quantity) => {
    if (quantity <= 0) {
      removeFromCart(id);
      return;
    }

    setCart(current =>
      current.map(item =>
        item.id === id ? { ...item, quantity } : item
      )
    );
  };

  const removeFromCart = (id) => {
    setCart(current => current.filter(item => item.id !== id));
  };

  return (
    <BrowserRouter>
      <NavBar cartCount={cart.length} />

      <Routes>
        <Route
          path="/books"
          element={<BooksPage onAddToCart={addToCart} />}
        />

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
          element={<CheckoutPage cart={cart} />}
        />

        <Route
          path="*"
          element={<BooksPage onAddToCart={addToCart} />}
        />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
