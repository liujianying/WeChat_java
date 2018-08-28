package com.tencent.mm.e.b;

import com.tencent.mm.sdk.platformtools.x;

class h$2 implements Runnable {
    final /* synthetic */ h bFa;

    h$2(h hVar) {
        this.bFa = hVar;
    }

    public final void run() {
        if (!this.bFa.bES) {
            x.d("MicroMsg.SceneVoice.Recorder", "after start bluetooth, timeout to directly start record");
            this.bFa.wv();
        }
    }
}
