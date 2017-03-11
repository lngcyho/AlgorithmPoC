package com.example.algorithmpoc.gson;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.algorithmpoc.MainActivity;
import com.example.algorithmpoc.R;
import com.example.algorithmpoc.sample.SampleAction;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Cyho on 19/02/2017.
 */

public class ParseGson implements SampleAction {
    private final Context context;

    public ParseGson(Context context) {
        this.context = context;
    }

    @Override
    public void action() {
        Gson gson = new Gson();
        try {
            InputStream inputStream = context.getResources().getAssets().open("people.json");

            JsonReader reader = new JsonReader(new InputStreamReader(inputStream));
            ListOfPeople listOfPeople = gson.fromJson(reader, ListOfPeople.class);

            for (People people : listOfPeople.getPeople()) {
                Log.e(getClass().getName(), people.getFirstName() != null ? people.getFirstName() : "");
                Log.e(getClass().getName(), people.getLastName() != null ? people.getLastName() : "");
                Log.e(getClass().getName(), people.getGrade() != null ? people.getGrade() : "");
            }

            Intent intent= new Intent(context, MainActivity.class);
            intent.putExtra("BLAH", gson.toJson(listOfPeople));
            context.startActivity(intent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
