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
public class MOSHTARAYAT {
    private int id;
    private String name;
    private Double amount;
    private String unit;
    private int unit_price;
    private Double total_price;
    private int jomla_price;
    private int jomla_daz;
    private int cons_price;
    private int dz_price;
    private Date ob_date;

    public int getJomla_daz() {
        return jomla_daz;
    }

    public void setJomla_daz(int jomla_daz) {
        this.jomla_daz = jomla_daz;
    }

    
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

    public int getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(int unit_price) {
        this.unit_price = unit_price;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public int getJomla_price() {
        return jomla_price;
    }

    public void setJomla_price(int jomla_price) {
        this.jomla_price = jomla_price;
    }

    public int getCons_price() {
        return cons_price;
    }

    public void setCons_price(int cons_price) {
        this.cons_price = cons_price;
    }

    public Date getOb_date() {
        return ob_date;
    }

    public void setOb_date(Date ob_date) {
        this.ob_date = ob_date;
    }

    public int getDz_price() {
        return dz_price;
    }

    public void setDz_price(int dz_price) {
        this.dz_price = dz_price;
    }
    
    
    
    
}
