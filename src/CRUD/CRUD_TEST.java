package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CRUD_TEST {

    public static void main(String[] args) {

        CRUD_TEST objTest = new CRUD_TEST();

        // Uncomment ONE method at a time while testing

        // CREATE
        // objTest.create_data("1", "jinu", "jinu@gmail.com");

        // READ ALL
        objTest.read_data();

        // READ ONE
        // objTest.edit_data("1");

        // UPDATE
        // objTest.update_data("1", "11", "jinu_updated", "jinu@gmail.com");

        // DELETE
        // objTest.delete_data("1");

        // ALTER TABLE
        // objTest.alter_table();

        // TRUNCATE TABLE
        // objTest.truncate_data();
    }

    // CREATE
    public void create_data(String sl_no, String name, String email) {

        DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();

        try {
            String query = "insert into user(sl_no,name,email) values (?,?,?)";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, sl_no);
            ps.setString(2, name);
            ps.setString(3, email);

            System.out.println(ps);

            ps.executeUpdate();

            System.out.println("Record inserted successfully.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // READ ALL
    public void read_data() {

        DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();

        try {
            String query = "select * from user";

            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Sl no - " + rs.getString("sl_no"));
                System.out.println("Name  - " + rs.getString("name"));
                System.out.println("Email - " + rs.getString("email"));
                System.out.println("--------------------");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // READ ONE RECORD
    public void edit_data(String sl_no) {

        DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();

        try {
            String query = "select * from user where sl_no=?";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, sl_no);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Sl no - " + rs.getString("sl_no"));
                System.out.println("Name  - " + rs.getString("name"));
                System.out.println("Email - " + rs.getString("email"));
                System.out.println("--------------------");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // UPDATE
    public void update_data(String sl_no, String new_sl_no, String name, String email) {

        DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();

        try {
            String query = "update user set sl_no=?, name=?, email=? where sl_no=?";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, new_sl_no);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, sl_no);

            System.out.println(ps);

            ps.executeUpdate();

            System.out.println("Record updated successfully.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // DELETE
    public void delete_data(String sl_no) {

        DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();

        try {
            String query = "delete from user where sl_no=?";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, sl_no);

            System.out.println(ps);

            ps.executeUpdate();

            System.out.println("Record deleted successfully.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // TRUNCATE TABLE
    public void truncate_data() {

        DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();

        try {
            String query = "truncate table user";

            PreparedStatement ps = connection.prepareStatement(query);

            System.out.println(ps);

            ps.executeUpdate();

            System.out.println("All records deleted successfully.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // ALTER TABLE
    public void alter_table() {

        DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();

        try {
            String query = "alter table user add address varchar(20)";

            PreparedStatement ps = connection.prepareStatement(query);

            System.out.println(ps);

            ps.executeUpdate();

            System.out.println("Column added successfully.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}