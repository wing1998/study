package com.sicau.pojo;


import java.sql.Date;

public class UOrder {

  private long oId;
  private long uId;
  private long pId;
  private double totalPrice;
  private java.sql.Date oTime;

  public UOrder() {
  }

  public UOrder(long oId, long uId, double totalPrice, Date oTime) {
    this.oId = oId;
    this.uId = uId;
    this.totalPrice = totalPrice;
    this.oTime = oTime;
  }

  public long getOId() {
    return oId;
  }

  public void setOId(long oId) {
    this.oId = oId;
  }


  public long getUId() {
    return uId;
  }

  public void setUId(long uId) {
    this.uId = uId;
  }


  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }


  public java.sql.Date getOTime() {
    return oTime;
  }

  public void setOTime(java.sql.Date oTime) {
    this.oTime = oTime;
  }

  public long getPId() {
    return pId;
  }

  public void setPId(long pId) {
    this.pId = pId;
  }

  @Override
  public String toString() {
    return "UOrder{" +
            "oId=" + oId +
            ", uId=" + uId +
            ", pId=" + pId +
            ", totalPrice=" + totalPrice +
            ", oTime=" + oTime +
            '}';
  }
}
