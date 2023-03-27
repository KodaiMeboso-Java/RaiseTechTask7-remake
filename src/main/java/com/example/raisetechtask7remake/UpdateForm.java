package com.example.raisetechtask7remake;

import jakarta.validation.constraints.NotBlank;

public class UpdateForm {
    @NotBlank(message = "名前を入力してください")

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
