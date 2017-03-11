package com.example.algorithmpoc.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.example.algorithmpoc.R;
import com.example.algorithmpoc.asynctask.CustomAsyncTask;
import com.example.algorithmpoc.asynctask.ICallback;

/**
 * Created by Cyho on 19/02/2017.
 */

public class CustomView extends LinearLayout{
    private boolean aBoolean;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.activity_main, this);

        //findViewByID
        View view = findViewById(R.id.activity_main);


        //attrs
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ActionBar);
        try {
            setBoolean(array.getBoolean(R.styleable.CustomView_isVisible, false));
        } finally {
            array.recycle();
        }
    }

    private void doStuff () {
        AsyncTask asyncTask = new CustomAsyncTask(new ICallback() {
            @Override
            public void onCallback(String result) {
                 //weee
            }
        });
        asyncTask.execute("");
    }

    public void setBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }
}
