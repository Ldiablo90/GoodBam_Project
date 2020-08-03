package com.example.goodbam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class IdsearchActivity extends AppCompatActivity {

    private EditText et_name, et_answer;
    private Button btn_search, btn_movepass;
    private ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_search);

        et_name = findViewById(R.id.id_search_et_name);
        et_answer = findViewById(R.id.id_search_et_ans);

        btn_back = findViewById(R.id.id_search_btn_back);
        btn_search = findViewById(R.id.id_search_btn_find);
        btn_movepass = findViewById(R.id.id_search_btn_pass);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IdsearchActivity.this,Login2Activity.class);
                startActivity(intent);
            }
        });
        btn_movepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IdsearchActivity.this,PasssearchActivity.class);
                startActivity(intent);
            }
        });
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"아직 미구현",Toast.LENGTH_SHORT).show();
            }
        });
    }
}