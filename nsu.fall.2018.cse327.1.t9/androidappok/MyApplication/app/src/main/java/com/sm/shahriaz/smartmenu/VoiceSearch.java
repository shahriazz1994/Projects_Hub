package com.sm.shahriaz.smartmenu;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Locale;

public class VoiceSearch extends AppCompatActivity {

    String searchKey;
    EditText editText;
    SpeechRecognizer mSpeechRecognizer;
    Intent mSpeechRecognizerIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_search);

        checkPermission();

        editText = findViewById(R.id.editText);
        mSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);

        mSpeechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        mSpeechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float rmsdB) {

            }

            @Override
            public void onBufferReceived(byte[] buffer) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int error) {

            }

            @Override
            public void onResults(Bundle bundleresults) {
                //we got all the results that are recognised by the recogniser
                ArrayList<String> matches = bundleresults.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

                //filter the best result
                if (matches!=null)
                    editText.setText(matches.get(0));
                    searchKey = matches.get(0);

            }

            @Override
            public void onPartialResults(Bundle partialResults) {

            }

            @Override
            public void onEvent(int eventType, Bundle params) {

            }
        });

        findViewById(R.id.button).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
               switch (motionEvent.getAction()){

                   case MotionEvent.ACTION_UP:
                       mSpeechRecognizer.stopListening();
                       editText.setHint("Input preview here");
                       break;
                   case MotionEvent.ACTION_DOWN:
                       editText.setText("");
                       editText.setHint("Listening..");
                       mSpeechRecognizer.startListening(mSpeechRecognizerIntent);
                       break;

               }
                return false;
            }
        });
    }

    private void checkPermission(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if (!(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED)){
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + getPackageName()));
                startActivity(intent);
                finish(); //if the permission is not granted, app will not start
            }
        }
    }
}
