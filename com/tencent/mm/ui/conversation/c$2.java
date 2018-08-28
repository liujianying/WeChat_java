package com.tencent.mm.ui.conversation;

import com.tencent.mm.g.a.ba;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class c$2 extends c<ba> {
    final /* synthetic */ c unP;

    c$2(c cVar) {
        this.unP = cVar;
        this.sFo = ba.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((ba) bVar).bIx.bIy != this.unP.unK) {
            x.i("MicroMsg.ConvUnreadHelper", "unreadcheck wrong should be %d, but is %d", Integer.valueOf(((ba) bVar).bIx.bIy), Integer.valueOf(this.unP.unK));
            this.unP.unK = -1;
        }
        return true;
    }
}
