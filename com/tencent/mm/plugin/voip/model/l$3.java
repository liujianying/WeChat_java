package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.sdk.platformtools.x;

class l$3 implements Runnable {
    final /* synthetic */ l oKN;

    l$3(l lVar) {
        this.oKN = lVar;
    }

    public final void run() {
        try {
            l.k(this.oKN);
        } catch (Exception e) {
            x.e("MicroMsg.Voip.VoipDeviceHandler", "start record error: %s", new Object[]{e.getMessage()});
            this.oKN.oKG = 1;
            this.oKN.oHa.yu(this.oKN.oKG);
        }
    }
}
