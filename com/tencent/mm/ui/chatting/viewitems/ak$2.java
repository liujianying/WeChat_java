package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.ag;

class ak$2 implements e {
    final /* synthetic */ String sl;
    final /* synthetic */ bd ueR;
    final /* synthetic */ int ueS;
    final /* synthetic */ ak ueT;

    ak$2(ak akVar, bd bdVar, String str, int i) {
        this.ueT = akVar;
        this.ueR = bdVar;
        this.sl = str;
        this.ueS = i;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i + " errCode " + i2 + "  scene " + lVar.getType());
        boolean z = false;
        if (a.dBu != null) {
            z = a.dBu.aT(this.ueR.field_msgId);
        }
        if (!z && i == 0 && i2 == 0 && ((ac) lVar).getMediaId().equals(this.sl)) {
            bd al = bd.al(this.ueR);
            al.eq(this.ueR.field_reserved);
            al.setMsgId(-1);
            ((ag) ak.a(this.ueT).O(ag.class)).cwl().b(this.ueS, al);
        }
        au.DF().b(221, ak.b(this.ueT));
        ak.a(this.ueT, null);
    }
}
