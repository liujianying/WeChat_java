package com.tencent.mm.plugin.mmsight.model;

import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.mmsight.c;
import com.tencent.mm.sdk.platformtools.x;

class m$2 implements d {
    final /* synthetic */ String ewx;
    final /* synthetic */ r lgB;
    final /* synthetic */ m lgC;

    m$2(m mVar, r rVar, String str) {
        this.lgC = mVar;
        this.lgB = rVar;
        this.ewx = str;
    }

    public final boolean bcM() {
        c.sJ(this.lgB.enN);
        x.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile2 %s", this.ewx);
        this.lgB.dHI = s.nM(this.ewx);
        this.lgB.bWA = 32;
        o.Ta().b(this.lgB);
        return true;
    }
}
