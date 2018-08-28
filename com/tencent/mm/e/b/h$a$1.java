package com.tencent.mm.e.b;

import android.os.Message;
import com.tencent.mm.e.b.h.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class h$a$1 extends ag {
    final /* synthetic */ h bFb;
    final /* synthetic */ a bFc;

    h$a$1(a aVar, h hVar) {
        this.bFc = aVar;
        this.bFb = hVar;
    }

    public final void handleMessage(Message message) {
        if (this.bFc.bFa.bEU > 0) {
            x.d("MicroMsg.SceneVoice.Recorder", "On Part :" + (this.bFc.bFa.bEW == null));
            this.bFc.bFa.bEU = 2;
            if (this.bFc.bFa.bEW != null) {
                this.bFc.bFa.bEW.KU();
            }
        }
    }
}
