package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.ac.l;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;

class qn$14 implements l {
    final /* synthetic */ OnMarkerClickListener a;
    final /* synthetic */ qn b;

    qn$14(qn qnVar, OnMarkerClickListener onMarkerClickListener) {
        this.b = qnVar;
        this.a = onMarkerClickListener;
    }

    public boolean a(pa paVar) {
        if (this.a != null) {
            return this.a.onMarkerClick(qn.a(this.b, paVar));
        }
        return false;
    }
}
