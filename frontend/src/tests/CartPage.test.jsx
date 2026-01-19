import { render, screen } from '@testing-library/react'
import userEvent from '@testing-library/user-event'
import { describe, it, expect, vi } from 'vitest'
import CartPage from '../pages/CartPage'

describe('CartPage', () => {
  it('allows removing item from cart', async () => {
    const cart = [
      { id: '1', title: 'Clean Architecture', price: 40, quantity: 1 }
    ]
    const onRemove = vi.fn()
    const onUpdateQuantity = vi.fn()

    render(
      <CartPage
        cart={cart}
        onRemove={onRemove}
        onUpdateQuantity={onUpdateQuantity}
      />
    )

    const removeButton = await screen.findByRole('button', { name: /remove/i })
    await userEvent.click(removeButton)

    expect(onRemove).toHaveBeenCalledWith('1')
  })
})
