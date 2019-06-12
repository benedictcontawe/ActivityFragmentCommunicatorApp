package com.example.activityfragmentcommunicatorapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CustomActivity extends AppCompatActivity implements View.OnClickListener, FragmentLisener {

    Button btn_increase,btn_decrease,btn_reset,btn_exit;
    TextView tv_counter;
    CustomFragment customFragment;
    int fragmentCounter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        //region Set Events
        customFragment = new CustomFragment();

        tv_counter = (TextView) findViewById(R.id.tv_counter);
        btn_increase = (Button) findViewById(R.id.btn_increase);
        btn_decrease = (Button) findViewById(R.id.btn_decrease);
        btn_reset = (Button) findViewById(R.id.btn_reset);
        btn_exit = (Button) findViewById(R.id.btn_exit);

        btn_increase.setOnClickListener(this);
        btn_decrease.setOnClickListener(this);
        btn_reset.setOnClickListener(this);
        btn_exit.setOnClickListener(this);

        fragmentCounter = 0;
        //endregion
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_increase:
                callFragment();
                customFragment.increase();
                break;
            case R.id.btn_decrease:
                callFragment();
                customFragment.decrese();
                break;
            case R.id.btn_reset:
                callFragment();
                customFragment.reset();
                break;
            case R.id.btn_exit:
                customFragment.exit();
                break;

        }
    }

    private void callFragment() {
        customFragment = new CustomFragment();
        customFragment.setCounter(fragmentCounter);
        getSupportFragmentManager().beginTransaction().replace(R.id.ll_main,customFragment).commit();
    }

    @Override
    public void increase() {
        int x = Integer.valueOf(tv_counter.getText().toString());
        x++;
        tv_counter.setText(String.valueOf(x));
        Toast.makeText(this,"increase()",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void decrese() {
        int x = Integer.valueOf(tv_counter.getText().toString());
        x--;
        tv_counter.setText(String.valueOf(x));
        Toast.makeText(this,"decrese()",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void reset() {
        int x = 0;
        tv_counter.setText(String.valueOf(x));
        Toast.makeText(this,"reset()",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getCounter(int counter) {
        fragmentCounter = counter;
    }
}