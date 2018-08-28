package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.ak.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.sdk.platformtools.bi;

class CardGiftVideoUI$4 implements Runnable {
    final /* synthetic */ String ewx;
    final /* synthetic */ CardGiftVideoUI hEs;

    CardGiftVideoUI$4(CardGiftVideoUI cardGiftVideoUI, String str) {
        this.hEs = cardGiftVideoUI;
        this.ewx = str;
    }

    public final void run() {
        if (bi.oW(CardGiftVideoUI.a(this.hEs))) {
            CardGiftVideoUI.f(this.hEs).setVisibility(0);
            a aVar = new a();
            aVar.dXB = e.bnE;
            o.Pk();
            aVar.dXU = null;
            aVar.dXA = m.xr(this.ewx);
            aVar.dXD = 1;
            aVar.dXy = true;
            aVar.dXw = true;
            o.Pj().a(this.ewx, CardGiftVideoUI.f(this.hEs), aVar.Pt());
        }
    }
}
