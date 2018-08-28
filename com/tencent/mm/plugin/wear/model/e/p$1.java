package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.wear.model.d.c;
import com.tencent.mm.sdk.platformtools.x;

class p$1 implements Runnable {
    final /* synthetic */ String dhh;
    final /* synthetic */ p pKd;

    public p$1(p pVar, String str) {
        this.pKd = pVar;
        this.dhh = str;
    }

    public final void run() {
        p.a(this.pKd, new c(p.bP(), this.dhh, p.a(this.pKd)));
        au.DF().a(349, this.pKd);
        x.i("MicroMsg.Wear.VoiceToTextServer", "Create NetSceneVoiceInput");
    }
}
