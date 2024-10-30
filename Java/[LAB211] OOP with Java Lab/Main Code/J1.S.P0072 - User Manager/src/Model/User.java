package Model;

public class User {

    // User attributes to store account details
    private String acc;
    private String pass;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String dOB;

    public User() {
    }

    // Constructor for creating a new user with all attributes
    public User(String acc, String pass, String name, String phone, String email, String address, String dOB) {
        this.acc = acc;
        this.pass = pass;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dOB = dOB;
    }

    // Getters and setters for each attribute to allow access and modification
    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getdOB() {
        return dOB;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }
}
