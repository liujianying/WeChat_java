package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.g.a.j;
import java.nio.ByteBuffer;

class o$1 extends j {
    final /* synthetic */ o feg;

    o$1(o oVar) {
        this.feg = oVar;
    }

    public final int aaL() {
        if (this.feg.fec != null) {
            return this.feg.fec.getNativeBufferId();
        }
        return 0;
    }

    public final ByteBuffer jA(int i) {
        if (this.feg.fec != null) {
            return this.feg.fec.getNativeBuffer(i);
        }
        return null;
    }

    public final void a(int i, ByteBuffer byteBuffer) {
        if (this.feg.fec != null) {
            this.feg.fec.setNativeBuffer(i, byteBuffer);
        }
    }

    public final void z(int i, String str) {
        this.feg.fcy.fdQ.evaluateJavascript(String.format("typeof WeixinWorker.workerMsgHandler !== 'undefined' && WeixinWorker.workerMsgHandler(%d, %s);", new Object[]{Integer.valueOf(i), str}), null);
    }
}
