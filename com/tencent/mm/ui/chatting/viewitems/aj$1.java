package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.g.a.fl;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.ad;
import com.tencent.mm.ui.chatting.c.a;

class aj$1 implements Runnable {
    final /* synthetic */ bd dAs;
    final /* synthetic */ a tZG;

    aj$1(a aVar, bd bdVar) {
        this.tZG = aVar;
        this.dAs = bdVar;
    }

    public final void run() {
        a aVar = this.tZG;
        bd bdVar = this.dAs;
        ad adVar = (ad) aVar.O(ad.class);
        if (aVar == null || adVar == null) {
            x.e("MicroMsg.ChattingItemVoice", "alvinluo ui or ui.transformImp null");
            return;
        }
        int i = adVar.gG(bdVar.field_msgId) ? 2 : adVar.gD(bdVar.field_msgId) ? 3 : !bi.oW(adVar.w(bdVar.field_msgId, bdVar.field_imgPath)) ? 5 : 1;
        x.i("MicroMsg.ChattingItemVoice", "alvinluo TransformText report clickScene: %d, msgId: %d", new Object[]{Integer.valueOf(i), Long.valueOf(bdVar.field_msgId)});
        fl flVar = new fl();
        flVar.bNO.bNP = 1;
        flVar.bNO.scene = i;
        flVar.bNO.fileName = bdVar.field_imgPath;
        com.tencent.mm.sdk.b.a.sFg.m(flVar);
    }
}
