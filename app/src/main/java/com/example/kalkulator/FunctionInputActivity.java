package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class FunctionInputActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnper, btnpls, btnmin, btnmul, btndiv, btnbck, btnequ, btnlbr, btnrbr, btnsqrt, btnx, btnans,pow,butsin;
    private TextView fieldForm;


    public String formula = "";
    public AnswerStorage Ans = new AnswerStorage(6);
    public Evaluator eval = new Evaluator();

    public double[] dataSetX;
    public double[] dataSetY;

    int decimalPrecision = 4;

    int xMin = -100;
    int xMax = 100;
    int dataPoints = 1000;

    Intent launchGraphingView = new Intent("com.example.kalkulator.GraphActivity");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function_input);

        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Graphing Menu");


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
        btnx = (Button) findViewById(R.id.button66);
        btnequ = (Button) findViewById(R.id.button71);
        btnlbr = (Button) findViewById(R.id.button77);
        btnrbr = (Button) findViewById(R.id.button76);
        btnsqrt = (Button) findViewById(R.id.button80);
        btnans = (Button) findViewById(R.id.button71);
        pow = (Button) findViewById(R.id.butpow);
        butsin = (Button) findViewById(R.id.butsin);

                fieldForm = (TextView) findViewById(R.id.EuqationVew);

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
                formula = removeLastCharRegex(formula);
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
        btnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCharactersToEquation("x");
                refreshUi();
            }
        });
        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCharactersToEquation("^");
                refreshUi();
            }
        });
        butsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCharactersToEquation("sin");
                refreshUi();
            }
        });

        btnans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillDataSet(formula,xMin,xMax,dataPoints);
                launchGraphingView.putExtra("size", dataPoints);
                launchGraphingView.putExtra("datasetX",dataSetX);
                launchGraphingView.putExtra("datasetY",dataSetY);
                startActivity(launchGraphingView);
            }
        });

    }

    public void addCharactersToEquation(String s) {
        fieldForm.setError(null);
        formula += s;
    }

    public void refreshUi()
    {
        fieldForm.setText(formula);
    }

    public static String removeLastCharRegex(String s) {
        return (s == null) ? null : s.replaceAll(".$", "");
    }

    public void fillDataSet(String formula, int xMin, int xMax, int points) {

        dataSetX = new double[points];
        dataSetY = new double[points];

        boolean syntaxErrorOccured = false;

        if(!(formula.contains("x"))) {
            fieldForm.setError("Syntax error!");
            Toast.makeText(getApplicationContext(),"Syntax Error!", Toast.LENGTH_SHORT).show();
            return;
        }
        for(int k=0; k<points; ++k) {

            String tempFormula = formula;
            double x = xMin+(((double)xMax-(double)xMin)/(double)points)*(k+1);
            double y = 0;
            System.out.println(tempFormula);
            tempFormula = tempFormula.replaceAll("x", String.valueOf(x));
            System.out.println(tempFormula);

            try {

                y = Evaluator.evaluate(tempFormula);
                System.out.println(y);
            }
            catch (RuntimeException e) {
                fieldForm.setError("Syntax error!");
                Toast.makeText(getApplicationContext(),"Syntax Error!", Toast.LENGTH_SHORT).show();
                syntaxErrorOccured = true;
            }
            double scale = Math.pow(10,decimalPrecision);
            if(!syntaxErrorOccured)
            {
                dataSetX[k] = Math.round(x*scale)/scale;
                dataSetY[k] = Math.round(y*scale)/scale;
            }
        }
    }
}