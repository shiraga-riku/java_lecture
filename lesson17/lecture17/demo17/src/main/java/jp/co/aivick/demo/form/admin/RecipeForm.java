package jp.co.aivick.demo.form.admin;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class RecipeForm
{
    @NotEmpty
    private String name;

    @NotNull
    @Positive
    private Double cal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCal() {
        return cal;
    }

    public void setCal(Double cal) {
        this.cal = cal;
    }
}
