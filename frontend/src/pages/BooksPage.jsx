import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import { fetchBooks } from '../api/books'
import './BooksPage.css'

export default function BooksPage({ onAddToCart }) {
  const [books, setBooks] = useState([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState(null)

  useEffect(() => {
    fetchBooks()
      .then(setBooks)
      .catch(err => setError(err.message))
      .finally(() => setLoading(false))
  }, [])

  if (loading) return <div className="container"><p>Loading...</p></div>

  if (error) {
    return (
      <div className="container">
        <p role="alert">{error}</p>
      </div>
    )
  }

  return (
    <div className="container">
      <h1 className="page-title">Books</h1>

      <div className="books-grid">
        {books.map(book => (
          <div className="card book-card" key={book.id}>
            <h3 className="book-title">{book.title}</h3>
            <p className="book-meta">{book.author} • €{book.price}</p>

            <div className="book-actions">
              <Link className="book-link" to={`/books/${book.id}`}>
                Details →
              </Link>

              {onAddToCart && (
                <button className="btn btn-primary" onClick={() => onAddToCart(book)}>
                  Add
                </button>
              )}
            </div>
          </div>
        ))}
      </div>
    </div>
  )
}
