package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.x;

class al$1 implements e {
    final /* synthetic */ al ueZ;

    al$1(al alVar) {
        this.ueZ = alVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.ChattingItemVoiceRemindRemind", "errType " + i + " errCode " + i2 + "  scene " + lVar.getType());
        au.DF().b(221, al.a(this.ueZ));
        al.b(this.ueZ);
    }
}
