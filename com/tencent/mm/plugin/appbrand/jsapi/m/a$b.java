package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.m.a.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.sdk.platformtools.x;

abstract class a$b extends b implements SensorEventListener {
    private g fYb;
    a fYc = new a();

    a$b(l lVar) {
        this.fYc.a(lVar);
        this.fYb = new g((long) f.ajB(), new 1(this, lVar));
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            if (fArr == null || fArr.length < 3) {
                x.w("MicroMsg.JsApiEnableAccelerometer", "ACCELEROMETER sensor callback data invalidate.");
                return;
            }
            boolean k = this.fYb.k(new Object[]{fArr});
            x.v("MicroMsg.JsApiEnableAccelerometer", "try to do frequency limit action(%s).", new Object[]{Boolean.valueOf(k)});
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
