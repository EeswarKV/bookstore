package com.project.bookstore.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * OrderItem
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-19T22:10:40.538194900+01:00[Europe/Brussels]")
public class OrderItem {

  private String bookId;

  private Integer quantity;

  public OrderItem() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public OrderItem(String bookId, Integer quantity) {
    this.bookId = bookId;
    this.quantity = quantity;
  }

  public OrderItem bookId(String bookId) {
    this.bookId = bookId;
    return this;
  }

  /**
   * Get bookId
   * @return bookId
  */
  @NotNull 
  @Schema(name = "bookId", example = "book-123", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("bookId")
  public String getBookId() {
    return bookId;
  }

  public void setBookId(String bookId) {
    this.bookId = bookId;
  }

  public OrderItem quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * minimum: 1
   * @return quantity
  */
  @NotNull @Min(1) 
  @Schema(name = "quantity", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("quantity")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderItem orderItem = (OrderItem) o;
    return Objects.equals(this.bookId, orderItem.bookId) &&
        Objects.equals(this.quantity, orderItem.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookId, quantity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderItem {\n");
    sb.append("    bookId: ").append(toIndentedString(bookId)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

