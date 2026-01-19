/**
 * Orders API (matches the current Spring Boot OpenAPI contract).
 *
 * POST /api/orders expects:
 *   { items: [{ bookId, quantity }, ...] }
 * and responds with:
 *   { orderId, status, totalPrice, items }
 */

export async function createOrder(items) {
  const res = await fetch('/api/orders', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ items })
  })

  if (!res.ok) {
    const err = await safeJson(res)
    throw new Error(err?.message || 'Failed to create order')
  }

  return res.json()
}

async function safeJson(res) {
  try {
    return await res.json()
  } catch {
    return null
  }
}
