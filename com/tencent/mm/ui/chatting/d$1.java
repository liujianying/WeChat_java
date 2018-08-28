package com.tencent.mm.ui.chatting;

import com.tencent.mm.g.a.oc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class d$1 extends c<oc> {
    final /* synthetic */ d tHt;

    d$1(d dVar) {
        this.tHt = dVar;
        this.sFo = oc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        long j = ((oc) bVar).bYY.bJC;
        x.d("MicroMsg.AutoPlay", "playingVoiceId: %s", new Object[]{this.tHt.tHf});
        x.d("MicroMsg.AutoPlay", "msg id is: %s", new Object[]{r11.bYY.bJC});
        if (this.tHt.tHf == j) {
            ah.A(new 1(this));
        }
        return false;
    }
}
