package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.ab.i.a;
import com.tencent.mm.sdk.platformtools.x;

class i$2 implements a {
    final /* synthetic */ i orB;

    i$2(i iVar) {
        this.orB = iVar;
    }

    public final void onError() {
        x.e("MicroMsg.VoiceRemindRecorder", "Record Failed file:" + i.a(this.orB));
        i.Om(i.a(this.orB));
        if (this.orB.orv != null) {
            this.orB.orv.onError();
        }
    }
}
