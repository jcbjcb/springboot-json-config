package com.jcb.spring.json.config.pojo;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * bigOrder
 * @author 
 */
public class L2ShOrderCount implements Serializable {
    @Id
    private Long id=0L;

    private String code;

    private Long amount=0L;

    private Double totalPrice=0D;

    private String gmtStart;
    private String gmtEnd;

    private String type;
    private String saleOrderId;
    private String buyOrderId;
    private String buyOrderPrice;
    private String saleOrderPrice;

    private Date gmtCreate;
    private Date gmtDate;

    private Integer buySaleAmount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getGmtStart() {
        return gmtStart;
    }

    public void setGmtStart(String gmtStart) {
        this.gmtStart = gmtStart;
    }

    public String getGmtEnd() {
        return gmtEnd;
    }

    public void setGmtEnd(String gmtEnd) {
        this.gmtEnd = gmtEnd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(String saleOrderId) {
        this.saleOrderId = saleOrderId;
    }

    public String getBuyOrderId() {
        return buyOrderId;
    }

    public void setBuyOrderId(String buyOrderId) {
        this.buyOrderId = buyOrderId;
    }

    public String getBuyOrderPrice() {
        return buyOrderPrice;
    }

    public void setBuyOrderPrice(String buyOrderPrice) {
        this.buyOrderPrice = buyOrderPrice;
    }

    public String getSaleOrderPrice() {
        return saleOrderPrice;
    }

    public void setSaleOrderPrice(String saleOrderPrice) {
        this.saleOrderPrice = saleOrderPrice;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtDate() {
        return gmtDate;
    }

    public void setGmtDate(Date gmtDate) {
        this.gmtDate = gmtDate;
    }

    public Integer getBuySaleAmount() {
        return buySaleAmount;
    }

    public void setBuySaleAmount(Integer buySaleAmount) {
        this.buySaleAmount = buySaleAmount;
    }
}