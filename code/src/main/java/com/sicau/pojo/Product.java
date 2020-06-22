package com.sicau.pojo;


public class Product {

  private long pId;
  private long sId;
  private long oId;
  private String pName;
  private String pInfo;
  private long pNum;
  private double pPrice;
  private String picture;

  public Product() {
  }

  public Product(long pId, long sId, long oId, String pName, String pInfo, long pNum, double pPrice, String picture) {
    this.pId = pId;
    this.sId = sId;
    this.oId = oId;
    this.pName = pName;
    this.pInfo = pInfo;
    this.pNum = pNum;
    this.pPrice = pPrice;
    this.picture = picture;
  }

  public long getPId() {
    return pId;
  }

  public void setPId(long pId) {
    this.pId = pId;
  }


  public long getSId() {
    return sId;
  }

  public void setSId(long sId) {
    this.sId = sId;
  }


  public long getOId() {
    return oId;
  }

  public void setOId(long oId) {
    this.oId = oId;
  }


  public String getPName() {
    return pName;
  }

  public void setPName(String pName) {
    this.pName = pName;
  }


  public String getPInfo() {
    return pInfo;
  }

  public void setPInfo(String pInfo) {
    this.pInfo = pInfo;
  }


  public long getPNum() {
    return pNum;
  }

  public void setPNum(long pNum) {
    this.pNum = pNum;
  }


  public double getPPrice() {
    return pPrice;
  }

  public void setPPrice(double pPrice) {
    this.pPrice = pPrice;
  }


  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  @Override
  public String toString() {
    return "Product{" +
            "pId=" + pId +
            ", sId=" + sId +
            ", oId=" + oId +
            ", pName='" + pName + '\'' +
            ", pInfo='" + pInfo + '\'' +
            ", pNum=" + pNum +
            ", pPrice=" + pPrice +
            ", picture='" + picture + '\'' +
            '}';
  }
}
