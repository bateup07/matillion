package com.matillion.project;

import java.sql.*;

public class SecondPart {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection conn;
        Statement st;
        ResultSet rs;

        String url = "jdbc:mysql://localhost:3306/foodmart";
        String user = "root";
        String password = "Ella150815";

        try {
            conn = DriverManager.getConnection(url, user, password);
            st = conn.createStatement();
            rs = st.executeQuery("select * from employee");

            while (rs.next()) {
                System.out.println(rs.getString(2));
            }
        } catch (SQLException ex) {
            //Error message goes here
        }
    }
}