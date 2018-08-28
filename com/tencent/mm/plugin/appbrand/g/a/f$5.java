package com.tencent.mm.plugin.appbrand.g.a;

import com.eclipsesource.v8.JavaVoidCallback;

class f$5 implements Runnable {
    final /* synthetic */ f geo;
    final /* synthetic */ JavaVoidCallback ger;
    final /* synthetic */ String ges;

    f$5(f fVar, JavaVoidCallback javaVoidCallback, String str) {
        this.geo = fVar;
        this.ger = javaVoidCallback;
        this.ges = str;
    }

    public final void run() {
        f.d(this.geo).registerJavaMethod(this.ger, this.ges);
    }
}
