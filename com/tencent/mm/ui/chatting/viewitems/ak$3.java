package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.x;

class ak$3 implements e {
    final /* synthetic */ ak ueT;
    final /* synthetic */ b ueU;

    ak$3(ak akVar, b bVar) {
        this.ueT = akVar;
        this.ueU = bVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i + " errCode " + i2 + "  scene " + lVar.getType());
        if (((ac) lVar).getMediaId().equals(this.ueU.field_mediaSvrId)) {
            au.DF().b(221, ak.b(this.ueT));
            ak.a(this.ueT, null);
        }
    }
}
