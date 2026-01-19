export async function fetchBookById(id) {
  const response = await fetch(`/api/books/${id}`)

  if (!response.ok) {
    const error = await response.json()
    throw new Error(error.message || 'Failed to fetch book')
  }

  return response.json()
}
