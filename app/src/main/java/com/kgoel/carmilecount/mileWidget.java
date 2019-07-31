package com.kgoel.carmilecount;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Implementation of App Widget functionality.
 */
public class mileWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        //CharSequence widgetText = context.getString(R.string.appwidget_text);
        Log.d("kshitij","widget: inside updateAppWidget");
        Calendar calendar  = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String date = dateFormat.format(calendar.getTime());
        String start = "06/29/2019";

//        dateView.setText("");
//        dateView.append("" + Daybetween(start,date));
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.mile_widget);
        Log.d("kshitij","widget: Successful calculation: " + totalMiles(start,date));
        //views.setTextViewText(R.id.dateShowView, "");
        views.setTextViewText(R.id.mileCounterDisplay, "" + totalMiles(start,date));
        Log.d("kshitij","widget: Successful update ");

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions){
        Log.d("kshitij","widget: on create or change");
        updateAppWidget(context, appWidgetManager, appWidgetId);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    public static int totalMiles(String date1, String date2){
        long days = DayInBetween(date1,date2);
        return (int) (days*41.0958);
    }

    public static long DayInBetween(String date1,String date2)
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
        long res = ((Date2.getTime() - Date1.getTime()) / (24 * 60 * 60 * 1000));
        return res;
    }
}

