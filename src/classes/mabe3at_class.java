/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import Connetction.dbconnect;
import entities.MOSHTARAYAT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import entities.MABE3AT;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 *
 * @author Nowar
 */
public class mabe3at_class {

    public void addmabe3at(MABE3AT bn) throws SQLException {

        String query = "insert into MABE3AT (ma_name,ma_amount,ma_unit,ma_price,ma_total_price,cons_price,con_id,ma_date) values(?,?,?,?,?,?,?,?)";

        dbconnect con = new dbconnect();

        Connection Connect = con.getConnection();
        PreparedStatement st = Connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, bn.getName());

        st.setDouble(2, bn.getAmount());

        st.setString(3, bn.getUnit());
        st.setInt(4, bn.getPrice());
        st.setDouble(5, bn.getTotalprice());
        st.setInt(6, bn.getCons_price());
        st.setInt(7, bn.getConid());
        st.setDate(8, bn.getMa_date());
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

    public void addzbon(int id, String name, int ob_id, int billid) throws SQLException {

        String query = "insert into zabon (consumer_num,consumer_name,ob_id,bill_id) values(?,?,?,?)";

        dbconnect con = new dbconnect();

        Connection Connect = con.getConnection();
        PreparedStatement st = Connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        st.setInt(1, id);
        st.setString(2, name);
        st.setInt(3, ob_id);
        st.setInt(4, billid);

        // Statement statement = null;
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

    public ArrayList<String> getzbonsname() {
        ArrayList<MOSHTARAYAT> info = new ArrayList<MOSHTARAYAT>();
        ArrayList<String> info1 = new ArrayList<String>();
        String name = "";
        String query = "select consumer_name from zabon";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;

        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                MOSHTARAYAT ben = new MOSHTARAYAT();
                name = rs.getString("consumer_name");

                ben.setName(rs.getString("consumer_name"));
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
        for (int i = 0; i < info.size(); i++) {
            info1.add(info.get(i).getName());
        }
        LinkedHashSet<String> set = new LinkedHashSet<String>(info1);
        ArrayList<String> listWithoutDuplicateElements = new ArrayList<String>(set);

        return listWithoutDuplicateElements;
    }

    public ArrayList<MABE3AT> showmabe3at(String zname, int billid) {
        String query = "select b.ob_id,m.ma_id,m.ma_name,m.ma_amount,m.ma_unit,m.ma_price,m.ma_total_price,m.cons_price,m.ma_date from MABE3AT m,zabon b "
                + "where b.ob_id=m.ma_id and b.consumer_name='" + zname + "' and b.bill_id=" + billid + " ";
        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
        ArrayList<MABE3AT> info = new ArrayList<MABE3AT>();
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
                ben.setMa_date(rs.getDate("ma_date"));

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

    public int ConsumerNumber(String name) {
        int x = 0;
        String query = "SELECT consumer_num  from zabon where consumer_name='" + name + "' ";
        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;

        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                x = rs.getInt("consumer_num");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                Connect.close();
                statement.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }

        return x;
    }

    public int maxnumber() {
        int x = 0;
        String query = "SELECT MAX(ma_id) as ma from MABE3AT";
        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;

        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                x = rs.getInt("ma");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                Connect.close();
                statement.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }

        return x;
    }

    public int maxbillid() {
        int x = 0;
        String query = "SELECT MAX(bill_id) as ma from zabon";
        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;

        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                x = rs.getInt("ma");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                Connect.close();
                statement.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
        System.out.println("max billid is :" + x);
        return x;
    }

    public int maxzid() {
        int x = 0;
        String query = "SELECT MAX(consumer_num) as ma from zabon";
        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;

        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                x = rs.getInt("ma");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                Connect.close();
                statement.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
        System.out.println("max billid is :" + x);
        return x;
    }

    public ArrayList<Integer> getbillid(String name) {
        ArrayList<Integer> ar = new ArrayList<>();
        int id = 0;
        String query = "select bill_id from zabon where consumer_name='" + name + "' ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;

        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                id = rs.getInt("bill_id");

                ar.add(id);

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

        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>(ar);
        ArrayList<Integer> listWithoutDuplicateElements = new ArrayList<Integer>(set);

        return listWithoutDuplicateElements;
    }
    
    public ArrayList<MABE3AT> getbillbyid(int id){
        ArrayList<MABE3AT> ar = new ArrayList<>();
       
        String query = "select ma_name,ma_amount,ma_unit,ma_price,ma_total_price,cons_price,ma_date from MABE3AT,zabon  where consumer_num=con_id and ma_id=ob_id and bill_id="+id+" ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;

        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
               
                 MABE3AT ben = new MABE3AT();
                
                ben.setName(rs.getString("ma_name"));
                ben.setAmount(rs.getDouble("ma_amount"));
                ben.setUnit(rs.getString("ma_unit"));
                ben.setPrice(rs.getInt("ma_price"));
                ben.setTotalprice(rs.getDouble("ma_total_price"));
                ben.setCons_price(rs.getInt("cons_price"));
                ben.setMa_date(rs.getDate("ma_date"));

                ar.add(ben);


            }
        } catch (Exception e) {
               System.out.println(e.getMessage());
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
    
    public ArrayList<Integer> getallbillsfrommab() {
        ArrayList<Integer> ar = new ArrayList<>();
        int id = 0;
        String query = "select bill_id from zabon ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;

        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                id = rs.getInt("bill_id");

                ar.add(id);

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

        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>(ar);
        ArrayList<Integer> listWithoutDuplicateElements = new ArrayList<Integer>(set);

        return listWithoutDuplicateElements;
    }
    
    public ArrayList<Integer> getallbillsfrommosh() {
        ArrayList<Integer> ar = new ArrayList<>();
        int id = 0;
        String query = "select bill_id from bill_mo_link ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;

        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                id = rs.getInt("bill_id");

                ar.add(id);

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

        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>(ar);
        ArrayList<Integer> listWithoutDuplicateElements = new ArrayList<Integer>(set);

        return listWithoutDuplicateElements;
    }
    
    public ArrayList<MABE3AT> showmabe3atnew(int billid) {
        String query = "select b.ob_id,m.ma_id,m.ma_name,m.ma_amount,m.ma_unit,m.ma_price,m.ma_total_price,m.cons_price,m.ma_date from MABE3AT m,zabon b "
                + "where b.ob_id=m.ma_id and b.bill_id=" + billid + " ";
        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
        ArrayList<MABE3AT> info = new ArrayList<MABE3AT>();
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
                ben.setMa_date(rs.getDate("ma_date"));

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
   
    public String getzbonname(int id) {
        
        
        String name = "";
        String query = "select consumer_name from zabon where bill_id="+id+" ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;

        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                MOSHTARAYAT ben = new MOSHTARAYAT();
                name = rs.getString("consumer_name");


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
       
        return name;
    }
    
      public ArrayList<Integer> getobjectinfo(String oldname,String un) {
        ArrayList<Integer> ar = new ArrayList<>();
        int unitprice = 0, amount = 0, sum = 0;
        String query = "select ma_amount,ma_price,ma_total_price from MABE3AT where ma_name='" + oldname + "' and ma_unit='"+un+"' ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
       
        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                unitprice = rs.getInt("ma_price");
                amount = amount+ rs.getInt("ma_amount");
                sum = sum + rs.getInt("ma_total_price");
                
                
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
