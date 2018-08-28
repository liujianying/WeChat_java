package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.map.TencentMap.OnErrorListener;

class qb$6 implements tz$b {
    final /* synthetic */ OnErrorListener a;
    final /* synthetic */ qb b;

    qb$6(qb qbVar, OnErrorListener onErrorListener) {
        this.b = qbVar;
        this.a = onErrorListener;
    }

    public void a(String str) {
        if (this.a != null) {
            this.a.collectErrorInfo(str);
        }
    }
}
