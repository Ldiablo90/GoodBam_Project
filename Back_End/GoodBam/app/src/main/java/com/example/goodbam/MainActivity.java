package com.example.goodbam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton btn_chart, btn_setting, btn_nightmode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_chart = findViewById(R.id.main_btn_chart);
        btn_setting = findViewById(R.id.main_btn_setting);
        btn_nightmode = findViewById(R.id.main_btn_nightmode);

        btn_chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "아직 미구현", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ChartPageActivity.class);
                startActivity(intent);
            }
        });
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "아직 미구현", Toast.LENGTH_SHORT).show();
            }
        });
        btn_nightmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "아직 미구현", Toast.LENGTH_SHORT).show();
            }
        });

    }
}