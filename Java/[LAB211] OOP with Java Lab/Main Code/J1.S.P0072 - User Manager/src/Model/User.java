package Model;

public class User {
    private String acc; // Account name
    private String pass; // Password
    private String name; // Full name
    private String phone; // Phone number
    private String email; // Email address
    private String address; // Home address
    private String dOB; // Date of birth

    // Constructor to initialize User object
    public User(String acc, String pass, String name, String phone, String email, String address, String dOB) {
        this.acc = acc;
        this.pass = pass;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dOB = dOB;
    }

    // Getter and setter methods for each field
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

    public String getDOB() {
        return dOB;
    }

    public void setDOB(String dOB) {
        this.dOB = dOB;
    }

}
