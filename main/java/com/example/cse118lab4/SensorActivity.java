//package com.example.cse118lab4;
//
//import android.app.Activity;
//import android.hardware.Sensor;
//import android.hardware.SensorEvent;
//import android.hardware.SensorEventListener;
//import android.hardware.SensorManager;
//import android.util.Log;
//
//public class SensorActivity extends Activity implements SensorEventListener {
//    private final SensorManager mSensorManager;
//    private final Sensor mHeartrate;
//    private final MainActivity ma;
//    private static final String TAG = "SensorActivity";
//
//    public SensorActivity(SensorManager sm, MainActivity ma) {
//        this.mSensorManager = sm;
//        this.mHeartrate = mSensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE);
//        this.ma = ma;
//        Log.d(TAG, "checkpoint for constructor");
//
//        mSensorManager.registerListener(this, mHeartrate, SensorManager.SENSOR_DELAY_NORMAL);
//
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
////        mSensorManager.registerListener(this, mHeartrate, SensorManager.SENSOR_DELAY_NORMAL);
//        Log.d(TAG, "checkpoint for onResume");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        mSensorManager.unregisterListener(this);
//        Log.d(TAG, "checkpoint for onPause");
//    }
//
//    @Override
//    public void onAccuracyChanged(Sensor sensor, int accuracy) {
//    }
//
//    @Override
//    public void onSensorChanged(SensorEvent event) {
//        Log.d(TAG, "checkpoint for sensor changed");
//        .setTextViewValue(event.values);
//    }
//}

