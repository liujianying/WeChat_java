package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelmulti.b.a;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;

class ah$3 implements Runnable {
    final /* synthetic */ ai tQH;
    final /* synthetic */ ah tSj;
    final /* synthetic */ int tSo;

    ah$3(ah ahVar, int i, ai aiVar) {
        this.tSj = ahVar;
        this.tSo = i;
        this.tQH = aiVar;
    }

    public final void run() {
        long j;
        x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr mGoBackToHistryMsgLayout try get undeliver msg from firstseq[%d]", new Object[]{Integer.valueOf(this.tSo)});
        long j2 = this.tQH.field_lastSeq;
        au.HU();
        bd Hb = c.FT().Hb(this.tQH.field_username);
        if (Hb == null || Hb.field_msgId <= 0) {
            j = j2;
        } else {
            j = Hb.field_msgSeq;
        }
        this.tSj.tSb = true;
        x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr mGoBackToHistryMsgLayout get msg mUnreadMessageBeforeCheckHistory[%d], filterSeq[%d], firstSeq[%d]", new Object[]{Integer.valueOf(this.tSj.tSd), Long.valueOf(j), Integer.valueOf(this.tSo)});
        o.PN().a(new a(this.tQH.field_username, (int) j, this.tSo, 18, 0), this.tSj);
    }
}
