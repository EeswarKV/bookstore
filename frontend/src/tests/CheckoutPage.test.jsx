import { render, screen } from '@testing-library/react'
import userEvent from '@testing-library/user-event'
import { describe, it, expect } from 'vitest'
import { MemoryRouter } from 'react-router-dom'
import CheckoutPage from '../pages/CheckoutPage'

describe('Checkout flow', () => {
  it('allows user to checkout and see confirmation', async () => {
    const cart = [
      { id: '1', title: 'Clean Architecture', price: 40, quantity: 2 }
    ]

    render(
      <MemoryRouter>
        <CheckoutPage cart={cart} onCheckoutComplete={() => {}} />
      </MemoryRouter>
    )

    const placeOrder = await screen.findByRole('button', {
      name: /place order/i
    })
    await userEvent.click(placeOrder)

    expect(await screen.findByText(/order confirmed/i)).toBeInTheDocument()
  })
})
