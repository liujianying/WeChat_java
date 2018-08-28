package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.hardware.SensorManager;
import java.util.List;

public final class az {
    private SensorManager qDW;
    private a sJc;

    public az(Context context) {
        this.qDW = (SensorManager) context.getSystemService("sensor");
    }

    public final boolean Q(Runnable runnable) {
        if (this.qDW == null) {
            return false;
        }
        List sensorList = this.qDW.getSensorList(1);
        if (sensorList == null || sensorList.size() <= 0) {
            return false;
        }
        this.sJc = new a(runnable);
        this.qDW.registerListener(this.sJc, 2, 3);
        return true;
    }

    public final void ciM() {
        if (this.qDW != null && this.sJc != null) {
            this.qDW.unregisterListener(this.sJc, 2);
        }
    }
}
