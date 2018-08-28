package com.tencent.mm.modelmulti;

import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements a {
    final /* synthetic */ b dYL;

    b$3(b bVar) {
        this.dYL = bVar;
    }

    public final boolean vD() {
        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr timeoutHandler onTimerExpired");
        if (this.dYL.dYG != null) {
            this.dYL.dYG.ia(2);
        }
        f.mDy.a(403, 41, 1, false);
        return false;
    }
}
