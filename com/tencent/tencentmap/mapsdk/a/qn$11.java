package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.ac.m;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerDraggedListener;

class qn$11 implements m {
    final /* synthetic */ OnMarkerDraggedListener a;
    final /* synthetic */ qn b;

    qn$11(qn qnVar, OnMarkerDraggedListener onMarkerDraggedListener) {
        this.b = qnVar;
        this.a = onMarkerDraggedListener;
    }

    public void a(pa paVar) {
        if (this.a != null) {
            this.a.onMarkerDragStart(qn.a(this.b, paVar));
        }
    }

    public void b(pa paVar) {
        if (this.a != null) {
            this.a.onMarkerDrag(qn.a(this.b, paVar));
        }
    }

    public void c(pa paVar) {
        if (this.a != null) {
            this.a.onMarkerDragEnd(qn.a(this.b, paVar));
        }
    }
}
