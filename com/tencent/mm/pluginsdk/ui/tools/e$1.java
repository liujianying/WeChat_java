package com.tencent.mm.pluginsdk.ui.tools;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements SensorEventListener {
    final /* synthetic */ e qSt;

    e$1(e eVar) {
        this.qSt = eVar;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 3) {
            e.a(this.qSt)[0] = sensorEvent.values[0];
            e.a(this.qSt)[1] = sensorEvent.values[1];
            e.a(this.qSt)[2] = sensorEvent.values[2];
            if (this.qSt.qSp == -10000) {
                this.qSt.qSp = (int) e.a(this.qSt)[0];
            } else if (e.a(this.qSt)[0] - ((float) this.qSt.qSp) > 300.0f || e.a(this.qSt)[0] - ((float) this.qSt.qSp) < -300.0f) {
                this.qSt.qSp = (int) e.a(this.qSt)[0];
            } else {
                this.qSt.qSp = (int) ((((double) this.qSt.qSp) * 0.6d) + (((double) e.a(this.qSt)[0]) * 0.4d));
            }
            if (this.qSt.qSp == 0) {
                this.qSt.qSp = 1;
            }
            if (this.qSt.qSp == 365) {
                this.qSt.qSp = 364;
            }
            if (this.qSt.qSq == -10000) {
                this.qSt.qSq = (int) e.a(this.qSt)[1];
            } else if (e.a(this.qSt)[1] < -68.0f) {
                int i = (int) (-68.0d + (((double) (e.a(this.qSt)[1] + 68.0f)) / 1.5d));
                if (i < -89) {
                    i = -89;
                }
                this.qSt.qSq = i;
            } else if (e.a(this.qSt)[1] > 89.0f) {
                this.qSt.qSq = 89;
            } else {
                this.qSt.qSq = (int) ((((double) this.qSt.qSq) * 0.6d) + (((double) e.a(this.qSt)[1]) * 0.4d));
            }
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
        x.i("MicroMsg.HeadingPitchSensorMgr", "onAccuracyChanged");
    }
}
