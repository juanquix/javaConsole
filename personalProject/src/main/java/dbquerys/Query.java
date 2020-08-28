package dbquerys;

import java.sql.*;

public class Query {
    public static void main(String[] args) throws SQLException {
        //Connection co= DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
        //  String url = "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false";
        String dbUrl = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
        String user = "root";
        String  password = "Fundacion-2020";
        try {                                              //url
            Connection myConn = DriverManager.getConnection(dbUrl, user, password);
            //  Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "Fundacion-2020");
            Statement myStmt = myConn.createStatement();
            String sql = "select * from mydb.Contacts";
            ResultSet rs = myStmt.executeQuery(sql); //myStmt.execute(sql);

            while(rs.next()){
                System.out.println(rs.getString("name"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
