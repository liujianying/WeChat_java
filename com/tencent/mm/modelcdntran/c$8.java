package com.tencent.mm.modelcdntran;

import com.tencent.mm.sdk.platformtools.x;

class c$8 implements Runnable {
    final /* synthetic */ c dPb;
    final /* synthetic */ keep_SceneResult dPf;
    final /* synthetic */ String sl;

    c$8(c cVar, String str, keep_SceneResult keep_sceneresult) {
        this.dPb = cVar;
        this.sl = str;
        this.dPf = keep_sceneresult;
    }

    public final void run() {
        i iVar = (i) this.dPb.dOW.get(this.sl);
        if (iVar == null) {
            x.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid:%s", this.sl);
        } else if (iVar.dQi != null) {
            iVar.dQi.b(this.sl, this.dPf);
        }
    }
}
