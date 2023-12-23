package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity_snake_2 extends AppCompatActivity implements View.OnClickListener {

    private SnakePanelView mSnakePanelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_snake_2);

        Bundle bundle = getIntent().getExtras();
        String tv_id2 = bundle.getString("id" );

        mSnakePanelView = findViewById(R.id.snake_view);
        findViewById(R.id.left_btn).setOnClickListener(this);
        findViewById(R.id.right_btn).setOnClickListener(this);
        findViewById(R.id.top_btn).setOnClickListener(this);
        findViewById(R.id.bottom_btn).setOnClickListener(this);
        findViewById(R.id.start_btn).setOnClickListener(this);
        mSnakePanelView.reSet();

        Button btn_score = (Button) findViewById(R.id.btn_score);
        btn_score.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity_snake_2.this, MainActivity_snake_3.class);
                Bundle bundle = new Bundle();
                bundle.putString("id",tv_id2);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    // Disable back button
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left_btn:
                mSnakePanelView.setSnakeDirection(GameType.LEFT);
                break;
            case R.id.right_btn:
                mSnakePanelView.setSnakeDirection(GameType.RIGHT);
                break;
            case R.id.top_btn:
                mSnakePanelView.setSnakeDirection(GameType.TOP);
                break;
            case R.id.bottom_btn:
                mSnakePanelView.setSnakeDirection(GameType.BOTTOM);
                break;
            case R.id.start_btn:
                mSnakePanelView.reStartGame();
                break;
        }
    }
}

