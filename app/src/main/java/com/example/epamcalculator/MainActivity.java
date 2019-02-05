package com.example.epamcalculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textResult;
    private String sign, digits, result;
    private double firstValue, secondValue, equalValue;
    private boolean haveFirst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textResult = (TextView)findViewById(R.id.text_result);
        digits = "";
        sign = "";
        result = getString(R.string.standard_calc_value);
        firstValue = 0;
        secondValue = 0;
        haveFirst = false;
    }

    public void onDigitClick(View view){
        if(textResult.getText().length() <= 8) {
            Button button = (Button) view;
            digits += button.getText().toString();
            textResult.setText(digits);

        }

    }

    public void OnSignClick(View view){
        Button button = (Button) view;

        if (haveFirst){
            calculate(view);
            sign = button.getText().toString();
            return;
        }
        sign = button.getText().toString();
        firstValue = Double.parseDouble(textResult.getText().toString());
//        textResult.setText(getString(R.string.standard_calc_value));
        digits = "";
        haveFirst = true;

    }

    public void calculate(View view){
        Button button = (Button) view;
//      secondValue = Double.parseDouble(textResult.getText().toString());

        try {
            equalValue = Double.parseDouble(digits);
        }catch (Exception e){
            equalValue = secondValue;
        }
        secondValue = equalValue;
        switch (sign) {
            case "+":
                result = String.valueOf(firstValue + secondValue);
                break;
            case "-":
                result = String.valueOf(firstValue - secondValue);
                break;
            case "x":
                result = String.valueOf(firstValue * secondValue );
                break;
            case "÷":
                result = String.valueOf(firstValue / secondValue);
                break;
            case "%":
                result = String.valueOf(secondValue / 100 * firstValue);
                break;
            default:
                result = String.valueOf(firstValue);
                break;

        }
        textResult.setText(result);
        digits = "";
        firstValue = Double.parseDouble(result);
        haveFirst = false;
    }

    public void onACClick(View view){
        textResult.setText(getString(R.string.standard_calc_value));
        digits = "";
        sign = "";
        firstValue = 0;
        secondValue = 0;
        haveFirst = false;
    }

    public void onCClick(View view){

        if(digits.length() > 1) {
            digits = digits.substring(0, digits.length() - 1);
            textResult.setText(digits);
        }
        else {
            textResult.setText(getString(R.string.standard_calc_value));
        }


    }

    public void onPlusMinusClick(View view){
        if(!digits.equals("")) {
            digits = String.valueOf(Double.parseDouble(digits) * -1);
            textResult.setText(digits);
        }

    }


}
