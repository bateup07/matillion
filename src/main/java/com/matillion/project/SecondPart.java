package com.matillion.project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SecondPart {

    //Redundant due to Java Menu being implemented
    //private static final String DEPT_DESC = "Temp Stockers";
    //private static final String PAY_TYPE = "Hourly";
    //private static final String EDUCATION_LEVEL = "Graduate Degree";

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

            //User input
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your department description");
            String dept = scanner.nextLine();

            //load department values
            List<String> deptValues = new ArrayList<String>();
            String[] deptValuesS = new String[] {"HQ General Management","HQ Information Systems","HQ Marketing",
                    "HQ Human Resources","HQ Finance and Accounting","Store Management",
                    "Store Information Systems","Permanent Checkers","Temp Checkers",
                    "Permanent Stockers","Temp Stockers","Store Permanent Butchers"};

            for (int i = 0; i < deptValuesS.length;i++) {
                if (deptValuesS[i].equalsIgnoreCase(dept)) {
                    System.out.println("Matched. Please go to the next step");
                } else {
                    System.out.println("Nothing matched");
                }
            }

            //user selects valid department value

            //load pay type values
            //user selects valid department value

            //load education values
            //user selects valid education value


            System.out.println("Enter your pay type");
            String pay_type = scanner.nextLine();

            System.out.println("Enter your education level");
            String education_level = scanner.nextLine();

            pst.setString(1, dept);
            pst.setString(2, pay_type);
            pst.setString(3, education_level);

            rs = pst.executeQuery();

            while (rs.next()) {
                String full_name = rs.getString("full_name");
                String birth_date = rs.getString("birth_date");
                String hire_date = rs.getString("hire_date");
                String gender = rs.getString("gender");
                System.out.println(full_name + " " + birth_date + " " + hire_date + " " + gender);
            }

            rs.close();
            pst.close();
            conn.close();

        } catch (SQLException ex) {
            //Error message goes here
            ex.printStackTrace();
        }
    }
}