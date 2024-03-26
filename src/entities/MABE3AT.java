/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author Nowar
 */
public class MABE3AT {
    private int id;
    private String name;
    private Double amount;
    private String unit;
    private int price;
    private Double totalprice;
    private int cons_price;
    private int conid;
    private Date ma_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public int getCons_price() {
        return cons_price;
    }

    public void setCons_price(int cons_price) {
        this.cons_price = cons_price;
    }

    public int getConid() {
        return conid;
    }

    public void setConid(int conid) {
        this.conid = conid;
    }

    public Date getMa_date() {
        return ma_date;
    }

    public void setMa_date(Date ma_date) {
        this.ma_date = ma_date;
    }
    
    
    
}
