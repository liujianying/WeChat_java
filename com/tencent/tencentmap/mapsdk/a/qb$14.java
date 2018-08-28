package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.tz.d;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;

class qb$14 implements d {
    final /* synthetic */ OnMapCameraChangeListener a;
    final /* synthetic */ qb b;

    qb$14(qb qbVar, OnMapCameraChangeListener onMapCameraChangeListener) {
        this.b = qbVar;
        this.a = onMapCameraChangeListener;
    }

    public void a(qs qsVar) {
        if (this.a != null) {
            this.a.onCameraChange(qc.a(qsVar));
        }
    }

    public void b(qs qsVar) {
        if (this.a != null) {
            this.a.onCameraChangeFinish(qc.a(qsVar));
        }
    }
}
