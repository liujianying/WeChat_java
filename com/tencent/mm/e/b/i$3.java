package com.tencent.mm.e.b;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class i$3 implements a {
    final /* synthetic */ i bFs;

    i$3(i iVar) {
        this.bFs = iVar;
    }

    public final boolean vD() {
        x.d("MicroMsg.SceneVoiceService", "onTimerExpired");
        i.h(this.bFs);
        return false;
    }

    public final String toString() {
        return super.toString() + "|scenePusher";
    }
}
