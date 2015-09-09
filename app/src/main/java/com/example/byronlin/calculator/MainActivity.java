package com.example.byronlin.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean containsDecimal = false;
    private boolean reset = true;
    private double runningTotal = 0; //total value, needs to be float for decimal
    private double selectNumber; //current number selected
    private int operator; //1 = multiply, 2 = divide, 3 = subtract, 4 = add
    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onButtonClick (View v){
        Button button = (Button) v;
        String bText = button.getText().toString(); //get value from button
        int Number = Integer.parseInt(bText);

        //if add decimal, make following number inputs behind decimal to be number/10^i, where i = 1 and increments
        if (containsDecimal) {
            selectNumber = selectNumber +  Number/Math.pow(10, i);
            i++;

        } else
         {
            //for multi digit numbers, eg press 2,1: SelectNumber = 0*10 = 0 + 2 = 2
            //                                       SelectNumber = 2*10 = 20 + 1 = 21
            selectNumber = selectNumber * 10;
            selectNumber = selectNumber + Number;
        }
        //print it on screen
        TextView myTextView = (TextView)
                findViewById(R.id.textView);
        myTextView.setText(Double.toString(selectNumber));
    }

    public void onDecimal (View v){
        containsDecimal = true;

    }

    public void onNegative (View v) {
        selectNumber = selectNumber - (selectNumber*2);
        TextView myTextView = (TextView)
                findViewById(R.id.textView);
        myTextView.setText(Double.toString(selectNumber));
    }

    public void onOperator (View v) {
        if (reset == true) {
            runningTotal = selectNumber;
            reset = false;
        } else {
            switch (operator) {
                case 1: //multiply
                    runningTotal = runningTotal * selectNumber;
                    break;
                case 2:
                    runningTotal = runningTotal / selectNumber;
                    break;
                case 3:
                    runningTotal = runningTotal - selectNumber;
                    break;
                case 4:
                    runningTotal = runningTotal + selectNumber;
                    break;
                default:
                    break;
            }
        }

        containsDecimal = false; //reset checkForDecimal
        i = 1;

        Button button = (Button) v;
        String bText = button.getText().toString(); //get value from button
        if (bText.equals("X")) {
            operator = 1;
            selectNumber = 0;
        } else if (bText.equals("/")) {
            operator = 2;
            selectNumber = 0;
        } else if (bText.equals("+")) {
            operator = 4;
            selectNumber = 0;
        } else if (bText.equals("-")) {
            operator = 3;
            selectNumber = 0;
        } else if (bText.equals("=")) {
            operator = 0;
            selectNumber = 0;
            //print on screen
            TextView myTextView = (TextView)
                    findViewById(R.id.textView);
            myTextView.setText(Double.toString(runningTotal));
        } else if (bText.equals("AC")) {
            operator = 0;
            selectNumber = 0;
            reset = true;
            //print 0 on screen
            TextView myTextView = (TextView)
                    findViewById(R.id.textView);
            myTextView.setText(Integer.toString(0));
        }

    }
}
