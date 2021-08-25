package com.example.projectforsimon;

import static android.content.SharedPreferences.*;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class ActivityEnterData extends Activity {
    EditText whoText, whatText;
    Button btnSave, btnShow;
    SharedPreferences sharedPreferences;
    String strFirstName, strLastName;

    public static final String APP_PREFERENCES = "mydata";
    public static final String APP_PREFERENCES_FIRST_NAME = "first name";
    public static final String APP_PREFERENCES_LAST_NAME = "last name";

    final String SAVED_TEXT = "saved_text";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_data);

        init();

    }


    public void showText(View view) {
        Intent intent = new Intent(this, ActivityShowData.class);
        startActivity(intent);
    }

    public void saveText(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(APP_PREFERENCES,whoText.getText().toString() + " " + whatText.getText().toString());
        editor.apply();

    }

    private void init(){
        sharedPreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        whoText = (EditText) findViewById(R.id.who_edit_text);
        whatText = (EditText) findViewById(R.id.what_edit_text);
    }


}
