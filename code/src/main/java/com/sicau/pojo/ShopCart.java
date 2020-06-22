package com.sicau.pojo;


public class ShopCart {

  private long sId;
  private long uId;

  public ShopCart() {
  }

  public ShopCart(long sId, long uId) {
    this.sId = sId;
    this.uId = uId;
  }

  public long getSId() {
    return sId;
  }

  public void setSId(long sId) {
    this.sId = sId;
  }


  public long getUId() {
    return uId;
  }

  public void setUId(long uId) {
    this.uId = uId;
  }

  @Override
  public String toString() {
    return "ShopCart{" +
            "sId=" + sId +
            ", uId=" + uId +
            '}';
  }
}
