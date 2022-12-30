import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        ContactBookManager manager = new ContactBookManager();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the operation you want to do:");
        String op = scanner.nextLine();
        switch (op){
            case "add":
                System.out.println("enter the details of your contact");
                String fullName=scanner.nextLine();
                String email = scanner.nextLine();
                String phoneNumber=scanner.nextLine();
                String address = scanner.nextLine();
                manager.Add(fullName, email, phoneNumber, address);
                break;
            case "view all":
                manager.ViewAll();
                break;
            default:
                System.out.println("invalid operation");
        }
    }
}
