package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.e.b.c;
import com.tencent.mm.sdk.platformtools.x;

class l$a implements Runnable {
    private b kqa = null;
    private c kqt = null;
    final /* synthetic */ l oKN;

    public l$a(l lVar, b bVar, c cVar) {
        this.oKN = lVar;
        this.kqa = bVar;
        this.kqt = cVar;
    }

    public final void run() {
        if (this.kqa != null) {
            this.kqa.bJv();
            this.kqa.bJs();
            this.kqa = null;
        }
        x.i("MicroMsg.Voip.VoipDeviceHandler", "do stopRecord");
        if (this.kqt != null) {
            this.kqt.we();
            this.kqt = null;
            x.i("MicroMsg.Voip.VoipDeviceHandler", "finish stopRecord");
        }
    }
}
