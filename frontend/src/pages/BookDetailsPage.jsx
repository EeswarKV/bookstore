import { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import { fetchBookById } from '../api/bookDetails'

export default function BookDetailsPage() {
  const { id } = useParams()
  const [book, setBook] = useState(null)
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState(null)

  useEffect(() => {
    fetchBookById(id)
      .then(setBook)
      .catch(err => setError(err.message))
      .finally(() => setLoading(false))
  }, [id])

  if (loading) return <p>Loading...</p>

  if (error) {
    return (
      <p role="alert">
        {error}
      </p>
    )
  }

  return (
    <div>
      <h1>{book.title}</h1>
      <p>{book.author}</p>
      <p>{book.description}</p>
      <p>Price: €{book.price}</p>
    </div>
  )
}
