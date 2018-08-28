package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoiceaddr.g.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements Runnable {
    final /* synthetic */ a eqi;
    final /* synthetic */ b eqj;

    b$1(b bVar, a aVar) {
        this.eqj = bVar;
        this.eqi = aVar;
    }

    public final void run() {
        x.i("MicroMsg.NetSceneNewVoiceInput", "real doLastScene voiceId:%s, voiceFileMarkEnd:%s,hashCode:%s", new Object[]{this.eqi.eqP, Integer.valueOf(this.eqi.eqS), Integer.valueOf(this.eqj.hashCode())});
        g.DF().a(this.eqj, 0);
    }
}
