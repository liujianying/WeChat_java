package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.tz.f;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLoadedListener;

class qb$11 implements f {
    final /* synthetic */ OnMapLoadedListener a;
    final /* synthetic */ qb b;

    qb$11(qb qbVar, OnMapLoadedListener onMapLoadedListener) {
        this.b = qbVar;
        this.a = onMapLoadedListener;
    }

    public void a() {
        if (this.a != null) {
            this.a.onMapLoaded();
        }
    }
}
