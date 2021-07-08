import java.util.List;


public class CarTester {
    public static void main(String[] args) {
        CarDAO dao = new CarDAO();
        List<Car> cars = dao.getAllCars();

        for (Car car: cars) {
            System.out.println(car.getId() + car.getModel() + car.getPrice());

        }

    }
}
