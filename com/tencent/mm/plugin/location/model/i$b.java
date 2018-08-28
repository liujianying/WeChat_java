package com.tencent.mm.plugin.location.model;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mm.plugin.location.model.i.a;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.Iterator;

protected class i$b implements SensorEventListener {
    private float fSV = 0.0f;
    final /* synthetic */ i kCT;
    private long timestamp = 200;

    protected i$b(i iVar) {
        this.kCT = iVar;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i = 0;
        if (sensorEvent.sensor.getType() == 3) {
            long currentTimeMillis = System.currentTimeMillis() - this.timestamp;
            float ay = q.ay(sensorEvent.values[0]);
            if (currentTimeMillis > 200 && Math.abs(ay - this.fSV) > 3.0f) {
                i iVar = this.kCT;
                float f = this.fSV;
                iVar.kCR = (double) ay;
                String str = "MicroMsg.OrientationSensorMgr";
                String str2 = "onOrientationChanged %f %f, mListenerList.size = %d";
                Object[] objArr = new Object[3];
                objArr[0] = Float.valueOf(f);
                objArr[1] = Float.valueOf(ay);
                if (iVar.gCt != null) {
                    i = iVar.gCt.size();
                }
                objArr[2] = Integer.valueOf(i);
                x.d(str, str2, objArr);
                if (iVar.gCt != null) {
                    Iterator it = iVar.gCt.iterator();
                    while (it.hasNext()) {
                        WeakReference weakReference = (WeakReference) it.next();
                        if (!(weakReference == null || weakReference.get() == null)) {
                            ((a) weakReference.get()).u(iVar.aZb());
                        }
                    }
                }
                this.fSV = ay;
                this.timestamp = System.currentTimeMillis();
            }
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }
}
