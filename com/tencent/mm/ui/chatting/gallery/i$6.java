package com.tencent.mm.ui.chatting.gallery;

import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.x;

class i$6 implements Runnable {
    final /* synthetic */ int fXT;
    final /* synthetic */ i tWK;

    i$6(i iVar, int i) {
        this.tWK = iVar;
        this.fXT = i;
    }

    public final void run() {
        String a = i.a(this.tWK);
        int i = this.fXT;
        r nW = t.nW(a);
        if (nW != null) {
            int i2 = nW.enM;
            if (i2 <= 0 || Math.abs(i2 - i) > 2) {
                nW.enM = i;
                nW.bWA = GLIcon.LEFT;
                x.i("MicroMsg.VideoLogic", "repair video duration ret %b, duration[%d, %d]", new Object[]{Boolean.valueOf(t.e(nW)), Integer.valueOf(i2), Integer.valueOf(i)});
            }
        }
    }
}
