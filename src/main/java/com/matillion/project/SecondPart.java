package com.matillion.project;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class SecondPart {

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

            Scanner scanner = new Scanner(System.in);

            //User input for department description
            Scanner firstOption = new Scanner(System.in);
            System.out.println("Enter your department description:");
            String dept = firstOption.nextLine();

            //load department values
            String[] deptValuesS = new String[] {"HQ General Management","HQ Information Systems","HQ Marketing",
                    "HQ Human Resources","HQ Finance and Accounting","Store Management",
                    "Store Information Systems","Permanent Checkers","Temp Checkers",
                    "Permanent Stockers","Temp Stockers","Store Permanent Butchers"};

            while (!Arrays.asList(deptValuesS).contains(dept)) {
                System.out.println("Please re-enter your department description");
                dept = scanner.nextLine();
            }

            //User input for pay type
            Scanner secondOption = new Scanner(System.in);
            System.out.println("Enter your pay type:");
            String pay_type = secondOption.nextLine();

            while (!pay_type.equalsIgnoreCase("Hourly") &&
                    !pay_type.equalsIgnoreCase("Monthly")) {
                System.out.println("Please choose either Hourly or Monthly");
                pay_type = scanner.nextLine();
            }

            //User input for education level
            Scanner thirdOption = new Scanner(System.in);
            System.out.println("Enter your education level");
            String education_level = thirdOption.nextLine();

            while (!education_level.equalsIgnoreCase("Graduate Degree") &&
                    !education_level.equalsIgnoreCase("Bachelors Degree") &&
                    !education_level.equalsIgnoreCase("Partial College") &&
                    !education_level.equalsIgnoreCase("High School Degree") &&
                    !education_level.equalsIgnoreCase("Partial High School")) {
                System.out.println("Please re-enter education level");
                education_level = scanner.nextLine();
            }

            pst.setString(1, dept);
            pst.setString(2, pay_type);
            pst.setString(3, education_level);

            rs = pst.executeQuery();

            if (rs.next() == false) {
                System.out.println("No data available");
            } else {
                while (rs.next()) {
                    String full_name = rs.getString("full_name");
                    String birth_date = rs.getString("birth_date");
                    String hire_date = rs.getString("hire_date");
                    String gender = rs.getString("gender");
                    System.out.println(full_name + " " + birth_date + " " + hire_date + " " + gender);
                }
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