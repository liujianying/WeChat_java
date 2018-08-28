package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Looper;
import com.tencent.mm.pluginsdk.i.a;
import com.tencent.mm.sdk.platformtools.x;

final class e implements SensorEventListener {
    private static int lfw = Integer.MAX_VALUE;
    Camera ddt = null;
    private float lfA = 0.0f;
    private float lfB = 0.0f;
    private boolean lfX = false;
    boolean lft = false;
    boolean lfu = false;
    private int lfv = 0;
    private float lfz = 0.0f;
    private Context mContext = null;
    a ngs = a.ccO();
    PreviewCallback ngt = null;
    a ngu = new a(Looper.getMainLooper());

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        if (Math.abs(this.lfz - f) > 3.0f || Math.abs(this.lfA - f2) > 3.0f || Math.abs(this.lfB - f3) > 3.0f) {
            x.i("MicroMsg.SightCamera", "match accel limit %f, try auto focus", new Object[]{Float.valueOf(3.0f)});
            a.f(this.ddt);
            this.lfz = f;
            this.lfA = f2;
            this.lfB = f3;
        }
    }
}
