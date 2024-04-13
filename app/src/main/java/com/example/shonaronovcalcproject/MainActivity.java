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
    Button plus, sub, multi, division, equal, delete, credits;
    private double num;
    private double result
            ;
    private String operator, str;
    private EditText display;
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
        plus = findViewById(R.id.plus);
        sub = findViewById(R.id.sub);
        multi = findViewById(R.id.multi);
        division = findViewById(R.id.division);
        equal = findViewById(R.id.equal);
        delete = findViewById(R.id.delete);
        credits = findViewById(R.id.credits);
        result=0;
        operator="";
        str="";
        count=0;

    }
    public void equal(View view) {
        if (operator.equals("+")) {
            str = display.getText().toString();
            num = Float.parseFloat(str);
            result += num;
        }
        if (operator.equals("-")) {
            str = display.getText().toString();
            num = Float.parseFloat(str);
            result -= num;
        }
        if (operator.equals("*")) {
            str = display.getText().toString();
            num = Float.parseFloat(str);
            result *= num;
        }
        if (operator.equals("/")) {
            str = display.getText().toString();
            num = Float.parseFloat(str);
            if(num==0)
                display.setText("Error");

            else {
                result /= num;
                display.setText(result + "");
            }
        }
        else
            display.setText(result+"");

    }

    public void plus(View view) {

        str=display.getText().toString();
        if(!str.isEmpty()){
            count+=1;
            num=Float.parseFloat(str);
            if(operator.equals("-"))
                result-=num;
            else if(operator.equals("*"))
                result*=num;
            else if(operator.equals("/")) {
                if (num == 0)
                    display.setText("Error");
                else
                    result /= num;
            }
            else
                result+=num;
            operator="+";
        }

        display.setText("");
        display.getHint();

    }

    public void delete(View view) {
        count=0;
        result=0;
        operator="";
        display.setText("");
        display.getHint();
    }

    public void sub(View view) {

        str=display.getText().toString();
        if(!str.isEmpty()){
            count+=1;
            num=Float.parseFloat(str);
            if(operator.equals("+"))
                result+=num;
            else if(operator.equals("*"))
                result*=num;
            else if(operator.equals("/")) {
                if (num == 0)
                    display.setText("Error");
                else
                    result /= num;
            }
            else{
                if(count==1)
                    if(operator.equals(""))
                        result=num;
                    else
                        result=Float.valueOf((float) -num);
                else
                    result-=num;
            }

        }

        operator="-";
        display.setText("");
        display.getHint();
    }

    public void multi(View view) {
        str=display.getText().toString();
        if(!str.isEmpty()){
            count+=1;
            num=Float.parseFloat(str);
            if(operator.equals("+"))
                result+=num;
            else if(operator.equals("-"))
                result-=num;
            else if(operator.equals("/")){
                if(num==0)
                    display.setText("Error");
                else
                    result /= num;
            }
            else{
                if(count==1)
                    result=num;
                else
                    result*=num;
            }

            operator="*";

        }

        display.setText("");
        display.getHint();

    }

    public void division(View view) {
        str=display.getText().toString();
        if(!str.isEmpty()){
            count+=1;
            num=Float.parseFloat(str);
            if(operator.equals("+"))
                result+=num;
            else if(operator.equals("-"))
                result-=num;
            else if (operator.equals("*"))
                result*=num;
            else{
                if(count==1)
                    result=num;
                else if (num == 0)
                    display.setText("Error");
                else
                    result/=num;
            }

            operator="/";
        }

        display.setText("");
        display.getHint();

    }

    public void credits(View view) {
        Intent si = new Intent(this,MainActivity2.class);
        if(display.getText().toString().equals("Error"))
            si.putExtra("error","Error");
        else
            si.putExtra("num",result);
        startActivity(si);

    }

}

