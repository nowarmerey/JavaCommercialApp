/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import Connetction.dbconnect;
import entities.DAILY;
import entities.MABE3AT;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Nowar
 */
public class daily_class {

    public void addDaily(DAILY bn) throws SQLException {

        String query = "insert into daily (obname,obunit,obamount,obprice,total_price,obdate) values(?,?,?,?,?,?)";

        dbconnect con = new dbconnect();

        Connection Connect = con.getConnection();
        PreparedStatement st = Connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, bn.getObname());
        st.setString(2, bn.getObunit());

        st.setDouble(3, bn.getObamount());

        st.setInt(4, bn.getObprice());
        st.setDouble(5, bn.getTotalprice());
        st.setDate(6, bn.getObdate());
        try {
            st.executeUpdate();
            // statement = Connect.createStatement();
            //  statement.execute(query);

        } catch (Exception e) {
            System.out.println(e);

        } finally {
            Connect.close();
            //  statement.close();

        }
    }

    public ArrayList<DAILY> showdaily() {
        String query = "select id,obname,obunit,obamount,obprice,total_price,obdate from daily ";
        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
       
        ArrayList<DAILY> info = new ArrayList<DAILY>();
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

                info.add(ben);

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

        return info;

    }
       public ArrayList<Integer> getobjectinfo(String oldname) {
        ArrayList<Integer> ar = new ArrayList<>();
        int unitprice = 0, amount = 0, sum = 0;
        String query = "select obamount,obprice,total_price from daily where obname='" + oldname + "' ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
       
        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                unitprice = rs.getInt("obprice");
                amount = amount+ rs.getInt("obamount");
                sum = sum + rs.getInt("total_price");
                
                
            }
            ar.add(unitprice);
            ar.add(amount);
            ar.add(sum);
          
        } catch (Exception e) {

        } finally {
            try {
                Connect.close();
                statement.close();
            } catch (SQLException ex) {
                //    Logger.getLogger(tables.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return ar;
    }

}
