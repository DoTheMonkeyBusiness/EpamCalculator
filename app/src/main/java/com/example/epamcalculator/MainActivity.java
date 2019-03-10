package com.example.epamcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String EQUAL = "=";
    private static final String POINT = ".";
    private static final String EMPTY_LINE = "";

    private TextView textResultView;

    private int sign;

    private String digits = EMPTY_LINE;
    private String result;

    private double firstValue;
    private double secondValue;

    private boolean haveFirst = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResultView = findViewById(R.id.activity_main_result_textView);
        result = getString(R.string.standard_calc_value);
    }

    public void onDigitClick(View view) {
        Button button = (Button) view;

        if (!(digits.length() > 8
                || (button.getText().toString().equals(POINT)
                                    && digits.contains(POINT)))) {
            if (digits.length() == 0 && button.getText().toString().equals(POINT)) {
                digits += "0.";
            } else {
                digits += button.getText().toString();
            }
            textResultView.setText(digits);
        }
    }

    public void onSignClick(View view) {
        Button button = (Button) view;

        if (haveFirst) {
            calculate(view);
            sign = button.getId();
            return;
        }

        sign = button.getId();
        firstValue = Double.parseDouble(textResultView.getText().toString());
        digits = EMPTY_LINE;
        haveFirst = true;
    }

    public void calculate(View view) {
        Button button = (Button) view;
        double equalValue;

        if (!digits.equals(EMPTY_LINE)) {
            equalValue = Double.parseDouble(digits);
        } else {
            equalValue = secondValue;
        }

        secondValue = equalValue;
        switch (sign) {
            case R.id.activity_main_plus_button:
                result = Math.sum(firstValue, secondValue);

                break;
            case R.id.activity_main_minus_button:
                result = Math.subtraction(firstValue, secondValue);

                break;
            case R.id.activity_main_multiply_button:
                result = Math.multiplication(firstValue, secondValue);

                break;
            case R.id.activity_main_division_button:
                result = Math.division(firstValue, secondValue);

                break;
            case R.id.activity_main_percent_button:
                result = Math.percentage(firstValue, secondValue);

                break;
            default:
                result = String.valueOf(firstValue);

                break;
        }

        if (button.getText().toString().equals(EQUAL)) {
            haveFirst = false;
        }

        textResultView.setText(result);
        digits = EMPTY_LINE;
        firstValue = Double.parseDouble(result);
    }

    public void onACClick(View view) {
        textResultView.setText(getString(R.string.standard_calc_value));
        digits = EMPTY_LINE;
        sign = 0;
        firstValue = 0;
        secondValue = 0;
        haveFirst = false;
    }

    public void onCClick(View view) {
        if (digits.length() > 1) {
            digits = digits.substring(0, digits.length() - 1);
            textResultView.setText(digits);
        } else {
            textResultView.setText(getString(R.string.standard_calc_value));
        }
    }

    public void onPlusMinusClick(View view) {
        if (!digits.equals(EMPTY_LINE)) {
            digits = String.valueOf(Double.parseDouble(digits) * -1);
            textResultView.setText(digits);
        }
    }
}
