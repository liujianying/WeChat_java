package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.ac.a;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;

class qn$7 implements a {
    final /* synthetic */ CancelableCallback a;
    final /* synthetic */ qn b;

    qn$7(qn qnVar, CancelableCallback cancelableCallback) {
        this.b = qnVar;
        this.a = cancelableCallback;
    }

    public void a() {
        if (this.a != null) {
            this.a.onFinish();
        }
    }

    public void b() {
        this.a.onCancel();
    }
}
