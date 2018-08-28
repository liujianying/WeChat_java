package com.tencent.mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class SensorController extends BroadcastReceiver implements SensorEventListener {
    private static float sIR = 4.2949673E9f;
    private static float sIT = 0.5f;
    public static boolean sJa = false;
    public static double sJb = -1.0d;
    private Context context;
    private SensorManager ejl;
    private float nCz = -1.0f;
    private float sIS;
    private a sIU;
    private Sensor sIV;
    private final boolean sIW;
    private boolean sIX = false;
    public boolean sIY = false;
    private float sIZ = -1.0f;

    public interface a {
        void dK(boolean z);
    }

    public SensorController(Context context) {
        if (context == null) {
            this.sIW = false;
            return;
        }
        boolean z;
        this.context = context;
        this.ejl = (SensorManager) context.getSystemService("sensor");
        this.sIV = this.ejl.getDefaultSensor(8);
        if (this.sIV != null) {
            this.nCz = Math.min(10.0f, this.sIV.getMaximumRange());
        }
        if (this.nCz < 0.0f) {
            x.e("MicroMsg.SensorController", "error, getMaximumRange return %s, set to 1", Float.valueOf(this.nCz));
            this.nCz = 1.0f;
        }
        if (this.sIV != null) {
            z = true;
        } else {
            z = false;
        }
        this.sIW = z;
        this.sIS = sIT + 1.0f;
    }

    public final void a(a aVar) {
        x.i("MicroMsg.SensorController", "sensor callback set, isRegistered:" + this.sIY + ", proximitySensor: " + this.sIV + ", maxValue: " + this.nCz);
        if (!this.sIY) {
            this.sIZ = -1.0f;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            this.context.registerReceiver(this, intentFilter);
            this.ejl.registerListener(this, this.sIV, 2);
            this.sIY = true;
        }
        this.sIU = aVar;
    }

    public final void ciL() {
        x.i("MicroMsg.SensorController", "sensor callback removed");
        try {
            this.context.unregisterReceiver(this);
        } catch (Exception e) {
            x.v("MicroMsg.SensorController", "sensor receiver has already unregistered");
        }
        this.ejl.unregisterListener(this, this.sIV);
        this.ejl.unregisterListener(this);
        this.sIY = false;
        this.sIU = null;
        this.sIZ = -1.0f;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent != null && sensorEvent.sensor != null && this.sIV != null && !this.sIX) {
            float f = sensorEvent.values[0];
            double d = 3.0d;
            x.i("MicroMsg.SensorController", "newValue: %s, maxValue: %s, divideRatio: %s, configNearFarDivideRatio: %s, lastValue: %s, maxRange: %s", Float.valueOf(f), Float.valueOf(this.nCz), Double.valueOf(3.0d), Double.valueOf(sJb), Float.valueOf(this.sIZ), Float.valueOf(this.sIV.getMaximumRange()));
            if (sJb > 0.0d) {
                d = sJb;
            }
            float maximumRange = (sJb > 0.0d || this.nCz < 0.0f) ? this.sIV.getMaximumRange() : this.nCz;
            x.i("MicroMsg.SensorController", "onSensorChanged, near threshold: %s, max: %s", Float.valueOf(Math.max(0.1f, (float) (((double) maximumRange) / d))), Float.valueOf(maximumRange));
            switch (sensorEvent.sensor.getType()) {
                case 8:
                    if (this.sIU != null && f != this.sIZ) {
                        if (f < r0) {
                            x.i("MicroMsg.SensorController", "sensor near-far event near false");
                            this.sIU.dK(false);
                        } else {
                            x.i("MicroMsg.SensorController", "sensor near-far event far true");
                            this.sIU.dK(true);
                        }
                        this.sIZ = f;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (action != null && action.equals("android.intent.action.HEADSET_PLUG")) {
                int intExtra = intent.getIntExtra("state", 0);
                if (intExtra == 1) {
                    this.sIX = true;
                }
                if (intExtra == 0) {
                    this.sIX = false;
                }
            }
        }
    }
}
