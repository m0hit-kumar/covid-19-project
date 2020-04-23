package com.example.trial3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    String valXY[];
    Double Xval;
    Double Yval;
    GraphView graph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GraphView graph = (GraphView) findViewById(R.id.graph);

        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open("res/raw/data.csv")));
            String mline;
            while((mline=reader.readLine())!=null)
            {
                valXY = mline.split(",");
                Xval =Double.parseDouble(valXY[0]);
                Yval =Double.parseDouble(valXY[1]);
                DataPoint[] dp = new DataPoint[valXY.length];
                for (int i = 0; i < valXY.length; i++)
                {
                    dp[i] = new DataPoint(Xval, Yval);
                }
                LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dp);
                graph.addSeries(series);
            }

        } catch (IOException e)
        {
            e.printStackTrace();
        }

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(1);

        graph.getViewport().setScrollable(true);
        graph.getViewport().setScrollableY(true);

    }
}


