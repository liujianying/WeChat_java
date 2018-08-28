package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.ac.h;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener;

class qn$3 implements h {
    final /* synthetic */ OnMapClickListener a;
    final /* synthetic */ qn b;

    qn$3(qn qnVar, OnMapClickListener onMapClickListener) {
        this.b = qnVar;
        this.a = onMapClickListener;
    }

    public void a(ox oxVar) {
        if (this.a != null) {
            this.a.onMapClick(qo.a(oxVar));
        }
    }
}
