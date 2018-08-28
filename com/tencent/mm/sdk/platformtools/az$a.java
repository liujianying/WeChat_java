package com.tencent.mm.sdk.platformtools;

import android.hardware.SensorListener;

class az$a implements SensorListener {
    private Runnable bJX;
    private float[] qDZ = new float[]{0.0f, 0.0f, 0.0f};

    public az$a(Runnable runnable) {
        this.bJX = runnable;
    }

    public final void onAccuracyChanged(int i, int i2) {
    }

    public final void onSensorChanged(int i, float[] fArr) {
        float[] fArr2 = new float[3];
        int i2 = 0;
        Object obj = null;
        while (i2 < 3) {
            fArr2[i2] = Math.abs(fArr[i2] - this.qDZ[i2]);
            if (this.qDZ[i2] != 0.0f && fArr2[i2] > 1.0f) {
                obj = 1;
                x.d("MicroMsg.ShakeManager", "isONShake:" + fArr2[i2]);
            }
            this.qDZ[i2] = fArr[i2];
            i2++;
        }
        if (obj != null) {
            this.bJX.run();
        }
    }
}
