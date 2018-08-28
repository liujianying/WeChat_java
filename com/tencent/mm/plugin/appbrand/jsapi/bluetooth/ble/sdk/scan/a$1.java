package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan;

import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a;
import java.util.ArrayList;

class a$1 implements Runnable {
    final /* synthetic */ a fMV;

    a$1(a aVar) {
        this.fMV = aVar;
    }

    public final void run() {
        if (this.fMV.fMQ.get()) {
            if (this.fMV.fMU != null && this.fMV.fMS.size() > 0) {
                this.fMV.fMU.ao(new ArrayList(this.fMV.fMS));
                this.fMV.fMS.clear();
            }
            this.fMV.mHandler.postDelayed(this.fMV.fMT, (long) a.fLt.djl);
        }
    }
}
