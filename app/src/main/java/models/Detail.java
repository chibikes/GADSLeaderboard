package models;

public class Detail {
    private String email;
    private String firstName;
    private String lastName;
    private String githubLink;

    public Detail(String email, String firstName, String lastName, String githubLink) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.githubLink = githubLink;
    }

    public Detail() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }
}
