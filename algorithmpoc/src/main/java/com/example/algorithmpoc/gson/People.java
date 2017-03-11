package com.example.algorithmpoc.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cyho on 19/02/2017.
 */

public class People {
    @SerializedName("lastName")
    private String firstName;
    @SerializedName("firstName")
    private String lastName;

    private String grade;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGrade() {
        return grade;
    }
}
