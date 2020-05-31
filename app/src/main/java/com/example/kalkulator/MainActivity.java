package com.example.kalkulator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Objects;

// TODO:
// Add proper "ANS" functionality
// Tapping ANS field action
// Add swipe action on keyboard: (consts) → (numbers) → (functions)
// Add toolbar buttons to change viev between calc and graphing
// Add floating "Evaluate" button instead of fixed one
// Add more functions to Evaluator
// Save everything in OutState

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnper, btnpls, btnmin, btnmul, btndiv, btnbck, btnans, btnequ, btnlbr, btnrbr, btnsqrt;
    private TextView fieldEqu, fieldHis1, fieldHis2, fieldHis3, fieldHis4, fieldHis5, fieldHis6;

    // Decimal format of answers (change if you wish)
    // DecimalFormat numberFormat = new DecimalFormat("#.0000");
    int decimalPlaces = 4;

    public String equ = "";    // otherwise it will be "null"
    public AnswerStorage Ans = new AnswerStorage(6);
    boolean answerIsDisplayed = false;
    public Evaluator eval = new Evaluator();

    Intent launchGraphing = new Intent("com.example.kalkulator.FunctionInputActivity");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Biedny Kalkulator");

        btn1 = (Button) findViewById(R.id.button67);
        btn2 = (Button) findViewById(R.id.button68);
        btn3 = (Button) findViewById(R.id.button69);
        btn4 = (Button) findViewById(R.id.button62);
        btn5 = (Button) findViewById(R.id.button63);
        btn6 = (Button) findViewById(R.id.button64);
        btn7 = (Button) findViewById(R.id.button57);
        btn8 = (Button) findViewById(R.id.button58);
        btn9 = (Button) findViewById(R.id.button59);
        btn0 = (Button) findViewById(R.id.button72);

        btnper = (Button) findViewById(R.id.button73);
        btnpls = (Button) findViewById(R.id.button70);
        btnmin = (Button) findViewById(R.id.button75);
        btnmul = (Button) findViewById(R.id.button65);
        btndiv = (Button) findViewById(R.id.button60);
        btnbck = (Button) findViewById(R.id.button61);
        btnans = (Button) findViewById(R.id.button66);
        btnequ = (Button) findViewById(R.id.button71);
        btnlbr = (Button) findViewById(R.id.button77);
        btnrbr = (Button) findViewById(R.id.button76);
        btnsqrt = (Button) findViewById(R.id.button80);

        fieldEqu = (TextView) findViewById(R.id.EuqationVew);
        fieldHis1 = (TextView) findViewById(R.id.textView1);
        fieldHis2 = (TextView) findViewById(R.id.textView2);
        fieldHis3 = (TextView) findViewById(R.id.textView3);
        fieldHis4 = (TextView) findViewById(R.id.textView4);
        fieldHis5 = (TextView) findViewById(R.id.textView5);
        fieldHis6 = (TextView) findViewById(R.id.textView6);


        // KEYBOARD BUTTONS...

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCharactersToEquation("1");
                refreshUi();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCharactersToEquation("2");
                refreshUi();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCharactersToEquation("3");
                refreshUi();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCharactersToEquation("4");
                refreshUi();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCharactersToEquation("5");
                refreshUi();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCharactersToEquation("6");
                refreshUi();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCharactersToEquation("7");
                refreshUi();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCharactersToEquation("8");
                refreshUi();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCharactersToEquation("9");
                refreshUi();
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCharactersToEquation("0");
                refreshUi();
            }
        });
        btnper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCharactersToEquation(".");
                refreshUi();
            }
        });
        btnpls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCharactersToEquation(" + ");
                refreshUi();
            }
        });
        btnmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCharactersToEquation(" - ");
                refreshUi();
            }
        });
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCharactersToEquation(" * ");
                refreshUi();
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCharactersToEquation(" / ");
                refreshUi();
            }
        });
        btnbck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equ = removeLastCharRegex(equ);
                refreshUi();
            }
        });
        btnrbr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCharactersToEquation(")");
                refreshUi();
            }
        });
        btnlbr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCharactersToEquation("(");
                refreshUi();
            }
        });
        btnsqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCharactersToEquation("sqrt(");
                refreshUi();
            }
        });
        btnequ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double answer = 0;
                String answerString = "";
                boolean syntaxErrorOccured = false;
                try
                {
                    answer = Evaluator.evaluate(equ);
                }
                catch(RuntimeException e)
                {
                    fieldEqu.setError("Syntax error!");
                    Toast.makeText(getApplicationContext(),"Syntax Error!", Toast.LENGTH_SHORT).show();
                    syntaxErrorOccured = true;
                }
                if(!syntaxErrorOccured)
                {
                    // answerString = numberFormat.format(answer);
                    double scale = Math.pow(10,decimalPlaces);
                    answer = Math.round(answer*scale)/scale;
                    answerString = String.valueOf(answer);

                    if(answerString.endsWith(".0")) answerString = answerString.replace(".0" , "");
                    Ans.addLine(equ + " = " + answerString);
                    answerIsDisplayed = true;
                    equ = answerString;
                }
                refreshUi();
            }
        });
        btnans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // IMPLEMENT!!
            }
        });
    }

    // Inflate the menu; this adds items to the action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Define toolbar item actions
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.switchToGraph:
                startActivity(launchGraphing);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // this will save activity state before rotation/changing layout/switching app..
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("parameter1", equ);
    }

    // this will restore variables after rotation/layout change...
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        equ = savedInstanceState.getString("parameter1");
        refreshUi();
    }

    // clears equ if answer is currently being displayed + adds characters to equ
    public void addCharactersToEquation(String s) {
        if (answerIsDisplayed) {
            equ = "";
            answerIsDisplayed = false;
        }
        fieldEqu.setError(null);
        equ += s;
    }

    public void refreshUi() {
        fieldHis6.setText(Ans.getLine(0));
        fieldHis5.setText(Ans.getLine(1));
        fieldHis4.setText(Ans.getLine(2));
        fieldHis3.setText(Ans.getLine(3));
        fieldHis2.setText(Ans.getLine(4));
        fieldHis1.setText(Ans.getLine(5));
        fieldEqu.setText(equ);
    }

    public static String removeLastCharRegex(String s) {
        return (s == null) ? null : s.replaceAll(".$", "");
    }
}
