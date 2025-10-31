package BasicCode;

import org.testng.annotations.Test;

import java.sql.*;

public class JDBC {

    private static final String URL = "jdbc:mysql://localhost:10012/local?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private Connection getConnection() throws SQLException {
        System.out.println("Attempting to connect to database...");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }


    @Test
    public void testSelectDataFromTable() {
        selectDataFromTable("select status from wp_actionscheduler_actions where action_id =15");
    }

    public String selectDataFromTable(String query) {

        String value = "";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            ResultSetMetaData rsmd = rs.getMetaData();

            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                // System.out.print(rsmd.getColumnLabel(i) + "\t");
            }

            System.out.println();
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    value = rs.getString(i);
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("SQL Error in SELECT operation: " + e.getMessage());
            e.printStackTrace();
        }
        return value;
    }

    @Test
    public void testUpdateDataInTable() {
        // Example update based on your SELECT example. Adjust as needed for your schema/data.
        String updateSql = "update wp_actionscheduler_actions set status='complete' where action_id = 15";
        int rows = updateDataInTable(updateSql);
        System.out.println("Rows affected: " + rows);
    }

    public int updateDataInTable(String updateQuery) {
        int rowsAffected = 0;
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

            rowsAffected = pstmt.executeUpdate();
            System.out.println("Update executed successfully.");
        } catch (SQLException e) {
            System.err.println("SQL Error in UPDATE operation: " + e.getMessage());
            e.printStackTrace();
        }
        return rowsAffected;
    }
}