package com.rupp;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Statement {
        static List<Product> lst = new ArrayList<>();
        public static void main(String[] args) throws Exception {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter product name   : ");
            String name = scanner.nextLine();
            System.out.print("Enter product price : ");
            Double price_per_unit = scanner.nextDouble();
            System.out.print("Enter active  : ");
            Boolean active_for_sell = scanner.nextBoolean();
            //insert
            insert(name,price_per_unit,active_for_sell);
            //get
            get();




        }
        public static Connection conToDb() throws Exception{
            final String URL = "jdbc:postgresql://localhost:5432/java_rupp";
            final String USER = "postgres";
            final String PW = "2003";
            Connection con = DriverManager.getConnection(URL,USER,PW);
            return con;
        }
        public static void insert(String name,Double price_per_unit,Boolean active_for_sell) throws Exception{
            Connection con = conToDb();
            //Pre compile
            PreparedStatement ps = con.prepareStatement("INSERT INTO product(name,price_per_unit,active_for_sell ) VALUES (?,?,?)");
            ps.setString(1,name);
            ps.setDouble(2,price_per_unit);
            ps.setBoolean(3,active_for_sell);
            ps.execute();  // execute PreparedStatement
            con.close();
        }
        public static void get() throws Exception{
            Connection con = conToDb();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT *FROM product");
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Double price_per_unit = rs.getDouble("price_per_unit");
                Boolean active_for_sell = rs.getBoolean("active_for_sell");

                lst.add(new Product(id,name,price_per_unit,active_for_sell));
            }
            for(Product em : lst){
                System.out.println(em.getId() + " "+em.getName()+" "+em.getPrice_per_unit()+" "+ em.getActive_for_sell());
            }
            con.close();

        }

    }
