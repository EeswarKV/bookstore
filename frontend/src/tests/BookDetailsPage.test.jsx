import { render, screen } from '@testing-library/react'
import { describe, it, expect } from 'vitest'
import { MemoryRouter, Route, Routes } from 'react-router-dom'
import BookDetailsPage from '../pages/BookDetailsPage'

function renderWithRouter(bookId) {
  return render(
    <MemoryRouter initialEntries={[`/books/${bookId}`]}>
      <Routes>
        <Route path="/books/:id" element={<BookDetailsPage />} />
      </Routes>
    </MemoryRouter>
  )
}

describe('BookDetailsPage', () => {
  it('shows loading then renders book details', async () => {
    renderWithRouter('1')

    expect(screen.getByText(/loading/i)).toBeInTheDocument()

    expect(
      await screen.findByText('Clean Architecture')
    ).toBeInTheDocument()

    expect(
      screen.getByText('Robert C. Martin')
    ).toBeInTheDocument()

    expect(
      screen.getByText(/clean software design/i)
    ).toBeInTheDocument()
  })

  it('shows error when book is not found', async () => {
    renderWithRouter('999')

    expect(
      await screen.findByText(/book not found/i)
    ).toBeInTheDocument()
  })
})
