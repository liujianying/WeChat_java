package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mm.pluginsdk.ui.tools.r.a;
import com.tencent.mm.sdk.platformtools.x;

public final class e implements a {
    public static e qSs = null;
    public boolean hasInit = false;
    private float[] qSo = new float[3];
    int qSp = -10000;
    int qSq = -10000;
    private SensorManager qSr;
    private SensorEventListener qis;

    public final int cfn() {
        x.d("MicroMsg.HeadingPitchSensorMgr", "getHeading() " + this.qSp);
        return this.qSp;
    }

    public final int getPitch() {
        x.d("MicroMsg.HeadingPitchSensorMgr", "getPitch() " + this.qSq);
        return this.qSq;
    }

    public final void eZ(Context context) {
        x.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() ");
        if (context == null) {
            x.e("MicroMsg.HeadingPitchSensorMgr", "initSensor() context == null");
            return;
        }
        if (this.qSr == null) {
            this.qSr = (SensorManager) context.getSystemService("sensor");
        }
        if (this.qis == null) {
            this.qis = new 1(this);
        }
        boolean registerListener = this.qSr.registerListener(this.qis, this.qSr.getDefaultSensor(3), 3);
        this.hasInit = true;
        x.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() finish, %s", new Object[]{Boolean.valueOf(registerListener)});
    }

    private void cfo() {
        x.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
        if (!(this.qSr == null || this.qis == null)) {
            x.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
            this.qSr.unregisterListener(this.qis);
            this.qSr = null;
            this.qis = null;
        }
        this.hasInit = false;
    }

    public final String getName() {
        return "HeadingPitchSensorMgr";
    }

    public final void bXa() {
        qSs = null;
        cfo();
    }

    public final void ez(Context context) {
        eZ(context);
    }

    public final void bXb() {
        cfo();
    }
}
