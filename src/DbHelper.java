import java.sql.*;

public class DbHelper {


    private String userName="";
    private String Password="";
    private String dbUrl="";

    public Connection getConnection() throws SQLException{
        return  DriverManager.getConnection(dbUrl,userName,Password);
    }

    public void showErrorMessage(SQLException exception){

        System.out.println("Error : " + exception.getMessage());
        System.out.println("Error code : " + exception.getErrorCode());
    }
}
