package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact.JsApiBatchGetContactTask.1;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Timer;
import java.util.TimerTask;

class JsApiBatchGetContact$JsApiBatchGetContactTask$1$1 extends TimerTask {
    final /* synthetic */ boolean[] fFI;
    final /* synthetic */ Timer fFJ;
    final /* synthetic */ 1 fFK;

    JsApiBatchGetContact$JsApiBatchGetContactTask$1$1(1 1, boolean[] zArr, Timer timer) {
        this.fFK = 1;
        this.fFI = zArr;
        this.fFJ = timer;
    }

    public final void run() {
        synchronized (JsApiBatchGetContact.class) {
            if (this.fFI[0]) {
                x.i("MicroMsg.JsApiBatchGetContact", "isCallBacked");
            } else {
                this.fFI[0] = true;
                x.w("MicroMsg.JsApiBatchGetContact", "get contact timeout");
                this.fFK.fFH.Yy = "fail:get contact timeout";
                this.fFK.fFH.ahH();
            }
        }
        cancel();
        this.fFJ.cancel();
    }
}
