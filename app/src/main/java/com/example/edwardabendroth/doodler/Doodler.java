package com.example.edwardabendroth.doodler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

public class Doodler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doodler);
        SeekBar sizeBar = (SeekBar) findViewById(R.id.size);
        sizeBar.setOnSeekBarChangeListener(customSeekBarListener);
        SeekBar opacityBar = (SeekBar) findViewById(R.id.opacity);
        opacityBar.setOnSeekBarChangeListener(customSeekBarListener2);
    }

    public void onClearClick(View v) {
        //Toast.makeText(getApplicationContext(), "YOU PRESSED THE CLEAR BUTTON", Toast.LENGTH_SHORT).show();
        DoodleView dView = (DoodleView)(findViewById(R.id.view));
        dView.clear();
    }
    public void diseaseClick(View v) {
        DoodleView dView = (DoodleView)(findViewById(R.id.view));
        dView.makeDisease();
    }

    public void changeColor(View v) {
        DoodleView dView = (DoodleView)(findViewById(R.id.view));
        dView.changeColor(v.getId());
    }

    private SeekBar.OnSeekBarChangeListener customSeekBarListener =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    //Toast.makeText(getApplicationContext(), "YOU CHANGED THE PROGRESS", Toast.LENGTH_SHORT).show();
                    DoodleView dView = (DoodleView)(findViewById(R.id.view));
                    dView.changeSize(progress);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            };

    private SeekBar.OnSeekBarChangeListener customSeekBarListener2 =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    //Toast.makeText(getApplicationContext(), "YOU CHANGED THE PROGRESS", Toast.LENGTH_SHORT).show();
                    DoodleView dView = (DoodleView)(findViewById(R.id.view));
                    dView.changeOpacity(progress);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            };
}
