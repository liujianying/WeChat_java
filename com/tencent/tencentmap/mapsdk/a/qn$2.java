package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;

class qn$2 implements ac$c {
    final /* synthetic */ OnMapCameraChangeListener a;
    final /* synthetic */ qn b;

    qn$2(qn qnVar, OnMapCameraChangeListener onMapCameraChangeListener) {
        this.b = qnVar;
        this.a = onMapCameraChangeListener;
    }

    public void a(or orVar) {
        if (this.a != null) {
            this.a.onCameraChange(qo.a(orVar));
        }
    }

    public void b(or orVar) {
        if (this.a != null) {
            this.a.onCameraChangeFinish(qo.a(orVar));
        }
    }
}
