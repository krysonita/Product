package com.rupp;
import java.sql.*;
public class ConnectionDB {
        public static void main(String[] args) {
            final String URL = "jdbc:postgresql://localhost:5432/java_sr_db";
            final String USER = "postgres";
            final String PW ="2003";
            Connection con= null;

            try {
                Class.forName("org.postgresql.Driver"); //driver local machine
                con = DriverManager.getConnection(URL,USER,PW); // connect to db

                Statement stm = con.createStatement(); //db execute statement
//            stm.execute("CREATE TABLE emp_tb(id serial,name varchar(30),salary float)"); // create table
//            stm.execute("ALTER TABLE emp_tb ADD COLUMN bonus float"); // add column to table emp_tb
//            stm.executeUpdate("INSERT INTO emp_tb(name,salary,bonus) VALUES ('Jing',390,100)"); //insert to db
//            stm.executeUpdate("UPDATE emp_tb SET salary = 3000 WHERE id=3"); // update
//            stm.executeUpdate("DELETE FROM emp_tb WHERE id>3"); // delete

                try { // if it error data store in RAM
                    con.setAutoCommit(false); // if false it not commit to db
                    stm.executeUpdate("UPDATE emp_tb SET salary=200 WHERE id=1");
                    System.out.println(1/0); //error
                    stm.executeUpdate("UPDATE emp_tb SET salary=300 where id=2");
                    con.commit(); //if true it commit to db
                }catch (Exception e){
                    con.rollback(); //so use this to clear data in RAM
                }



                ResultSet rs = stm.executeQuery("Select * FROM emp_tb"); // Query data from db store in ResultSet
                // loop element from db
                while (rs.next()){ // if it rs has element return true else return false
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    double salary = rs.getFloat("salary");
                    double bonus = rs.getFloat("bonus");

                    System.out.println(id+"  "+name+"  "+salary+"  "+bonus);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    con.close(); // to close connect db
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
