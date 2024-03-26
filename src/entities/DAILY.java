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
public class DAILY {
    private int id;
    private String obname;
    private String obunit;
    private Double obamount;
    private int obprice;
    private Double totalprice;
    private Date obdate;

    public String getObunit() {
        return obunit;
    }

    public void setObunit(String obunit) {
        this.obunit = obunit;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObname() {
        return obname;
    }

    public void setObname(String obname) {
        this.obname = obname;
    }

    public Double getObamount() {
        return obamount;
    }

    public void setObamount(Double obamount) {
        this.obamount = obamount;
    }

    public int getObprice() {
        return obprice;
    }

    public void setObprice(int obprice) {
        this.obprice = obprice;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    
    public Date getObdate() {
        return obdate;
    }

    public void setObdate(Date obdate) {
        this.obdate = obdate;
    }
    
    
    
}
