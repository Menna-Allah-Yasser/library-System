package entity;

public class User extends  Person {

    private String pass;

    public User() {
    }
    public User( String fname, String lname, String pass) {
        super(fname, lname);
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
