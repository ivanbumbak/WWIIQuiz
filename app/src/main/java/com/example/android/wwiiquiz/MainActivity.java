package com.example.android.wwiiquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the result button is clicked.
     */
    public void result(View view) {
        // Result
        int score = 0;
        String rank = "";

        // This is first question.
        EditText wiiYear = (EditText) findViewById(R.id.wwii_year);
        if ((wiiYear.getText().toString().equals("Six")) ||
                (wiiYear.getText().toString().equals("six")) ||
                (wiiYear.getText().toString().equals("6"))) {
            score = score + 1;
        }

        // This is second question.
        CheckBox joseph = (CheckBox) findViewById(R.id.joseph);
        CheckBox hirohito = (CheckBox) findViewById(R.id.hirohito);
        CheckBox shek = (CheckBox) findViewById(R.id.shek);
        CheckBox churchill = (CheckBox) findViewById(R.id.churchill);
        if (joseph.isChecked() && shek.isChecked()
                && churchill.isChecked() && !hirohito.isChecked()) {
            score = score + 1;
        }

        // This is third question.
        CheckBox nagasaki = (CheckBox) findViewById(R.id.nagasaki);
        CheckBox tokyo = (CheckBox) findViewById(R.id.tokyo);
        CheckBox hiroshima = (CheckBox) findViewById(R.id.hiroshima);
        CheckBox osaka = (CheckBox) findViewById(R.id.osaka);
        if (nagasaki.isChecked() && hiroshima.isChecked()
                && !tokyo.isChecked() && !osaka.isChecked()) {
            score = score + 1;
        }

        // This is fourth question.
        RadioButton turing = (RadioButton) findViewById(R.id.turing);
        if (turing.isChecked()) {
            score = score + 1;
        }

        // This is fifth question.
        RadioButton neptune = (RadioButton) findViewById(R.id.neptune);
        if (neptune.isChecked()) {
            score = score + 1;
        }

        // Your rank is...
        if (score > 4) {
            rank = getString(R.string.general);
        } else if (score == 4 || score == 3) {
            rank = getString(R.string.colonel);
        } else if (score == 2 || score == 1){
            rank = getString(R.string.captain);
        } else {
            rank = getString(R.string.cadet);
        }

        Toast.makeText(this, "You scored: " + score + " points" +
                "\nYour rank is: " + rank, Toast.LENGTH_LONG).show();
    }
}

