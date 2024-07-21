package com.example.p6_intentexplicit;

import static com.example.p6_intentexplicit.R.id.btn_dial_number;
import static com.example.p6_intentexplicit.R.id.btn_move_activity;
import static com.example.p6_intentexplicit.R.id.btn_move_activity_data;
import static com.example.p6_intentexplicit.R.id.btn_move_activity_object;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnMoveActivity;
    private Button btnMoveActivityData;
    private Button btnMoveWithObject;
    private Button btnDialPhone;
    private Button btnMoveForResult;
    private TextView tvResult;
    private int REQUEST_CODE = 100;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = (Button)findViewById(btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        btnMoveActivityData = findViewById(btn_move_activity_data);
        btnMoveActivityData.setOnClickListener(this);

        btnDialPhone = findViewById(btn_dial_number);
        btnDialPhone.setOnClickListener(this);

        btnMoveWithObject = (Button)findViewById(R.id.btn_move_activity_object);
        btnMoveWithObject.setOnClickListener(this);

        btnMoveForResult = (Button)findViewById(R.id.btn_move_for_result);
        btnMoveForResult.setOnClickListener(this);

        tvResult = (TextView) findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View v){
        int id = v.getId();

        if (id == R.id.btn_move_activity){
            Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
            startActivity(moveIntent);
        } else if (id == R.id.btn_move_activity_data) {
            Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Vinessa Gabby Asyfa");
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 20);
            startActivity(moveWithDataIntent);
        } else if (id == btn_dial_number) {
            String phoneNumber = "085774710803";
            Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
            startActivity(dialPhoneIntent);
        } else if (id == btn_move_activity_object) {
            Person mPerson = new Person();
            mPerson.setName("DicodingAcademy");
            mPerson.setAge(5);
            mPerson.setEmail("academy@dicoding.com");
            mPerson.setCity("Bandung");

            Intent moveWtihObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
            moveWtihObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, mPerson);
            startActivity(moveWtihObjectIntent);
        } else if (id == R.id.btn_move_for_result) {
            Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResultActivity.class);
            startActivityForResult(moveForResultIntent, REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       super.onActivityResult(resultCode, resultCode, data);
       if (requestCode == REQUEST_CODE) {
           if (resultCode == MoveForResultActivity.RESULT_CODE) {
               int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
               tvResult.setText("Hasil : " +selectedValue);
           }
       }
    }
}