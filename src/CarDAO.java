//Data Access Object

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {

    public void addCar(Car car){
        
    }

    public List<Car> getAllCars(){
        List<Car> cars = new ArrayList<>();

        try{

            // MAY NEED TO DOWNLOAD THE DRIVER:

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.56.101:3306/Cars", "jamal", "Jamal123*");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from cars");
            while (rs.next()) {
                Car c = new Car(rs.getInt(1), rs.getString(2), rs.getInt(3));
                cars.add(c);
            }    //System.out.println(rs.getInt(1) + "\t " + rs.getString(2) + "\t " + rs.getInt(3));
                con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


        return cars;

    }

}
