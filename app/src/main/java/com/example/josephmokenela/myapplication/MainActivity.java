package com.example.josephmokenela.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;

    EditText editNum1;
    EditText editNum2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;

    TextView tvResult;

    String operand = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find the elements
        editNum1 = (EditText) findViewById(R.id.etNum1);
        editNum2 = (EditText) findViewById(R.id.etNum2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        tvResult = (TextView) findViewById(R.id.tvResult);

        // set a listener
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        // check if the fields are empty
        if (TextUtils.isEmpty(editNum1.getText().toString())
                || TextUtils.isEmpty(editNum2.getText().toString())) {
            return;
        }

        // read EditText and fill variables with numbers
        num1 = Float.parseFloat(editNum1.getText().toString());
        num2 = Float.parseFloat(editNum2.getText().toString());

        // defines the button that has been clicked and performs the corresponding operation
        // write operation into oper, we will use it later for output
        switch (v.getId()) {
            case R.id.btnAdd:
                operand = "+";
                result = num1 + num2;
                break;
            case R.id.btnSub:
                operand = "-";
                result = num1 - num2;
                break;
            case R.id.btnMult:
                operand = "*";
                result = num1 * num2;
                break;
            case R.id.btnDiv:
                operand = "/";
                result = num1 / num2;
                break;
            default:
                break;
        }

        // form the output line
        tvResult.setText(num1 + " " + operand + " " + num2 + " = " + result);
    }

    // menu creation
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        menu.add(0, MENU_RESET_ID, 0, "Reset");
        menu.add(0, MENU_QUIT_ID, 0, "Quit");
        return super.onCreateOptionsMenu(menu);
    }

    // process menu item clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case MENU_RESET_ID:
                // clear the fields
                editNum1.setText("");
                editNum2.setText("");
                tvResult.setText("");
                break;
            case MENU_QUIT_ID:
                // exit the application
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
