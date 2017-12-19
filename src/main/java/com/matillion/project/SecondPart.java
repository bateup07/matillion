package com.matillion.project;

import java.sql.*;

public class SecondPart {

    private static final String DEPT_DESC = "Temp Stockers";
    private static final String PAY_TYPE = "Hourly";
    private static final String EDUCATION_LEVEL = "Graduate Degree";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection conn;
        PreparedStatement pst;
        ResultSet rs;

        String url = "jdbc:mysql://localhost:3306/foodmart";
        String user = "root";
        String password = "Ella150815";

        try {
            conn = DriverManager.getConnection(url, user, password);

            String sql = "SELECT full_name, birth_date, hire_date, gender ";
            sql += "FROM employee ";
            sql += "WHERE department_id = (SELECT d.department_id FROM department d WHERE d.department_description = ?) ";
            sql += "AND position_id IN (SELECT position_id FROM position where pay_type = ?) ";
            sql += "AND education_level = ? ";
            sql += "ORDER BY full_name ASC;";

            pst = conn.prepareStatement(sql);
            pst.setString(1, DEPT_DESC);
            pst.setString(2, PAY_TYPE);
            pst.setString(3, EDUCATION_LEVEL);

            rs = pst.executeQuery();

            while (rs.next()) {
                String full_name = rs.getString("full_name");
                String birth_date = rs.getString("birth_date");
                String hire_date = rs.getString("hire_date");
                String gender = rs.getString("gender");
                System.out.println(full_name + " " + birth_date + " " + hire_date + " " + gender);
            }

        } catch (SQLException ex) {
            //Error message goes here
            ex.printStackTrace();
        }
    }
}