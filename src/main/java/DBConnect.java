import java.sql.*;

public class DBConnect {
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection connection= DriverManager.getConnection( "jdbc:mysql://localhost:3306/dbconnect",  "root", "");

            Statement statement= connection.createStatement();

            ResultSet resultSet= statement.executeQuery("select * from students");

            while (resultSet.next()){
                System.out.println(resultSet.getInt(1) + " "+ resultSet.getString( 2)+ " "+ (resultSet.getString( 3)));
            }

            connection.close();


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
