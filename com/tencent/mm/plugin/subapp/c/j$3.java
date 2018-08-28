package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class j$3 implements a {
    final /* synthetic */ j orE;

    j$3(j jVar) {
        this.orE = jVar;
    }

    public final boolean vD() {
        x.d("MicroMsg.VoiceRemindService", "onTimerExpired");
        try {
            j.h(this.orE);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VoiceRemindService", e, "", new Object[0]);
        }
        return false;
    }
}
