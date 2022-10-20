package com.example.cse118lab4;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;


import com.example.cse118lab4.databinding.ActivityMainBinding;

public class MainActivity extends Activity implements SensorEventListener{
    private TextView mTextView;
    private ActivityMainBinding binding;

    private SensorManager mSensorManager;
    private Sensor mHeartrate;
    private static final String TAG = "MainActivity";

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mTextView = binding.text;

        mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        mHeartrate = mSensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE);

    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mHeartrate, SensorManager.SENSOR_DELAY_FASTEST);
        Log.d(TAG, "checkpoint for onResume");
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
        Log.d(TAG, "checkpoint for onPause");
    }

//    protected void setTextViewValue(float[] values){
//        mTextView.setText(Float.toString(values[0]));
//    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d(TAG, "checkpoint for sensor changed");
        Log.d(TAG, "checkpoint "+sensorEvent.values[0]);
        mTextView.setText(Float.toString(sensorEvent.values[0]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}


// Version 2
//public class MainActivity extends Activity {
//
//    //Handler sensorHandler;
//    private ActivityMainBinding binding;
//    private TextView mTextView;
//    private SensorActivity heartRateSensor;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_main);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        heartRateSensor = new SensorActivity((SensorManager)getSystemService(SENSOR_SERVICE), this);
//        setContentView(binding.getRoot());
//        mTextView = binding.text;
//    }
//
//    protected void onResume() {
//        super.onResume();
//        heartRateSensor.onResume();
//    }
//
//    protected void onPause() {
//        super.onPause();
//        heartRateSensor.onPause();
//    }
//
//    protected void setTextViewValue(float[] values){
//        mTextView.setText(Float.toString(values[0]));
//    }
//}

//    Version 1
//    private ActivityMainBinding binding;
//    private static final String TAG = "MainActivity";
//    private TextView mTextViewHeart;
//    SensorManager mSensorManager;
//    Sensor mHeartRateSensor;
//    SensorEventListener sensorEventListener;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
////      setContentView(binding.getRoot());
//        mTextView = binding.text;
//
//        mSensorManager = ((SensorManager) getSystemService(SENSOR_SERVICE));
//        mHeartRateSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE);
////        mSensorManager.registerListener(sensorEventListener, mHeartRateSensor, SensorManager.SENSOR_DELAY_NORMAL);
////        mTextView.setText("hi"); //?
//    }
//
//    @Override
//    public void onResume(){
//        super.onResume();
//        mSensorManager.registerListener(sensorEventListener, mHeartRateSensor, SensorManager.SENSOR_DELAY_NORMAL);
////        mSensorManager.registerListener(sensorEventListener, mHeartRateSensor, mSensorManager.SENSOR_DELAY_FASTEST);
//    }
//
//    @Override
//    protected void onPause(){
//        super.onPause();
//        mSensorManager.unregisterListener(sensorEventListener);
//    }
//
//    public void onAccuracyChanged(Sensor sensor, int accuracy) {
//        Log.d(TAG, "onAccuracyChanged - accuracy: " + accuracy);
//    }
//
//    public void onSensorChanged(SensorEvent event) {
//        if (event.sensor.getType() == Sensor.TYPE_HEART_RATE) {
//            String msg = "" + (int)event.values[0];
//            mTextViewHeart.setText(msg);
//            Log.d(TAG, msg);
//        }
//        else
//            Log.d(TAG, "Unknown sensor type");
//    }
