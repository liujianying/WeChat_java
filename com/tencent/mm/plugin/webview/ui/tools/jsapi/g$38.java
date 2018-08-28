package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class g$38 implements SensorEventListener {
    final /* synthetic */ g qiK;

    g$38(g gVar) {
        this.qiK = gVar;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 3) {
            g.a(this.qiK, sensorEvent.values[0]);
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }
}
