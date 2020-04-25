package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText weight,height_feet,height_inch;
    TextView resultText;
    String calculation,BMIResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height_feet = findViewById(R.id.height_feet); //stores entered height value into variable
        height_inch = findViewById(R.id.height_inch); //stores entered height value into variable
        weight = findViewById(R.id.weight); //stores entered weight value into variable
        resultText = findViewById(R.id.resultText);
    }

    public void ButtonBMI(View view) {
        String s1 = height_feet.getText().toString();
        String s3 = height_inch.getText().toString();
        String s2 = weight.getText().toString();

        float height_feetValue = Float.parseFloat(s1) * 0.3048f; //converting feet to m
        float height_inchValue = Float.parseFloat(s3) * 0.0254f; //converting inch to m
        float sum = (height_feetValue + height_inchValue) ;
        float weightValue = Float.parseFloat(s2);

        float bmi = weightValue/ (sum*sum);

            if(bmi < 15.0)BMIResult = "Very severely underweight. It's high time you monitor your eating habits to gain a few kilos!";
            else if (bmi >= 15.0 && bmi <=16)BMIResult = "Severely underweight. You should have a nutritious diet to gain a few kilos!!";
            else if(bmi >= 16.0 && bmi <=18.5)BMIResult = "Underweight. Try gaining a few kilos!";
            else if(bmi >= 18.5 && bmi <=25)BMIResult = "Normal (Healthy weight). You're perfect, keep it up!";
            else if(bmi >= 25 && bmi <=30)BMIResult = "Overweight. You should consider exercising daily.";
            else if(bmi >= 30 && bmi <=35)BMIResult = "Obese Class 1(Moderately obese). You should monitor what you eat and follow a daily workout regime.";
            else if(bmi >= 35 && bmi <=40)BMIResult = "Obese Class 2(Severely obese). It's high time you start monitoring your diet and workout.";
            else BMIResult = "Obese Class 3(Very severely obese). Stop whatever you're doing and go consult a Doctor!";

            calculation = ("Result: \n"+bmi+"\n"+BMIResult);
            resultText.setText(calculation);
    }
}
