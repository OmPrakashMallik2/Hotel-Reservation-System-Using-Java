public class HotelManagementSystem {
    public static void main(String[] args) {
        System.out.println("Hotel \uD83C\uDFE8 Reservation System");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}