package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.tz.e;
import com.tencent.tencentmap.mapsdk.map.TencentMap$OnMapClickListener;

class qb$2 implements e {
    final /* synthetic */ TencentMap$OnMapClickListener a;
    final /* synthetic */ qb b;

    qb$2(qb qbVar, TencentMap$OnMapClickListener tencentMap$OnMapClickListener) {
        this.b = qbVar;
        this.a = tencentMap$OnMapClickListener;
    }

    public void a(qw qwVar) {
        if (this.a != null) {
            this.a.onMapClick(qc.a(qwVar));
        }
    }
}
