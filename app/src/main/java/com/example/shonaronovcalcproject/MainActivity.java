package com.example.shonaronovcalcproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button plus,sub,multi,division,equal,delete,credits;
    private double num;
    private double res;
    private String operator,str,sign;
    private EditText display;
    private TextView name;
    private int count;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        display = findViewById(R.id.display);
        plus=(Button)findViewById(R.id.plus);
        sub=(Button)findViewById(R.id.sub);
        multi=(Button)findViewById(R.id.multi);
        division=(Button)findViewById(R.id.division);
        equal=(Button)findViewById(R.id.equal);
        delete=(Button)findViewById(R.id.delete);
        credits=(Button)findViewById(R.id.credits);
        name=findViewById(R.id.NameTv);

        public void add(View view) {
            res = Double.parseDouble(display.getText().toString());
            sign = "+";
            display.setText("");
        }

        public void mul(View view) {
            res = Double.parseDouble(display.getText().toString());
            sign = "*";
            display.setText("");
        }

        public void sub(View view) {
            res = Double.parseDouble(display.getText().toString());
            sign = "-";
            display.setText("");
        }

        public void div(View view) {
            res = Double.parseDouble(display.getText().toString());
            sign = "/";
            display.setText("");
        }

        public void equal(View view) {
            if (operator.equals("+")) {
                str = display.getText().toString();
                num = Float.parseFloat(str);
                res += num;
            }
            if (operator.equals("-")) {
                str = display.getText().toString();
                num = Float.parseFloat(str);
                res -= num;
            }
            if (operator.equals("*")) {
                str = display.getText().toString();
                num = Float.parseFloat(str);
                res *= num;
            }
            if (operator.equals("/")) {
                str = display.getText().toString();
                num = Float.parseFloat(str);
                if(num==0)
                    display.setText("Error");

                else {
                    res /= num;
                    display.setText(res + "");
                }
            }
            else
                display.setText(res+"");

        }

        public void delete(View view) {
            count=0;
            res=0;
            operator="";
            display.setText("");
            display.getHint();
        }

        public void Goto(View view) {
            Intent si = new Intent(this,MainActivity2.class);
            if(display.getText().toString().equals("Error"))
                si.putExtra("error","Error");
            else
                si.putExtra("num",res);
            startActivity(si);

        }

    }
}