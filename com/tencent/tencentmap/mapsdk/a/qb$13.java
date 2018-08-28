package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.tz.h;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;

class qb$13 implements h {
    final /* synthetic */ OnMarkerClickListener a;
    final /* synthetic */ qb b;

    qb$13(qb qbVar, OnMarkerClickListener onMarkerClickListener) {
        this.b = qbVar;
        this.a = onMarkerClickListener;
    }

    public boolean a(qy qyVar) {
        if (this.a != null) {
            return this.a.onMarkerClick(qb.a(this.b, qyVar));
        }
        return false;
    }
}
