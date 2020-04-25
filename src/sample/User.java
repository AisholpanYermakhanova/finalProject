package sample;

public class User {
    private String name;
    private String login;
    private String password;
    private String question;
    private String answer;

    public User(String name, String login, String password, String question, String answer) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.question = question;
        this.answer = answer;
    }

    public User() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
