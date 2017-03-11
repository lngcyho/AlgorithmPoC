package com.example.algorithmpoc.gson;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Cyho on 19/02/2017.
 */

public class ListOfPeople {
    @SerializedName("people")
    private List<People> alola;

    public List<People> getPeople() {
        return alola;
    }
}
