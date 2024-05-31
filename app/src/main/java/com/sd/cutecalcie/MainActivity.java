package com.sd.cutecalcie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etFirstValue, etSecondValue;
    TextView tvAns;
    Button add, subtract, multiply, divide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstValue = findViewById(R.id.etFirstValue);
        etSecondValue = findViewById(R.id.etSecondValue);
        tvAns = findViewById(R.id.tvAns);
        add = findViewById(R.id.btnAdd);
        subtract = findViewById(R.id.btnSubtract);
        multiply = findViewById(R.id.btnMultiply);
        divide = findViewById(R.id.btnDivide);

        add.setOnClickListener(v -> {
            if(validateInput()) {
                float firstValue, secondValue, ans;

                firstValue = Float.parseFloat(etFirstValue.getText().toString());
                secondValue = Float.parseFloat(etSecondValue.getText().toString());
                ans = firstValue + secondValue;
                tvAns.setText(String.valueOf(ans));
            }

        });

        subtract.setOnClickListener(v -> {
            if(validateInput()) {
                float firstValue, secondValue, ans;

                firstValue = Float.parseFloat(etFirstValue.getText().toString());
                secondValue = Float.parseFloat(etSecondValue.getText().toString());
                ans = firstValue - secondValue;

                tvAns.setText(String.valueOf(ans));
            }
        });

        multiply.setOnClickListener(v -> {
            if(validateInput()) {
                float firstValue, secondValue, ans;

                firstValue = Float.parseFloat(etFirstValue.getText().toString());
                secondValue = Float.parseFloat(etSecondValue.getText().toString());
                ans = firstValue * secondValue;

                tvAns.setText(String.valueOf(ans));
            }
        });

        divide.setOnClickListener(v -> {
            if (validateInput()) {
                float firstValue = Float.parseFloat(etFirstValue.getText().toString());
                float secondValue = Float.parseFloat(etSecondValue.getText().toString());
                if (secondValue != 0) {
                    float ans = firstValue / secondValue;
                    tvAns.setText(String.valueOf(ans));
                } else {
                    Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public boolean validateInput() {
        boolean isValid = true;

        if (etFirstValue.getText().toString().isEmpty()) {
            etFirstValue.setError("This field is required");
            isValid = false;
        }

        if (etSecondValue.getText().toString().isEmpty()) {
            etSecondValue.setError("This field is required");
            isValid = false;
        }

        return isValid;
    }
}