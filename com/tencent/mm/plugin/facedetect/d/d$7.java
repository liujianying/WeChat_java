package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.sdk.platformtools.x;

class d$7 implements Runnable {
    final /* synthetic */ d iPx;

    d$7(d dVar) {
        this.iPx = dVar;
    }

    public final void run() {
        synchronized (this.iPx.iPq) {
            if (this.iPx.iPk) {
                x.i("MicroMsg.NumberFaceMotion", "hy: user already start. do nothing");
            } else {
                x.w("MicroMsg.NumberFaceMotion", "hy: not triggered symbol. auto start");
                this.iPx.iPk = true;
                d.b(this.iPx);
            }
        }
    }
}
