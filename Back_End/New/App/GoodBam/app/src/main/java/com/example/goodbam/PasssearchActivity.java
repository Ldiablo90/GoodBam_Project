package com.example.goodbam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class PasssearchActivity extends AppCompatActivity {

    private EditText et_id, et_name, et_ans;
    private Button btn_moveid, btn_search;
    private ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_search);

        et_id = findViewById(R.id.pass_search_et_id);
        et_name = findViewById(R.id.pass_search_et_name);
        et_ans = findViewById(R.id.pass_search_et_ans);

        btn_back = findViewById(R.id.pass_search_btn_back);
        btn_moveid = findViewById(R.id.pass_search_btn_id);
        btn_search = findViewById(R.id.pass_search_btn_find);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PasssearchActivity.this,Login2Activity.class);
                startActivity(intent);
            }
        });
        btn_moveid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PasssearchActivity.this,IdsearchActivity.class);
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