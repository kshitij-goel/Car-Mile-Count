package com.kgoel.carmilecount;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView dateView = findViewById(R.id.dateView);
        final TextView startDate = findViewById(R.id.dateShowView);
        final Button submit = findViewById(R.id.submitButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar  = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                String date = dateFormat.format(calendar.getTime());
                String start = (String) startDate.getText();
                Log.d("kshitij","Start Date: " + start);

                dateView.setText("");
                dateView.append("" + Daybetween(start,date));
            }
        });

    }

    public long Daybetween(String date1,String date2)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date Date1 = null,Date2 = null;
        try{
            Date1 = sdf.parse(date1);
            Date2 = sdf.parse(date2);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        Log.d("kshitij","Date1: " + Date1);
        Log.d("kshitij","Date2: " + Date2);
        long res = ((Date2.getTime() - Date1.getTime()) / (24 * 60 * 60 * 1000));
        Log.d("kshitij","Result: " + res);
        return res;
    }
}
