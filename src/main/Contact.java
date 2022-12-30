import java.text.MessageFormat;

public class Contact {
    public Contact(String fullName, String email, String phoneNumber, String address)
    {
        _fullName=fullName;
        _email=email;
        _phoneNumber=phoneNumber;
        _address=address;
    }
    public String _fullName;
    public String _email;
    public String _phoneNumber;
    public String _address;

    @Override
    public String toString() {
        return MessageFormat.format("Full Name: {0}, Phone Number: {1}, Email: {2}, Address: {3}", _fullName, _phoneNumber, _email, _address);
    }
}
