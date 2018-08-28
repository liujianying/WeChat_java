package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.tz.g;
import com.tencent.tencentmap.mapsdk.map.TencentMap$OnMapLongClickListener;

class qb$3 implements g {
    final /* synthetic */ TencentMap$OnMapLongClickListener a;
    final /* synthetic */ qb b;

    qb$3(qb qbVar, TencentMap$OnMapLongClickListener tencentMap$OnMapLongClickListener) {
        this.b = qbVar;
        this.a = tencentMap$OnMapLongClickListener;
    }

    public void a(qw qwVar) {
        if (this.a != null) {
            this.a.onMapLongClick(qc.a(qwVar));
        }
    }
}
