public class User {
    private String name;
    private String firstname;
    private String login;
    private String password;
    private Role role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLogin() {
        return login;
    }

    public User(String name, String firstname, String login, String password, Role role) {
        this.name = name;
        this.firstname = firstname;
        this.login = login;
        this.password = password;
        this.role = role;
    }
}
