package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Size;
import android.view.Menu;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;


public class GraphActivity extends AppCompatActivity implements OnChartValueSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        LineChart chart = (LineChart)findViewById(R.id.chart1);
        ArrayList<Entry> values = new ArrayList<>();

        chart.setScaleEnabled(true);
        chart.setDragEnabled(true);
        chart.setPinchZoom(true);
        chart.setBackgroundColor(Color.WHITE);



        assert extras != null;
        int size = extras.getInt("size");
        double[] dataSetX = extras.getDoubleArray("datasetX");
        double[] dataSetY = extras.getDoubleArray("datasetY");

        StringBuilder X = new StringBuilder();
        StringBuilder Y = new StringBuilder();

        for(int k=0; k<size; ++k) {
            assert dataSetX != null;
            X.append(String.valueOf(dataSetX[k])).append(" ");
            assert dataSetY != null;
            Y.append(String.valueOf(dataSetY[k])).append(" ");
        }

        float x,y;

        for (int i = 0; i < dataSetX.length; i++)
        {
            x = (float)dataSetX[i];
            y = (float)dataSetY[i];

        //    if(dataSetX[i] < 0)
         //   {
           //     values.add(new Entry(x, -y, null) );
        //    }else
          //  {
                values.add(new Entry(x, y, null) );
         //   }

        }


        XAxis xaxis = chart.getXAxis();
        xaxis.setAvoidFirstLastClipping(true);

        YAxis yaxis = chart.getAxisLeft();
        yaxis.setAxisMaximum(10f);
        yaxis.setAxisMinimum(-10f);

        YAxis yaxis2 = chart.getAxisRight();
        yaxis2.setEnabled(true);


        LineDataSet dataset;

        dataset = new LineDataSet(values, "Graph");

        dataset.setColor(Color.BLACK);
        dataset.setLineWidth(2f);
        dataset.setDrawCircles(false);
        dataset.setDrawValues(false);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataset);
        LineData data = new LineData(dataSets);

       // chart.setAutoScaleMinMaxEnabled(!chart.isAutoScaleMinMaxEnabled());
        chart.setData(data);
        //chart.setVisibleXRangeMaximum(100f);

    }


    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}