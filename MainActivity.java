package com.example.realtime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.Series;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private List<datasample>  DATA =new ArrayList<> ();

    private void readdata(){
        datasample sample;
         InputStream is =getResources().openRawResource(R.raw.data);
        BufferedReader reader =new  BufferedReader(
            new InputStreamReader(is, Charset.forName("UTF-8") )


            );
  String line ="";

            try {
                while ( (line = reader.readLine()) != null) {
                    String[] tokens =line.split(",");
                     sample = new datasample();
                    sample.getSerial(Integer.parseInt(tokens[0]));
                    sample.setState(tokens[1]);
                    sample.setConfirmed(Integer.parseInt(tokens[2]));
                    sample.setCured(Integer.parseInt(tokens[3]));
                    sample.setDeath(Integer.parseInt(tokens[4]));
                    DATA.add(sample);

                    Log.d("MyActivity","Error Reading data file on line" + sample) ;
                }
            }catch (IOException e) {
                Log.wtf("MyActivity","Error Reading data file on line" + line , e) ;
                e.printStackTrace();

            }

        }

}
