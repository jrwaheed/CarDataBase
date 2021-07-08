//Data Access Object

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {

    public void addCar(Car car) {
        try {
            Connection con = getDBConnection();
            Statement stmt = con.createStatement();
            String sql = "insert into cars (model, price) values ('" + car.getModel() + "'," + car.getPrice() + ")";
            boolean result = stmt.execute(sql);
            con.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();

        try {
            Connection con = getDBConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from cars");
            while (rs.next()) {
                Car c = new Car(rs.getInt(1), rs.getString(2), rs.getInt(3));
                cars.add(c);
            }//    System.out.println(rs.getInt(1) + "\t " + rs.getString(2) + "\t " + rs.getInt(3));
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }


    private Connection getDBConnection() {
        try {
            // MAY NEED TO DOWNLOAD THE DRIVER
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/CarDataBase", "root", "TheHulk1*");

            return con;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}

