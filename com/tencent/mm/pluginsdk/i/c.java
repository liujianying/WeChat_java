package com.tencent.mm.pluginsdk.i;

import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class c {
    private SensorManager qDW;
    private a qDX;

    public c(Context context) {
        this.qDW = (SensorManager) context.getSystemService("sensor");
    }

    public final boolean ccQ() {
        return this.qDX != null;
    }

    public final void ccR() {
        if (this.qDX != null) {
            a.reset();
        }
    }

    public final void a(a aVar) {
        aDc();
        if (ccT()) {
            this.qDX = aVar;
            this.qDW.registerListener(this.qDX, this.qDW.getDefaultSensor(1), 1);
            return;
        }
        x.e("MicroMsg.ShakeSensorService", "no sensor found for shake detection");
    }

    public final void aDc() {
        if (this.qDX != null) {
            this.qDX.onRelease();
            this.qDW.unregisterListener(this.qDX, this.qDW.getDefaultSensor(1));
            this.qDX = null;
        }
    }

    public final boolean ccS() {
        return ccT();
    }

    private boolean ccT() {
        if (this.qDW == null) {
            x.e("MicroMsg.ShakeSensorService", "cannot init sensor manager");
            return false;
        }
        List sensorList = this.qDW.getSensorList(1);
        if (sensorList == null || sensorList.size() <= 0) {
            return false;
        }
        return true;
    }
}
