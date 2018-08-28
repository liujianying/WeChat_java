package com.tencent.mm.plugin.voiceprint.model;

import android.os.Message;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class p$1 extends ag {
    final /* synthetic */ p oFB;

    public p$1(p pVar) {
        this.oFB = pVar;
    }

    public final void handleMessage(Message message) {
        x.d("MicroMsg.VoicePrintRecoder", " Recorder handleMessage");
        if (!p.a(this.oFB)) {
            au.HV().b(this.oFB);
            au.HV().yC();
            this.oFB.ew(200);
        }
    }
}
