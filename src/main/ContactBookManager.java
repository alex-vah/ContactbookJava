import com.mysql.cj.xdevapi.SqlStatement;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;


public class ContactBookManager {
    public List<Contact> _contacts = new ArrayList<>();
    public String url = "jdbc:mysql://localhost:3306/mysql";
    public String username = "root";
    public String pwd = "11111111";
    Connection connection = DriverManager.getConnection(url, username, pwd);
    private String _sql;
    public void ViewAll() throws SQLException {
        _sql="SELECT Id, Name, Email, PhoneNumber, Address from Contacts";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(_sql);
        while(rs.next())
        {
            int id = rs.getInt("Id");
            String fullName = rs.getString("Name");
            String email = rs.getString("Email");
            String phoneNumber= rs.getString("PhoneNumber");
            String address = rs.getString("Address");
            System.out.println(MessageFormat.format("Id:{0} ", id)+(new Contact(fullName, email, phoneNumber, address).toString()));
        }
    }
    public void Add(String fullName, String email, String phoneNumber, String address) throws SQLException {
        var contact = new Contact(fullName, email, phoneNumber, address);
        _contacts.add(contact);
        _sql = "INSERT INTO Contacts(Name, Email, PhoneNumber, Address)"+String.format("Values('%s', '%s', '%s', '%s')", contact._fullName, contact._email, contact._phoneNumber, contact._address);
        Statement stmt = connection.createStatement();
        stmt.execute(_sql);
    }
    public ContactBookManager() throws SQLException {

    }

}
