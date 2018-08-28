package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class i$1 implements a {
    final /* synthetic */ i orB;

    i$1(i iVar) {
        this.orB = iVar;
    }

    public final boolean vD() {
        String a = i.a(this.orB);
        if (a != null) {
            g Ok = h.Ok(a);
            if (Ok == null) {
                x.d("MicroMsg.VoiceRemindLogic", "startSend null record : " + a);
            } else if (Ok.field_status == 1) {
                Ok.field_status = 2;
                Ok.bWA = 64;
                h.a(Ok);
            }
        }
        d.bGu().run();
        x.d("MicroMsg.VoiceRemindRecorder", "Start Send fileName :" + i.a(this.orB));
        return false;
    }
}
