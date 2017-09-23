package com.studies.sandrini.colorpicker;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar redBar, greenBar, blueBar;
    private TextView selectedColor, color;
    private String[] hexColor = {"00","00","00"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redBar = (SeekBar) findViewById(R.id.red_bar);
        greenBar = (SeekBar) findViewById(R.id.green_bar);
        blueBar = (SeekBar) findViewById(R.id.blue_bar);

        redBar.setOnSeekBarChangeListener(new EventSeek((byte)0));
        greenBar.setOnSeekBarChangeListener(new EventSeek((byte)1));
        blueBar.setOnSeekBarChangeListener(new EventSeek((byte)2));

        selectedColor = (TextView) findViewById(R.id.selected_color);
        color = (TextView) findViewById(R.id.color);
    }

    private class EventSeek implements SeekBar.OnSeekBarChangeListener {
        private byte color;

        public EventSeek(byte color){
            this.color = color;
        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            setHexNumber(progress, color);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    private void setHexNumber(int progress, byte color) {
        String c = Integer.toHexString(progress);
        hexColor[color] = (c.length() == 2 ? "" : "0") + c;
        setColor("#" + hexColor[0] + hexColor[1] + hexColor[2]);
    }

    private void setColor(String str) {
        selectedColor.setText(str);
        color.setBackgroundColor(Color.parseColor(str));
    }
}
