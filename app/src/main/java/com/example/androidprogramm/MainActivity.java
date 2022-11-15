package com.example.androidprogramm;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextA;
    private EditText editTextB;
    private EditText editTextC;
    private TextView textViewX1;
    private TextView textViewX2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextA = findViewById(R.id.edit_text_a);
        editTextB = findViewById(R.id.edit_text_b);
        editTextC = findViewById(R.id.edit_text_c);
        textViewX1 = findViewById(R.id.text_view_x1);
        textViewX2 = findViewById(R.id.text_view_x2);
    }

    private double getDoubleValue(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Поля не могут быть пустыми", Toast.LENGTH_SHORT).show();
            return 0;
        }
        return Double.parseDouble(editText.getText().toString());
    }


    public void click(View view) {
        double a = getDoubleValue(editTextA);
        double b = getDoubleValue(editTextB);
        double c = getDoubleValue(editTextC);
        double D = b*b-4*a*c;
        double x1, x2;
        if (D==0){
             x1 = -b/(2*a);
            textViewX1.setText(String.format("%.2f", x1));
            textViewX2.setText( String.format(""));
            Toast.makeText(this, x1 + "", Toast.LENGTH_SHORT).show();
        }
        if (D<0){
            x1=0;
            textViewX1.setText( String.format("Корней нет"));
            textViewX2.setText( String.format(""));
            Toast.makeText(this, "Корней нет", Toast.LENGTH_SHORT).show();


        }
        if(D>0){
            x1 = (-b - Math.sqrt(D)) / (2 * a);
            x2 = (-b + Math.sqrt(D)) / (2 * a);
            textViewX1.setText( String.format("%.2f", x1));
            textViewX2.setText( String.format("%.2f", x2));
            Toast.makeText(this,  x1 +" "+ x2, Toast.LENGTH_SHORT).show();

        }
        if (a==0){
            textViewX1.setText( String.format("Ты по моему перепутал"));
            textViewX2.setText( String.format(""));
            Toast.makeText(this,  "Error ", Toast.LENGTH_SHORT).show();

        }

    }
}