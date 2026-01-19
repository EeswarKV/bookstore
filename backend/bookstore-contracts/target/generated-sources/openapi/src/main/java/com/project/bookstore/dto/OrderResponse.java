package com.project.bookstore.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.project.bookstore.dto.OrderItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * OrderResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-19T22:10:40.538194900+01:00[Europe/Brussels]")
public class OrderResponse {

  private String orderId;

  private String status;

  private String message;

  private Double totalPrice;

  @Valid
  private List<@Valid OrderItem> items = new ArrayList<>();

  public OrderResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public OrderResponse(String orderId, String status, Double totalPrice, List<@Valid OrderItem> items) {
    this.orderId = orderId;
    this.status = status;
    this.totalPrice = totalPrice;
    this.items = items;
  }

  public OrderResponse orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * Get orderId
   * @return orderId
  */
  @NotNull 
  @Schema(name = "orderId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("orderId")
  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public OrderResponse status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @NotNull 
  @Schema(name = "status", example = "CREATED", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public OrderResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  */
  
  @Schema(name = "message", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public OrderResponse totalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
    return this;
  }

  /**
   * Get totalPrice
   * @return totalPrice
  */
  @NotNull 
  @Schema(name = "totalPrice", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalPrice")
  public Double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public OrderResponse items(List<@Valid OrderItem> items) {
    this.items = items;
    return this;
  }

  public OrderResponse addItemsItem(OrderItem itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Get items
   * @return items
  */
  @NotNull @Valid 
  @Schema(name = "items", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("items")
  public List<@Valid OrderItem> getItems() {
    return items;
  }

  public void setItems(List<@Valid OrderItem> items) {
    this.items = items;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderResponse orderResponse = (OrderResponse) o;
    return Objects.equals(this.orderId, orderResponse.orderId) &&
        Objects.equals(this.status, orderResponse.status) &&
        Objects.equals(this.message, orderResponse.message) &&
        Objects.equals(this.totalPrice, orderResponse.totalPrice) &&
        Objects.equals(this.items, orderResponse.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, status, message, totalPrice, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderResponse {\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    totalPrice: ").append(toIndentedString(totalPrice)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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

