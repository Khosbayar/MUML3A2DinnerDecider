package com.android.khosbayar.muml3a2dinnerdecider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText mNewFood;
    private TextView mDinner;
    private ArrayList<String> dinners;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dinners = new ArrayList<>();

        dinners.add("Hamburger");
        dinners.add("Pizza");
        dinners.add("Mexican");
        dinners.add("American");
        dinners.add("Chinese");

        mDinner = findViewById(R.id.tvDinner);
        mNewFood = findViewById(R.id.etNewFood);

    }

    public void clickOperation(View view) {
        switch (view.getId()) {
            case R.id.bDecide:
                Random random = new Random();
                int chosenOne = random.nextInt(dinners.size());
                mDinner.setText(dinners.get(chosenOne));
                break;
            case R.id.bAdd:
                String newFood = mNewFood.getText().toString();
                if (!newFood.equals("")) {
                    dinners.add(newFood);
                    Toast.makeText(this, "Added " + newFood, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                Toast.makeText(this, "No way!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
