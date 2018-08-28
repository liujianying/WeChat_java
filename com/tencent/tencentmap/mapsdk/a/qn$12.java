package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.ac.i;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLoadedListener;

class qn$12 implements i {
    final /* synthetic */ OnMapLoadedListener a;
    final /* synthetic */ qn b;

    qn$12(qn qnVar, OnMapLoadedListener onMapLoadedListener) {
        this.b = qnVar;
        this.a = onMapLoadedListener;
    }

    public void a() {
        if (this.a != null) {
            this.a.onMapLoaded();
        }
    }
}
