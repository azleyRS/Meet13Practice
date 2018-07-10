package com.example.rus.meet13practice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.rus.meet13practice.DataBase.DBManager;

import java.util.Calendar;

public class DetailedInfoActivity extends AppCompatActivity {
    private WeatherDay weatherDay;
    DBManager manager;
    int position;

    private TextView day;
    private TextView temp;
    private TextView minMaxTemp;
    private TextView pressure;
    private TextView seaLvl;
    private TextView grndLvl;
    private TextView humidity;
    private TextView tempKf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_info);

        position = getIntent().getIntExtra("position",0);

        manager = new DBManager(this);
        weatherDay = manager.getWeatherDay(position);

        initViews();
    }

    private void initViews() {
        day = findViewById(R.id.detailed_day);
        temp = findViewById(R.id.detailed_temp);
        minMaxTemp = findViewById(R.id.min_max_temp);
        pressure = findViewById(R.id.pressure);
        seaLvl = findViewById(R.id.sea_level);
        grndLvl = findViewById(R.id.grnd_lvl);
        humidity = findViewById(R.id.humidity);
        tempKf = findViewById(R.id.temp_kd);



        day.setText(android.text.format.DateFormat.format("EEE MMM d HH:mm:ss",weatherDay.getDate()));
        temp.setText("Avg temp in Moscow = " + weatherDay.getTemp());
        minMaxTemp.setText("Min temp = " + weatherDay.getTempMin().toString() + "\n" + "Max Temp = " + weatherDay.getTempMax().toString());
        pressure.setText("Pressure = " + weatherDay.getPressure().toString());
        seaLvl.setText("Sea level = " + weatherDay.getSea_level().toString());
        grndLvl.setText("Ground level = " + weatherDay.getGrnd_level().toString());
        humidity.setText("Humidity = " + weatherDay.getHumidity().toString());
        tempKf.setText("Temp KF = " + weatherDay.getTemp_kf().toString());
    }

    public static Intent newIntent(Context context, int positionForBd) {
        Intent intent = new Intent(context, DetailedInfoActivity.class);
        intent.putExtra("position", positionForBd);
        return intent;
    }
}
