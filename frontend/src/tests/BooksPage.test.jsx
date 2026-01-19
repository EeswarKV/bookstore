import { render, screen, within } from '@testing-library/react'
import { describe, it, expect } from 'vitest'
import { http, HttpResponse } from 'msw'
import { server } from '../mocks/server'
import BooksPage from '../pages/BooksPage'

describe('BooksPage', () => {
  it('shows loading then renders books', async () => {
    render(<BooksPage />)

    expect(screen.getByText(/loading/i)).toBeInTheDocument()

    const list = await screen.findByRole('list')
    const items = within(list).getAllByRole('listitem')

    expect(items).toHaveLength(1)
    expect(items[0]).toHaveTextContent(
      'Clean Architecture – Robert C. Martin'
    )
  })

  it('shows error message when API fails', async () => {
    server.use(
      http.get('/api/books', () => {
        return HttpResponse.json(
          { message: 'Internal Server Error' },
          { status: 500 }
        )
      })
    )

    render(<BooksPage />)

    expect(screen.getByText(/loading/i)).toBeInTheDocument()

    // User-visible error
    expect(
      await screen.findByText(/internal server error/i)
    ).toBeInTheDocument()
  })
})
