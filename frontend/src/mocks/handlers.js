import { http, HttpResponse } from 'msw'

let lastOrder = null

export const handlers = [
  // -----------------------------
  // Books
  // -----------------------------
  http.get('/api/books', () => {
    return HttpResponse.json([
      {
        id: '1',
        title: 'Clean Architecture',
        author: 'Robert C. Martin',
        price: 40
      }
    ])
  }),

  http.get('/api/books/:id', ({ params }) => {
    if (params.id === '1') {
      return HttpResponse.json({
        id: '1',
        title: 'Clean Architecture',
        author: 'Robert C. Martin',
        price: 40,
        description: 'A book about clean software design.'
      })
    }

    return HttpResponse.json(
      { message: 'Book not found' },
      { status: 404 }
    )
  }),

  // -----------------------------
  // Orders
  // -----------------------------
  http.post('/api/orders', async ({ request }) => {
    const body = await request.json()

    // Super lightweight fake implementation:
    // - echoes the items
    // - calculates total using the stubbed book price
    const items = body?.items || []
    const totalPrice = items.reduce(
      (sum, i) => sum + 40 * (i.quantity || 0),
      0
    )

    lastOrder = {
      orderId: 'order-1',
      status: 'CREATED',
      totalPrice,
      items
    }

    return HttpResponse.json(lastOrder, { status: 201 })
  })
]
