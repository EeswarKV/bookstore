export async function fetchBooks() {
  const response = await fetch('/api/books')

  if (!response.ok) {
    const error = await response.json()
    throw new Error(error.message || 'Failed to fetch books')
  }

  return response.json()
}
