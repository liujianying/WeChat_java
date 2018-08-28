package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.ag;

class am$1 implements e {
    final /* synthetic */ String sl;
    final /* synthetic */ bd ufb;
    final /* synthetic */ int ufc;
    final /* synthetic */ am ufd;

    am$1(am amVar, bd bdVar, String str, int i) {
        this.ufd = amVar;
        this.ufb = bdVar;
        this.sl = str;
        this.ufc = i;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.ChattingItemVoiceRemindSys", "errType " + i + " errCode " + i2 + "  scene " + lVar.getType());
        boolean z = false;
        if (a.dBu != null) {
            z = a.dBu.aT(this.ufb.field_msgId);
        }
        if (!z && i == 0 && i2 == 0 && ((ac) lVar).getMediaId().equals(this.sl)) {
            ((ag) am.a(this.ufd).O(ag.class)).cwl().a(this.ufc, this.ufb);
        }
        au.DF().b(221, am.b(this.ufd));
        am.c(this.ufd);
    }
}
