package com.example.wendt.synthesizer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button aButton, asButton, bButton, cButton, csButton, dButton, dsButton, eButton, fButton, fsButton, gButton, gsButton, playScaleButton, numberPickerButton, playTTLSButton;
    private MediaPlayer[] notesList = new MediaPlayer[24];
    private NumberPicker numberPicker, notePicker;
    private final int WHOLE_NOTE = 1000, HALF_NOTE = 500, QUARTER_NOTE = 250;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setPickers();
        setListeners();
        createMediaPlayers();
    }

    private void setPickers() {
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(100);
        notePicker.setMinValue(0);
        notePicker.setMaxValue(11);
        notePicker.setDisplayedValues(new String[]{"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"});

    }

    private void createMediaPlayers() {
        notesList[0] = MediaPlayer.create(this, R.raw.scalea);
        notesList[1] = MediaPlayer.create(this, R.raw.scalebb);
        notesList[2] = MediaPlayer.create(this, R.raw.scaleb);
        notesList[3] = MediaPlayer.create(this, R.raw.scalec);
        notesList[4] = MediaPlayer.create(this, R.raw.scalecs);
        notesList[5] = MediaPlayer.create(this, R.raw.scaled);
        notesList[6] = MediaPlayer.create(this, R.raw.scaleds);
        notesList[7] = MediaPlayer.create(this, R.raw.scalee);
        notesList[8] = MediaPlayer.create(this, R.raw.scalef);
        notesList[9] = MediaPlayer.create(this, R.raw.scalefs);
        notesList[10] = MediaPlayer.create(this, R.raw.scaleg);
        notesList[11] = MediaPlayer.create(this, R.raw.scalegs);
        notesList[12] = MediaPlayer.create(this, R.raw.scalehigha);
        notesList[13] = MediaPlayer.create(this, R.raw.scalehighbb);
        notesList[14] = MediaPlayer.create(this, R.raw.scalehighb);
        notesList[15] = MediaPlayer.create(this, R.raw.scalehighc);
        notesList[16] = MediaPlayer.create(this, R.raw.scalehighcs);
        notesList[17] = MediaPlayer.create(this, R.raw.scalehighd);
        notesList[18] = MediaPlayer.create(this, R.raw.scalehighds);
        notesList[19] = MediaPlayer.create(this, R.raw.scalehighe);
        notesList[20] = MediaPlayer.create(this, R.raw.scalehighf);
        notesList[21] = MediaPlayer.create(this, R.raw.scalehighfs);
        notesList[22] = MediaPlayer.create(this, R.raw.scalehighg);
        notesList[23] = MediaPlayer.create(this, R.raw.scalehighgs);
    }

    private void setListeners() {
        aButton.setOnClickListener(this);
        asButton.setOnClickListener(this);
        bButton.setOnClickListener(this);
        cButton.setOnClickListener(this);
        csButton.setOnClickListener(this);
        dButton.setOnClickListener(this);
        dsButton.setOnClickListener(this);
        eButton.setOnClickListener(this);
        fButton.setOnClickListener(this);
        fsButton.setOnClickListener(this);
        gButton.setOnClickListener(this);
        gsButton.setOnClickListener(this);
        playScaleButton.setOnClickListener(this);
        playTTLSButton.setOnClickListener(this);
        numberPickerButton.setOnClickListener(this);
    }

    private void wireWidgets() {
        aButton = (Button) findViewById(R.id.button_a);
        asButton = (Button) findViewById(R.id.button_as);
        bButton = (Button) findViewById(R.id.button_b);
        cButton = (Button) findViewById(R.id.button_c);
        csButton = (Button) findViewById(R.id.button_cs);
        dButton = (Button) findViewById(R.id.button_d);
        dsButton = (Button) findViewById(R.id.button_ds);
        eButton = (Button) findViewById(R.id.button_e);
        fButton = (Button) findViewById(R.id.button_f);
        fsButton = (Button) findViewById(R.id.button_fs);
        gButton = (Button) findViewById(R.id.button_g);
        gsButton = (Button) findViewById(R.id.button_gs);
        playScaleButton = (Button) findViewById(R.id.button_play_scale);
        playTTLSButton = (Button) findViewById(R.id.button_play_twinkle_twinkle_little_star);
        numberPickerButton = (Button) findViewById(R.id.button_number_picker);
        numberPicker = (NumberPicker) findViewById(R.id.picker_number);
        notePicker = (NumberPicker) findViewById(R.id.picker_note);
    }

    private void delayPlaying(int delay){
        try{
            Thread.sleep(delay);
        } catch(InterruptedException e){
            Log.e("Synthesizer","Audio playback interrupted");
        }
    }

    private void playNote(int note){
        notesList[note].seekTo(0);
        notesList[note].start();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_a:
                playNote(0);
                break;
            case R.id.button_as:
                playNote(1);
                break;
            case R.id.button_b:
                playNote(2);
                break;
            case R.id.button_c:
                playNote(3);
                break;
            case R.id.button_cs:
                playNote(4);
                break;
            case R.id.button_d:
                playNote(5);
                break;
            case R.id.button_ds:
                playNote(6);
                break;
            case R.id.button_e:
                playNote(7);
                break;
            case R.id.button_f:
                playNote(8);
                break;
            case R.id.button_fs:
                playNote(9);
                break;
            case R.id.button_g:
                playNote(10);
                break;
            case R.id.button_gs:
                playNote(11);
                break;
            case R.id.button_play_scale:
                playNote(7);
                delayPlaying(HALF_NOTE);
                playNote(9);
                delayPlaying(HALF_NOTE);
                playNote(10);
                delayPlaying(HALF_NOTE);
                playNote(12);
                delayPlaying(HALF_NOTE);
                playNote(14);
                delayPlaying(HALF_NOTE);
                playNote(16);
                delayPlaying(HALF_NOTE);
                playNote(17);
                delayPlaying(HALF_NOTE);
                playNote(19);
                break;
            case R.id.button_play_twinkle_twinkle_little_star:
                break;
            case R.id.button_number_picker:
                int numberOfTimesToPlay = numberPicker.getValue();
                while(numberOfTimesToPlay != 0){
                    playNote(notePicker.getValue());
                    delayPlaying(HALF_NOTE);
                    numberOfTimesToPlay--;
                }
                break;
            default:
        }
        //beep boop
    }
}
