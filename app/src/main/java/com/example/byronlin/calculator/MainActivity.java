package com.example.byronlin.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean reset = true;
    private float RunningTotal = 0; //total value, needs to be float for decimal
    private float SelectNumber; //current number selected
    private int method; //1 = multiply, 2 = divide, 3 = subtract, 4 = add

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

        //for multi digit numbers, eg press 2,1: SelectNumber = 0*10 =0 + 2 = 2
        //                                       SelectNumber = 2*10 = 20 + 1 = 21
        SelectNumber = SelectNumber * 10;
        SelectNumber = SelectNumber + Number;

        //print it on screen
        TextView myTextView = (TextView)
                findViewById(R.id.textView);
        myTextView.setText(Float.toString(SelectNumber));
    }



    public void onAdd (View v) {
        if (reset == true) {
            RunningTotal = SelectNumber; //runningtotal = 2
            reset = false;
        }
        else {
            switch (method) {
                case 1: //multiply
                    RunningTotal = RunningTotal * SelectNumber;
                    break;
                case 2:
                    RunningTotal = RunningTotal / SelectNumber;
                    break;
                case 3:
                    RunningTotal = RunningTotal - SelectNumber;
                    break;
                case 4:
                    RunningTotal = RunningTotal + SelectNumber;
                    break;
                default:
                    break;
            }
        }
        method = 4; //now set to add
        SelectNumber = 0;

    }

    public void onSubtract(View v){
        if (reset == true) {
            RunningTotal = SelectNumber;
            reset = false;
        }
        else {
            switch (method) {
                case 1: //multiply
                    RunningTotal = RunningTotal * SelectNumber;
                    break;
                case 2:
                    RunningTotal = RunningTotal / SelectNumber;
                    break;
                case 3:
                    RunningTotal = RunningTotal - SelectNumber;
                    break;
                case 4:
                    RunningTotal = RunningTotal + SelectNumber;
                    break;
                default:
                    break;
            }
        }
        method = 3;
        SelectNumber = 0;
    }

    public void onMultiply(View v){
        if (reset == true) {
            RunningTotal = SelectNumber;
            reset = false;
        }
        else {
            switch (method) {
                case 1: //multiply
                    RunningTotal = RunningTotal * SelectNumber;
                    break;
                case 2:
                    RunningTotal = RunningTotal / SelectNumber;
                    break;
                case 3:
                    RunningTotal = RunningTotal - SelectNumber;
                    break;
                case 4:
                    RunningTotal = RunningTotal + SelectNumber;
                    break;
                default:
                    break;
            }
        }
        method = 1;
        SelectNumber = 0;
    }

    public void onDivide(View v){
        if (reset == true) {
            RunningTotal = SelectNumber;
            reset = false;
        }
        else {
            switch (method) {
                case 1: //multiply
                    RunningTotal = RunningTotal * SelectNumber;
                    break;
                case 2:
                    RunningTotal = RunningTotal / SelectNumber;
                    break;
                case 3:
                    RunningTotal = RunningTotal - SelectNumber;
                    break;
                case 4:
                    RunningTotal = RunningTotal + SelectNumber;
                    break;
                default:
                    break;
            }
        }
        method = 2;
        SelectNumber = 0;
    }

    public void onEquals(View v){
        if (reset == true) {
            RunningTotal = SelectNumber;
            reset = false;
        }
        else {
            switch (method) {
                case 1: //multiply
                    RunningTotal = RunningTotal * SelectNumber;
                    break;
                case 2:
                    RunningTotal = RunningTotal / SelectNumber;
                    break;
                case 3:
                    RunningTotal = RunningTotal - SelectNumber;
                    break;
                case 4:
                    RunningTotal = RunningTotal + SelectNumber;
                    break;
                default:
                    break;
            }
        }
        method = 0;
        SelectNumber = 0;
        //print on screen
        TextView myTextView = (TextView)
                findViewById(R.id.textView);
        myTextView.setText(Float.toString(RunningTotal));
    }
    public void onAllClear(View v){
        method = 0;
        SelectNumber = 0;
        reset = true;
        TextView myTextView = (TextView)
                findViewById(R.id.textView);
        myTextView.setText(Integer.toString(0));

    }


}
