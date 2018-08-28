package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.sdk.platformtools.x;

class CardGiftVideoUI$2 implements Runnable {
    final /* synthetic */ int dPF;
    final /* synthetic */ int dVx = 100;
    final /* synthetic */ CardGiftVideoUI hEs;

    CardGiftVideoUI$2(CardGiftVideoUI cardGiftVideoUI, int i) {
        this.hEs = cardGiftVideoUI;
        this.dPF = i;
    }

    public final void run() {
        if (CardGiftVideoUI.h(this.hEs) == null) {
            return;
        }
        if (this.dVx == 0) {
            CardGiftVideoUI.h(this.hEs).setVisibility(8);
            return;
        }
        if (CardGiftVideoUI.h(this.hEs).getVisibility() != 0) {
            CardGiftVideoUI.h(this.hEs).setVisibility(0);
        }
        x.i("MicroMsg.CardGiftVideoUI", "update progress %d %d", new Object[]{Integer.valueOf(this.dPF), Integer.valueOf(this.dVx)});
        if (CardGiftVideoUI.h(this.hEs).getMax() != this.dVx && this.dVx > 0) {
            CardGiftVideoUI.h(this.hEs).setMax(this.dVx);
        }
        CardGiftVideoUI.h(this.hEs).setProgress(this.dPF);
    }
}
