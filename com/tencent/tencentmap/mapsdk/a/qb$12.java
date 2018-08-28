package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.tz.c;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;

class qb$12 implements c {
    final /* synthetic */ OnInfoWindowClickListener a;
    final /* synthetic */ qb b;

    qb$12(qb qbVar, OnInfoWindowClickListener onInfoWindowClickListener) {
        this.b = qbVar;
        this.a = onInfoWindowClickListener;
    }

    public void a(qy qyVar) {
        if (this.a != null) {
            this.a.onInfoWindowClick(qb.a(this.b, qyVar));
        }
    }
}
