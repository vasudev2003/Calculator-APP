package com.example.calculatorfinal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.NavigationUI;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import java.util.function.DoubleToIntFunction;


public class MainActivity extends AppCompatActivity {

   private AppBarConfiguration appBarConfiguration;
   private  ActivityMainBinding binding;
   public EditText e1, e2;
   TextView t1;
   int num1, num2;
   public boolean getNumbers() {
       e1 = (EditText)
               findViewById(R.id.num1);
       e2 = (EditText)
               findViewById(R.id.num2);

       t1 = (TextView)
               findViewById(R.id.result);

       String s1 = e1.getText().toString();
       String s2 = e2.getText().toString();
       if (s1.equals("Please enter value 1") && s2.equals(null)) {
           String result = "Please enter value 2";
           e2.setText(result);
           return false;
       }
       if (s1.equals(null) && s2.equals("Please enter value 2")) {
           String result = "Please enter value 1";
           e1.setText(result);
           return false;

       }
       if (s1.equals("Please enter value 1") || s2.equals("Please enter value 2")) {
           return false;
       }
       if ((!s1.equals(null) && s2.equals(null)) || (!s1.equals("") && s2.equals(""))) {
           String result = "Please enter value 2";
           e2.setText(result);
           return false;
       }
       if ((s1.equals(null) && !s2.equals(null)) || (s1.equals("") && !s2.equals(""))) {
           String result = "Please enter value 1";
           e1.setText(result);
           return false;
       }
       if ((s1.equals(null) &&
               s2.equals(null)) || (s1.equals("") && s2.equals(""))) {
           String result1 = "Please enter value 1";
           e1.setText(result1);
           String result2 = "Please enter value 2";
           e2.setText(result2);
           return false;
       } else {
           num1 = Integer.parseInt(s1);
           num2 = Integer.parseInt(s2);
       }
       return true;
   }
   public void doSum(View v)
   {
       if(getNumbers())
       {
           int sum=num1=num2;
           t1.setText(Integer.toString(sum));
       }
       else
       {
           t1.setText("Error Please Enter Required Values");
       }

    }
    public  void clearTextNum1(View v)
    {
        e1.getText().clear();
    }
    public  void clearTextNum2(View v)
    {
        e2.getText().clear();
    }
    public void doPow(View v)
    {
        if(getNumbers())
        {
            double sum=Math.pow(num1, num2);
            t1.setText(Double.toString(sum));
        }
        else
        {
            t1.setText("Error Please Enter Required Values");
        }
    }
    public void doMul(View v)
    {
        if(getNumbers())
        {
            int sum=num1*num2;
            t1.setText(Integer.toString((sum)));
        }
        else
        {
            t1.setText("Error Please Enter Required Values");
        }
    }
    public void doDiv(View v)
    {
        if(getNumbers())
        {
            double sum=num1/(num2*1.0);
            t1.setText("Error Please enter Required values");
        }
    }
    public void doMod(View v)
    {
        if(getNumbers()){
            double sum=num1%num2;
            t1.setText(Double.toString(sum));
        }
        else
        {
            t1.setText("Error Please Enter Required Values");
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)
                findViewById(R.id.num1);
        e2=(EditText)
                findViewById(R.id.num2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       int id=item.getItemId();
       if(id==R.id.actions)
       {
           return true;
       }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
       NavController navController=Navigation.findNavController(this,R.id.div);
        return NavigationUI.navigateUp(navController,appBarConfiguration)||super.onSupportNavigateUp();
    }
}