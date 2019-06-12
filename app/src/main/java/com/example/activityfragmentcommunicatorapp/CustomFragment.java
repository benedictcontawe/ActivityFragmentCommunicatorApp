package com.example.activityfragmentcommunicatorapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomFragment extends Fragment implements View.OnClickListener {

    private FragmentLisener fragmentLisener;
    private View customView;
    TextView tv_increase,tv_decrease,tv_counter;
    ImageView iv_iconDelete;
    int counter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        customView = inflater.inflate(R.layout.fragment_custom,container,false);

        //region Set Events
        fragmentLisener = (FragmentLisener)getActivity();

        tv_increase = (TextView) customView.findViewById(R.id.tv_increase);
        tv_decrease = (TextView) customView.findViewById(R.id.tv_decrease);
        tv_counter = (TextView) customView.findViewById(R.id.tv_counter);
        iv_iconDelete = (ImageView) customView.findViewById(R.id.iv_iconDelete);


        tv_increase.setOnClickListener(this);
        tv_decrease.setOnClickListener(this);
        iv_iconDelete.setOnClickListener(this);
        //endregion

        return customView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_increase:
                //tv_counterItems
                fragmentLisener.increase();
                break;
            case R.id.tv_decrease:
                //tv_counterItems
                fragmentLisener.decrese();
                break;
            case R.id.iv_iconDelete:
                //tv_counterItems
                fragmentLisener.reset();
                break;

        }
    }

    public void setCounter(int counter){
        this.counter = counter;
    }

    public void increase() {
        this.counter++;
    }

    public void decrese() {
        this.counter--;
    }

    public void reset() {
        this.counter = 0;
    }

    public void exit(){
        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv_counter.setText(String.valueOf(counter));
        fragmentLisener.getCounter(counter);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}