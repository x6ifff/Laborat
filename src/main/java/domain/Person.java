package domain;

public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Long idRole;
    private Role role;

    public Person() {
    }

    public Person(String firstName, String lastName, String phone, String email, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.role = role;
    }

    public Person(String firstName, String lastName, String phone, String email, Long idRole, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.idRole = idRole;
        this.role = role;
    }

    public Person(Long id, String firstName, String lastName, String phone, String email, Long idRole, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.idRole = idRole;
        this.role = role;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public Long getIdRole() {
        return idRole;
    }
    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public String getRoleName() {
        return (role != null) ? role.getNamerole() : "";
    }

    @Override
    public String toString() {
        return "Person {" + "Id = " + id +
            ", firstName = " + firstName +
            ", lastName = " + lastName +
            ", phone = " + phone +
            ", email = " + email +
            ", idRole = " + idRole +
            ", roleName = " + getRoleName() +
            "}";
    }
}