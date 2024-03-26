/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import Connetction.dbconnect;
import entities.DAILY;
import entities.MABE3AT;
import entities.MOSHTARAYAT;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Nowar
 */
public class update_class {

    public ArrayList<MOSHTARAYAT> showmoshtarayat() {
        String query = "select ob_id,ob_name,ob_amount,unit,unit_price,total_price,jomla_price,jomla_daz,cons_price,daz_price,ob_date from MOSHTARAYAT  ";
        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
        ArrayList<MOSHTARAYAT> infopro = new ArrayList<MOSHTARAYAT>();
        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                MOSHTARAYAT ben = new MOSHTARAYAT();
                ben.setId(rs.getInt("ob_id"));
                ben.setName(rs.getString("ob_name"));
                ben.setAmount(rs.getDouble("ob_amount"));
                ben.setUnit(rs.getString("unit"));
                ben.setUnit_price(rs.getInt("unit_price"));
                ben.setTotal_price(rs.getDouble("total_price"));
                ben.setJomla_price(rs.getInt("jomla_price"));
                ben.setJomla_daz(rs.getInt("jomla_daz"));
                ben.setCons_price(rs.getInt("cons_price"));
                ben.setDz_price(rs.getInt("daz_price"));
                ben.setOb_date(rs.getDate("ob_date"));

                infopro.add(ben);

            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                Connect.close();
                statement.close();
            } catch (SQLException ex) {
                //    Logger.getLogger(tables.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return infopro;

    }

    public void updatemoshtarayat(MOSHTARAYAT mo) throws SQLException {

        String query = "update MOSHTARAYAT set ob_name='" + mo.getName() + "',ob_amount=" + mo.getAmount() + ""
                + ",unit='" + mo.getUnit() + "',unit_price=" + mo.getUnit_price() + ""
                + ",total_price=" + mo.getTotal_price() + ",jomla_price=" + mo.getJomla_price() + ",jomla_daz="+mo.getJomla_daz()+",cons_price=" + mo.getCons_price() + ",daz_price="+mo.getDz_price()+" where ob_id=" + mo.getId() + "     ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
        try {
            statement = Connect.createStatement();
            statement.execute(query);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Connect.close();
            statement.close();

        }

    }
    public void deletemoshtarayt(int id) throws SQLException {

        String query = "delete from MOSHTARAYAT where ob_id="+id+" ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
        try {
            statement = Connect.createStatement();
            statement.execute(query);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Connect.close();
            statement.close();

        }

    }
    public void deletemoshlink(int id) throws SQLException {

        String query = "delete from bill_mo_link where ob_id="+id+" ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
        try {
            statement = Connect.createStatement();
            statement.execute(query);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Connect.close();
            statement.close();

        }

    }
      public void deletemabe3at(int id) throws SQLException {

            String query = "delete from MABE3AT where ma_id="+id+" ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
        try {
            statement = Connect.createStatement();
            statement.execute(query);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Connect.close();
            statement.close();

        }

    }
      public void deletemabe3atzbon(int id) throws SQLException {

        String query = "delete from zabon where ob_id="+id+" ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
        try {
            statement = Connect.createStatement();
            statement.execute(query);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Connect.close();
            statement.close();

        }

    }

    public ArrayList<MABE3AT> showmabe3at() {
        String query = "select ma_id,ma_name,ma_amount,ma_unit,ma_price,ma_total_price,cons_price,con_id,ma_date from MABE3AT  ";
        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
        ArrayList<MABE3AT> infopro = new ArrayList<MABE3AT>();
        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                MABE3AT ben = new MABE3AT();
                ben.setId(rs.getInt("ma_id"));
                ben.setName(rs.getString("ma_name"));
                ben.setAmount(rs.getDouble("ma_amount"));
                ben.setUnit(rs.getString("ma_unit"));
                ben.setPrice(rs.getInt("ma_price"));
                ben.setTotalprice(rs.getDouble("ma_total_price"));
                ben.setCons_price(rs.getInt("cons_price"));
                ben.setConid(rs.getInt("con_id"));
                ben.setMa_date(rs.getDate("ma_date"));

                infopro.add(ben);

            }
        } catch (Exception e) {

        } finally {
            try {
                Connect.close();
                statement.close();
            } catch (SQLException ex) {
                //    Logger.getLogger(tables.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return infopro;

    }

    public void updatemabe3at(MABE3AT mo) throws SQLException {

        String query = "update MABE3AT set ma_name='" + mo.getName() + "',ma_amount=" + mo.getAmount() + ""
                + ",ma_unit='" + mo.getUnit() + "',ma_price=" + mo.getPrice() + ""
                + ",ma_total_price=" + mo.getTotalprice() + ",cons_price=" + mo.getCons_price() + " where ma_id=" + mo.getId() + "     ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
        try {
            statement = Connect.createStatement();
            statement.execute(query);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Connect.close();
            statement.close();

        }

    }

     public void deletedaily(int id) throws SQLException {

            String query = "delete from daily where id="+id+" ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
        try {
            statement = Connect.createStatement();
            statement.execute(query);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Connect.close();
            statement.close();

        }

    }
    public ArrayList<DAILY> showdaily() {
        String query = "select id,obname,obunit,obamount,obprice,total_price,obdate from daily  ";
        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
        ArrayList<DAILY> infopro = new ArrayList<DAILY>();
        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                DAILY ben = new DAILY();
                ben.setId(rs.getInt("id"));
                ben.setObname(rs.getString("obname"));
                ben.setObunit(rs.getString("obunit"));
                ben.setObamount(rs.getDouble("obamount"));
                ben.setObprice(rs.getInt("obprice"));
                ben.setTotalprice(rs.getDouble("total_price"));
                ben.setObdate(rs.getDate("obdate"));

                infopro.add(ben);

            }
        } catch (Exception e) {

        } finally {
            try {
                Connect.close();
                statement.close();
            } catch (SQLException ex) {
                //    Logger.getLogger(tables.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return infopro;

    }

    public void updatedaily(DAILY mo) throws SQLException {

        String query = "update daily set obname='" + mo.getObname() + "',obunit='"+mo.getObunit()+"',obamount=" + mo.getObamount() + ""
                + ",obprice='" + mo.getObprice() + "',total_price=" + mo.getTotalprice() + ""
                + "  where id=" + mo.getId() + "     ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
        try {
            statement = Connect.createStatement();
            statement.execute(query);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Connect.close();
            statement.close();

        }

    }

}
