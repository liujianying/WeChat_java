package com.tencent.mm.plugin.scanner.util;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class m implements SensorEventListener {
    public static final m mNW = new m();
    public SensorManager bgR = ((SensorManager) ad.getContext().getSystemService("sensor"));
    public Sensor mNS = this.bgR.getDefaultSensor(1);
    public float[] mNT = new float[3];
    public int mNU;
    private long mNV;

    private m() {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            x.d("MicroMsg.ScanStableDetector", "x:%f,y:%f,z:%f", new Object[]{Float.valueOf(fArr[0]), Float.valueOf(fArr[1]), Float.valueOf(fArr[2])});
            if (this.mNT[0] == 0.0f && this.mNT[1] == 0.0f && this.mNT[2] == 0.0f) {
                this.mNT[0] = fArr[0];
                this.mNT[1] = fArr[1];
                this.mNT[2] = fArr[2];
                return;
            }
            if (Math.abs(fArr[0] - this.mNT[0]) > 0.7f || Math.abs(fArr[1] - this.mNT[1]) > 0.7f || Math.abs(fArr[2] - this.mNT[2]) > 0.7f) {
                x.d("MicroMsg.ScanStableDetector", "scan unstable");
                this.mNU = 0;
            } else {
                if (this.mNU == 0) {
                    this.mNV = System.currentTimeMillis();
                }
                this.mNU++;
                if (this.mNU >= 5) {
                    x.d("MicroMsg.ScanStableDetector", "scan stable");
                }
            }
            this.mNT[0] = fArr[0];
            this.mNT[1] = fArr[1];
            this.mNT[2] = fArr[2];
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void stop() {
        x.i("MicroMsg.ScanStableDetector", "stop detect scan stable");
        if (this.bgR != null) {
            x.i("MicroMsg.ScanStableDetector", "unregister accelerate listener");
            this.bgR.unregisterListener(this);
        }
    }

    public final long btn() {
        if (this.mNU >= 5) {
            return this.mNV;
        }
        return 0;
    }
}
