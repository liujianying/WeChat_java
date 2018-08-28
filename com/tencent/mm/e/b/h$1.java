package com.tencent.mm.e.b;

import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class h$1 implements a {
    final /* synthetic */ h bFa;

    h$1(h hVar) {
        this.bFa = hVar;
    }

    public final boolean vD() {
        q.a(this.bFa.mFileName, this.bFa);
        m.TK().run();
        x.d("MicroMsg.SceneVoice.Recorder", "Start Send fileName :" + this.bFa.mFileName);
        return false;
    }
}
