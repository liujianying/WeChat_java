package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.ac.g;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;

class qn$13 implements g {
    final /* synthetic */ OnInfoWindowClickListener a;
    final /* synthetic */ qn b;

    qn$13(qn qnVar, OnInfoWindowClickListener onInfoWindowClickListener) {
        this.b = qnVar;
        this.a = onInfoWindowClickListener;
    }

    public void a(pa paVar) {
        this.a.onInfoWindowClick(qn.a(this.b, paVar));
    }

    public void a(int i, int i2, int i3, int i4) {
    }
}
