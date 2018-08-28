package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.hardware.SensorManager;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.m.a.b;
import com.tencent.mm.plugin.appbrand.l;

class a$1 extends b {
    final /* synthetic */ l fCl;
    final /* synthetic */ SensorManager fXZ;
    final /* synthetic */ a fYa;

    a$1(a aVar, l lVar, l lVar2, SensorManager sensorManager) {
        this.fYa = aVar;
        this.fCl = lVar2;
        this.fXZ = sensorManager;
        super(lVar);
    }

    public final void onDestroy() {
        e.b(this.fCl.mAppId, this);
        this.fXZ.unregisterListener(this);
    }
}
