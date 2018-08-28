package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.modelmulti.b.a;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.x;

class ah$5 implements Runnable {
    final /* synthetic */ String dYC;
    final /* synthetic */ ah tSj;
    final /* synthetic */ int tSl;
    final /* synthetic */ long tSq;
    final /* synthetic */ long tSr;

    ah$5(ah ahVar, String str, long j, long j2, int i) {
        this.tSj = ahVar;
        this.dYC = str;
        this.tSq = j;
        this.tSr = j2;
        this.tSl = i;
    }

    public final void run() {
        this.tSj.bAG.tTs.setIsBottomShowAll(false);
        this.tSj.bAG.tTs.setBottomViewVisible(true);
        this.tSj.bAG.tTs.lK(true);
        x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr forceBottomLoadData true needCheckHistoryTips true");
        this.tSj.tSb = false;
        this.tSj.tSc = true;
        f.mDy.a(403, 5, 1, false);
        o.PN().a(new a(this.dYC, (int) this.tSq, (int) this.tSr, this.tSl, 1), this.tSj);
    }
}
