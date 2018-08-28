package com.tencent.mm.e.b;

import com.tencent.mm.ab.i.a;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.x;

class h$3 implements a {
    final /* synthetic */ h bFa;

    h$3(h hVar) {
        this.bFa = hVar;
    }

    public final void onError() {
        this.bFa.bEL.zY();
        x.e("MicroMsg.SceneVoice.Recorder", "Record Failed file:" + this.bFa.mFileName);
        q.op(this.bFa.mFileName);
        if (this.bFa.bEX != null) {
            this.bFa.bEX.onError();
        }
    }
}
