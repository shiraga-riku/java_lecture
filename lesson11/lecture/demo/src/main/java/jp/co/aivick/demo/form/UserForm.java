package jp.co.aivick.demo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserForm
{
    private Integer id;

    @NotEmpty
    private String name;

    @Email
    @NotEmpty
    private String email;

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
