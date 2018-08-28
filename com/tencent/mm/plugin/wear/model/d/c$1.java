package com.tencent.mm.plugin.wear.model.d;

import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ c pJO;

    c$1(c cVar) {
        this.pJO = cVar;
    }

    public final boolean vD() {
        long cm = ((long) e.cm(this.pJO.filename)) - ((long) this.pJO.pJL);
        x.d("MicroMsg.Wear.NetSceneVoiceToText", "onTimerExpired: filename=%s | fileLength=%d | readOffset=%d | isRecordFinished=%b | canReadLength=%d", new Object[]{this.pJO.filename, Long.valueOf((long) e.cm(this.pJO.filename)), Integer.valueOf(this.pJO.pJL), Boolean.valueOf(this.pJO.eoE), Long.valueOf(cm)});
        if (cm < 3300 && !this.pJO.eoE) {
            return true;
        }
        if (this.pJO.eoE && cm <= 0) {
            return false;
        }
        if (this.pJO.a(this.pJO.dIX, this.pJO.diJ) == -1) {
            this.pJO.diJ.a(3, -1, "doScene failed", this.pJO);
        }
        return false;
    }
}
