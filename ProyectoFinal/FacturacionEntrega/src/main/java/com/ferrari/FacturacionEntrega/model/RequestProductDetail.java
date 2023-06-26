package com.ferrari.FacturacionEntrega.model;

public class RequestProductDetail {
  private int productId;
  private int quantity;
  private RequestProduct requestProduct;

  public RequestProductDetail(int productId, int quantity) {
    this.productId = productId;
    this.quantity = quantity;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public RequestProduct getRequestProduct() {
    return requestProduct;
  }

  public void setRequestProduct(RequestProduct requestProduct) {
    this.requestProduct = requestProduct;
  }
}
