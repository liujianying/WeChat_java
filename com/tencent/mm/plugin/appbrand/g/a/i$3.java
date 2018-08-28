package com.tencent.mm.plugin.appbrand.g.a;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;

class i$3 implements Runnable {
    final /* synthetic */ String dhd;
    final /* synthetic */ f geC;
    final /* synthetic */ i geD;

    public i$3(i iVar, f fVar, String str) {
        this.geD = iVar;
        this.geC = fVar;
        this.dhd = str;
    }

    public final void run() {
        f fVar = this.geC;
        String str = this.dhd;
        if (fVar.gek.getType("onmessage") == 7) {
            V8Function v8Function = (V8Function) fVar.gek.get("onmessage");
            V8Array v8Array = new V8Array(fVar.gek);
            v8Array.push(str);
            v8Function.call(null, v8Array);
            v8Function.release();
            v8Array.release();
        }
    }
}
