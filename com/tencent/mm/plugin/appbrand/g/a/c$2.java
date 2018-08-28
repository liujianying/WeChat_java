package com.tencent.mm.plugin.appbrand.g.a;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8ArrayBuffer;
import com.eclipsesource.v8.V8Object;
import java.nio.ByteBuffer;

class c$2 implements JavaCallback {
    final /* synthetic */ c gdX;
    final /* synthetic */ f gdY;

    c$2(c cVar, f fVar) {
        this.gdX = cVar;
        this.gdY = fVar;
    }

    public final Object invoke(V8Object v8Object, V8Array v8Array) {
        if (v8Array.length() <= 0 || v8Array.getType(0) != 1) {
            return null;
        }
        ByteBuffer jA = this.gdX.gdW.jA(v8Array.getInteger(0));
        if (jA != null) {
            return new V8ArrayBuffer(this.gdY.gek, jA);
        }
        return null;
    }
}
