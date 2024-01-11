import java.sql.*;
import java.util.Scanner;

public class HotelManagementSystem {

    private static  final String url = "jdbc:mysql://localhost:3306/hotel_db";
    private static  final String username = "root";
    private static  final String password = "java@12345";
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Hotel \uD83C\uDFE8 Reservation System");

            while ( true ) {
                System.out.println("-----------------------------------");
                System.out.println("1. Book A Room");
                System.out.println("2. View Reservations");
                System.out.println("3. Get Room Number");
                System.out.println("4. Update Reservation");
                System.out.println("5. Delete Reservation");
                System.out.println("0. Exit");
                System.out.print("CHOOSE AN OPTION: ");
                int choice = scanner.nextInt();

                switch (choice){
                    case 1 :
                        bookRoom(connection, scanner);
                        break;
                    case 2 :
                        viewReservation(connection);
                        break;
                    case 3 :
                        getRoomNumber(connection, scanner);
                        break;
                    case 4 :
                        updateReservation(connection, scanner);
                        break;
                    case 5 :
                        deleteReservation(connection, scanner);
                        break;
                    case 0 :
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void bookRoom(Connection connection, Scanner scanner){
        System.out.print("Name: ");
        String name = scanner.next();
        scanner.nextLine();
        System.out.print("Room Number: ");
        int roomNumber = scanner.nextInt();
        System.out.print("Mobile Number: ");
        String mobileNumber = scanner.next();
        scanner.nextLine();

        String insertQuery = "INSERT INTO reservations (guest_name, room_number, contact_number) VALUES('"+name+"' , "+roomNumber+",'"+mobileNumber+"');";

        try {
            Statement statement = connection.createStatement();
            int rowInserted = statement.executeUpdate(insertQuery);
            statement.close();
            System.out.println("Room booked successfully");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void viewReservation(Connection connection){
        try {
            System.out.println("-----------------------------------");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM reservations;");
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1)+" - "+resultSet.getString(2)+" - "+resultSet.getInt(3)+" - "+resultSet.getString(4)+" - "+resultSet.getTime(5));
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void getRoomNumber(Connection connection, Scanner scanner){
        System.out.print("Reservation ID: ");
        int id = scanner.nextInt();
        System.out.print("Name: ");
        String name = scanner.next();
        scanner.nextLine();
        String query = "SELECT * FROM reservations WHERE revervation_id = "+id+";";
        try {
            System.out.println("-----------------------------------");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("Hi " + resultSet.getString(2) + " your room number is " + resultSet.getInt(3) );
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void updateReservation(Connection connection, Scanner scanner){
        System.out.print("Reservation ID: ");
        int id = scanner.nextInt();

        System.out.print("Updated Name: ");
        String name = scanner.next();
        scanner.nextLine();
        System.out.print("Updated Room Number: ");
        int roomNumber = scanner.nextInt();
        System.out.print("Updated Mobile Number: ");
        String mobileNumber = scanner.next();
        scanner.nextLine();

        String query = "UPDATE reservations "+
                "SET guest_name = '"+name+"', room_number = "+ roomNumber+ ", contact_number = '"+mobileNumber+"' "
                +"WHERE revervation_id = "+id+";";
        try{
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            if (result > 0){
                System.out.println("Updated successfully");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void deleteReservation(Connection connection, Scanner scanner){
        System.out.println("Checking Out");
        System.out.print("Enter Room Number: ");
        int roomNumber = scanner.nextInt();

        String insertQuery = String.format("DELETE FROM reservations WHERE room_number = %d", roomNumber);

        try {
            Statement statement = connection.createStatement();
            int rowInserted = statement.executeUpdate(insertQuery);
            statement.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}