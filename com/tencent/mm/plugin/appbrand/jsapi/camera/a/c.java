package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import android.graphics.Rect;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.b.1;

public abstract class c {
    private boolean bPd = false;
    public a fPb;

    protected abstract b aiQ();

    public final void init() {
        aiQ().init();
    }

    public final void release() {
        aiQ().release();
    }

    public final void a(byte[] bArr, int i, int i2, Rect rect, int i3) {
        if (!this.bPd) {
            b aiQ = aiQ();
            if (bArr != null) {
                aiQ.fOQ.H(new 1(aiQ, bArr, i3, i, i2, rect));
            }
        }
    }
}
