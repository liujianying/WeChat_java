package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.m.b.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.sdk.platformtools.x;

abstract class b$b extends b implements SensorEventListener {
    private g fYb;
    boolean fYf;
    private float[] fYg = new float[3];
    private float[] fYh = new float[3];
    a fYi = new a();

    b$b(l lVar) {
        this.fYi.a(lVar);
        this.fYb = new g((long) f.ajB(), new 1(this, lVar));
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (!this.fYf) {
            if (sensorEvent.values == null || sensorEvent.values.length < 3) {
                x.w("MicroMsg.JsApiEnableCompass", "compass sensor callback data invalidate.");
                return;
            }
            if (sensorEvent.sensor.getType() == 2) {
                this.fYh = sensorEvent.values;
            } else if (sensorEvent.sensor.getType() == 1) {
                this.fYg = sensorEvent.values;
            } else {
                return;
            }
            boolean k = this.fYb.k(new Object[0]);
            x.v("MicroMsg.JsApiEnableCompass", "try to do frequency limit action(%s).", new Object[]{Boolean.valueOf(k)});
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
