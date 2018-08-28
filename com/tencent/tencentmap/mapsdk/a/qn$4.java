package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.ac.j;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener;

class qn$4 implements j {
    final /* synthetic */ OnMapLongClickListener a;
    final /* synthetic */ qn b;

    qn$4(qn qnVar, OnMapLongClickListener onMapLongClickListener) {
        this.b = qnVar;
        this.a = onMapLongClickListener;
    }

    public void a(ox oxVar) {
        if (this.a != null) {
            this.a.onMapLongClick(qo.a(oxVar));
        }
    }
}
