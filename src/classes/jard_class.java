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
public class jard_class {

    public ArrayList<MOSHTARAYAT> rsultmoshtarayat(String next) {

        String query = "select * from MOSHTARAYAT  " + next + " ";
        //   String query="select * from MABEAAT  ";
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
//                ben.setJomla_price(rs.getInt("jomla_price"));
//                ben.setCons_price(rs.getInt("cons_price"));
                ben.setOb_date(rs.getDate("ob_date"));

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

    public ArrayList<MABE3AT> rsultmabe3at(String next) {

        String query = "select * from MABE3AT  " + next + " ";
        //   String query="select * from MABEAAT  ";
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

    public ArrayList<DAILY> rsultdaily(String next) {

        String query = "select * from daily  " + next + " ";
        //   String query="select * from MABEAAT  ";
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
}
