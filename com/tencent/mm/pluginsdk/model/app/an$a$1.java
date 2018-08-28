package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.model.app.aa.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g;

class an$a$1 implements a {
    final /* synthetic */ bd dAB;
    final /* synthetic */ String fwt;
    final /* synthetic */ b qAI;
    final /* synthetic */ long qAJ;
    final /* synthetic */ an.a qAK;

    an$a$1(an.a aVar, b bVar, bd bdVar, long j, String str) {
        this.qAK = aVar;
        this.qAI = bVar;
        this.dAB = bdVar;
        this.qAJ = j;
        this.fwt = str;
    }

    public final void a(String str, String str2, String str3, String str4, String str5, long j) {
        this.qAI.field_signature = str3;
        this.qAI.field_fakeAeskey = str4;
        this.qAI.field_fakeSignature = str5;
        this.qAI.field_lastModifyTime = bi.VF();
        String str6 = this.dAB.field_content;
        if (s.fq(this.dAB.field_talker)) {
            int iA = com.tencent.mm.model.bd.iA(this.dAB.field_content);
            if (iA != -1) {
                str6 = (this.dAB.field_content + " ").substring(iA + 2).trim();
            }
        }
        g.a gp = g.a.gp(bi.WT(str6));
        if (gp != null) {
            gp.filemd5 = str;
            gp.dwK = str2;
            gp.dwo = (int) j;
            au.HU();
            bd dW = c.FT().dW(this.qAI.field_msgInfoId);
            dW.setContent(g.a.a(gp, null, null));
            au.HU();
            c.FT().a(dW.field_msgId, dW);
        }
        ao.asF().c(this.qAI, new String[0]);
        au.DF().a(new al(this.qAJ, null, this.fwt), 0);
    }
}
