package entity;

public class Client extends  Person{

    private String email;
    private String address;

    public Client() {
    }

    public Client( String fname, String lname, String email, String address) {
        super( fname, lname);
        this.email = email;
        this.address = address;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
