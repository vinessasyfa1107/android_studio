package com.example.p6_intentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MoveForResultActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnChoose;
    private RadioGroup rgNumber;
    public static String EXTRA_SELECTED_VALUE = "extra_selected_value";
    public static int RESULT_CODE = 110;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_for_result);

        btnChoose = (Button) findViewById(R.id.btn_choose);
        btnChoose.setOnClickListener(this);
        rgNumber = (RadioGroup) findViewById(R.id.rg_number);
    }

    @Override
    public void onClick(View v) {
        int num = rgNumber.getCheckedRadioButtonId();
        if (v.getId() == R.id.btn_choose) {
            if (num != 0){
                int value = 0;
                if (num == R.id.rb_50) {
                    value = 50;
                } else if (num == R.id.rb_100) {
                    value = 100;
                } else if (num == R.id.rb_150) {
                    value = 150;
                } else if (num == R.id.rb_200) {
                    value = 200;
                }
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value);
                setResult(RESULT_CODE, resultIntent);
                finish();
            }
        }
    }
}