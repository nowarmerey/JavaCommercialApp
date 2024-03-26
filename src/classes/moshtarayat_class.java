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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

/**
 *
 * @author Nowar
 */
public class moshtarayat_class {

    public static <T> ArrayList<T> uniquefy(ArrayList<T> myList) {

        ArrayList<T> uniqueArrayList = new ArrayList<T>();
        for (int i = 0; i < myList.size(); i++) {
            if (!uniqueArrayList.contains(myList.get(i))) {
                uniqueArrayList.add(myList.get(i));
            }
        }

        return uniqueArrayList;
    }

    public void addmoshtarayat(MOSHTARAYAT bn) throws SQLException {

        String query = "insert into MOSHTARAYAT (ob_name,ob_amount,unit,unit_price,total_price,jomla_price,jomla_daz,cons_price,daz_price,ob_date) values(?,?,?,?,?,?,?,?,?,?)";

        dbconnect con = new dbconnect();

        Connection Connect = con.getConnection();
        PreparedStatement st = Connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, bn.getName());

        st.setDouble(2, bn.getAmount());

        st.setString(3, bn.getUnit());
        st.setInt(4, bn.getUnit_price());
        st.setDouble(5, bn.getTotal_price());
        st.setInt(6, bn.getJomla_price());
        st.setInt(7,bn.getJomla_daz());
        st.setInt(8, bn.getCons_price());
        st.setInt(9, bn.getDz_price());
        st.setDate(10, bn.getOb_date());
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

    public ArrayList<MOSHTARAYAT> showmosh(int bill) {
        String query = "select b.ob_id,m.ob_id,m.ob_name,m.ob_amount,m.unit,m.unit_price,m.total_price,m.ob_date from MOSHTARAYAT m,bill_mo_link b "
                + "where b.ob_id=m.ob_id and bill_id=" + bill + " ";
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

    public void addlink(int id, int ob_id) throws SQLException {

        String query = "insert into bill_mo_link (bill_id,ob_id) values(?,?)";

        dbconnect con = new dbconnect();

        Connection Connect = con.getConnection();
        PreparedStatement st = Connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        st.setInt(1, id);
        st.setInt(2, ob_id);

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

    public int maxnumber() {
        int x = 0;
        String query = "SELECT MAX(ob_id) as ma from MOSHTARAYAT";
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

    public ArrayList<String> getobjectsname() {
        ArrayList<MOSHTARAYAT> info = new ArrayList<MOSHTARAYAT>();
        ArrayList<String> info1 = new ArrayList<String>();
        String name = "";
        String query = "select ob_name from MOSHTARAYAT";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;

        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                MOSHTARAYAT ben = new MOSHTARAYAT();
                name = rs.getString("ob_name");

                ben.setName(rs.getString("ob_name"));
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
        for(int i=0;i<info.size();i++){
            info1.add(info.get(i).getName());
        }
        LinkedHashSet<String> set = new LinkedHashSet<String>(info1);
        ArrayList<String> listWithoutDuplicateElements = new ArrayList<String>(set);
        
        return listWithoutDuplicateElements;
    }
    
    public ArrayList<String> getidenticalobjectsname(String x) {
        
        ArrayList<String> info1 = new ArrayList<String>();
        String name = "";
        String unit="";
        int unit_price=0;
        int jomla_price=0,jomla_daz=0,cons_price=0,daz_price=0;
        String query = "select ob_name,unit,unit_price,jomla_price,jomla_daz,cons_price,daz_price from MOSHTARAYAT where ob_name='"+x+"' ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;

        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                MOSHTARAYAT ben = new MOSHTARAYAT();
                name = rs.getString("ob_name");
                unit=rs.getString("unit");
                unit_price=rs.getInt("unit_price");
                jomla_price=rs.getInt("jomla_price");
                jomla_daz=rs.getInt("jomla_daz");
                cons_price=rs.getInt("cons_price");
                daz_price=rs.getInt("daz_price");
              

            }
            info1.add(name);
            info1.add(unit);
            info1.add(String.valueOf(unit_price));
            info1.add(String.valueOf(jomla_price));
            info1.add(String.valueOf(jomla_daz));
            info1.add(String.valueOf(cons_price));
            info1.add(String.valueOf(daz_price));
        } catch (Exception e) {

        } finally {
            try {
                Connect.close();
                statement.close();
            } catch (SQLException ex) {
                //    Logger.getLogger(tables.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
       
        
        return info1;
    }

    public ArrayList<Integer> getoldprices(String oldname) {
        ArrayList<Integer> ar = new ArrayList<>();
        int unitprice = 0, jomlaprice = 0, consprice = 0,dazprice=0,dazjomla=0;
        String query = "select unit_price,jomla_price,jomla_daz,cons_price,daz_price from MOSHTARAYAT where ob_name='" + oldname + "'  ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
     
        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                unitprice = rs.getInt("unit_price");
                jomlaprice = rs.getInt("jomla_price");
                consprice = rs.getInt("cons_price");
                dazprice=rs.getInt("daz_price");
                dazjomla=rs.getInt("jomla_daz");
            }
            ar.add(unitprice);
            ar.add(jomlaprice);
            ar.add(consprice);
            ar.add(dazprice);
            ar.add(dazjomla);
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
    public ArrayList<Integer> getoldpricesformabe3at(String oldname,String un) {
        ArrayList<Integer> ar = new ArrayList<>();
        int unitprice = 0, jomlaprice = 0, consprice = 0,dazprice=0,dazjomla=0;
        String query = "select unit_price,jomla_price,jomla_daz,cons_price,daz_price from MOSHTARAYAT where ob_name='" + oldname + "' and unit='"+un+"'  ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
     
        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                unitprice = rs.getInt("unit_price");
                jomlaprice = rs.getInt("jomla_price");
                consprice = rs.getInt("cons_price");
                dazprice=rs.getInt("daz_price");
                dazjomla=rs.getInt("jomla_daz");
            }
            ar.add(unitprice);
            ar.add(jomlaprice);
            ar.add(consprice);
            ar.add(dazprice);
            ar.add(dazjomla);
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
     public int getoldprice(String oldname,String un) {
       
        int unitprice = 0;
        String query = "select unit_price,jomla_price,cons_price,daz_price from MOSHTARAYAT where ob_name='" + oldname + "' and unit='"+un+"'  ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
     
        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                unitprice = rs.getInt("unit_price");
              
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

        return unitprice;
    }
    public ArrayList<Integer> getobjectinfo(String oldname) {
        ArrayList<Integer> ar = new ArrayList<>();
        int unitprice = 0, amount = 0, sum = 0,jomla=0,cons=0,daz_con=0,daz_jom=0;
        String query = "select unit_price,ob_amount,total_price,jomla_price,jomla_daz,cons_price,daz_price from MOSHTARAYAT where ob_name='" + oldname + "' ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
       
        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                unitprice = rs.getInt("unit_price");
                amount = amount+ rs.getInt("ob_amount");
                sum = sum + rs.getInt("total_price");
                jomla=rs.getInt("jomla_price");
                cons=rs.getInt("cons_price");
                daz_con=rs.getInt("daz_price");
                daz_jom=rs.getInt("jomla_daz");
                
            }
            ar.add(unitprice);
            ar.add(amount);
            ar.add(sum);
            ar.add(jomla);
            ar.add(cons);
            ar.add(daz_con);
            ar.add(daz_jom);
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
    public ArrayList<Integer> getobjectinfo1(String oldname,String un) {
        ArrayList<Integer> ar = new ArrayList<>();
        int unitprice = 0, amount = 0, sum = 0,jomla=0,cons=0,daz_con=0,daz_jom=0;
        String query = "select unit_price,ob_amount,total_price,jomla_price,jomla_daz,cons_price,daz_price from MOSHTARAYAT where ob_name='" + oldname + "' and unit='"+un+"' ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
       
        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                unitprice = rs.getInt("unit_price");
                amount = amount+ rs.getInt("ob_amount");
                sum = sum + rs.getInt("total_price");
                jomla=rs.getInt("jomla_price");
                cons=rs.getInt("cons_price");
                daz_con=rs.getInt("daz_price");
                daz_jom=rs.getInt("jomla_daz");
                
            }
            ar.add(unitprice);
            ar.add(amount);
            ar.add(sum);
            ar.add(jomla);
            ar.add(cons);
            ar.add(daz_con);
            ar.add(daz_jom);
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
    public Double getx(String oldname,String un) {
       
        Double unitprice = 0.0;
        String query = "select SUM(ob_amount) as su from MOSHTARAYAT where ob_name='" + oldname + "' and unit='"+un+"'  ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
     
        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                unitprice = rs.getDouble("su");
              
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

        return unitprice;
    }
    
    public Double gety(String oldname,String un) {
       
        Double unitprice = 0.0;
        String query = "select SUM(ma_amount) as su from MABE3AT where ma_name='" + oldname + "' and ma_unit='"+un+"'  ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
     
        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                unitprice = rs.getDouble("su");
              
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

        return unitprice;
    }
    
    public Double getz(String oldname,String un) {
       
        Double unitprice = 0.0;
        String query = "select SUM(obamount) as su from daily where obname='" + oldname + "' and obunit='"+un+"'  ";

        dbconnect con = new dbconnect();
        Connection Connect = con.getConnection();
        Statement statement = null;
     
        try {
            statement = Connect.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                unitprice = rs.getDouble("su");
              
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

        return unitprice;
    }
}
