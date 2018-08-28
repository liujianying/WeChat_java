package com.tencent.mm.plugin.scanner.util;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.HandlerThread;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class ScanCameraLightDetector implements SensorEventListener {
    public static final ScanCameraLightDetector mNw = new ScanCameraLightDetector();
    public SensorManager ejl;
    public ag handler;
    private float mNA = -1.0f;
    public HandlerThread mNB;
    public long mNx = -1;
    public Sensor mNy;
    public boolean mNz = false;

    private static native int calcLumNative(byte[] bArr, int i, int i2);

    static /* synthetic */ boolean r(byte[] bArr, int i, int i2) {
        if (!bi.bC(bArr) && bArr.length > i * i2) {
            x.i("MicroMsg.ScanCameraLightDetector", "lum light: %s", new Object[]{Integer.valueOf(calcLumNative(bArr, i, i2))});
            if (calcLumNative(bArr, i, i2) < 50) {
                return true;
            }
        }
        return false;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr != null && fArr.length > 0) {
            this.mNA = fArr[0];
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        x.d("MicroMsg.ScanCameraLightDetector", "onAccuracyChanged");
    }
}
