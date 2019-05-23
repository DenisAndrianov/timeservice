package components;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String pass;

    private String firstName;

    private String lastName;

    private Boolean vendorFlag;
    @OneToMany
    Set<User> vendors;
    @OneToMany
    Set<Offer> offers;
    @OneToMany
    Set<Offer> signs;


    public User(String login, String pass, String firstName, String lastName, Boolean vendorFlag) {
        this.login = login;
        this.pass = pass;
        this.firstName = firstName;
        this.lastName = lastName;
        this.vendorFlag = vendorFlag;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getVendorFlag() {
        return vendorFlag;
    }

    public void setVendorFlag(Boolean vendorFlag) {
        this.vendorFlag = vendorFlag;
    }

    public Set<User> getVendors() {
        return vendors;
    }

    public void setVendors(Set<User> vendors) {
        this.vendors = vendors;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    public Set<Offer> getSigns() {
        return signs;
    }

    public void setSigns(Set<Offer> signs) {
        this.signs = signs;
    }
}
