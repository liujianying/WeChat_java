package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.sdk.platformtools.x;

class CardGiftVideoUI$12 implements Runnable {
    final /* synthetic */ CardGiftVideoUI hEs;

    CardGiftVideoUI$12(CardGiftVideoUI cardGiftVideoUI) {
        this.hEs = cardGiftVideoUI;
    }

    public final void run() {
        x.d("MicroMsg.CardGiftVideoUI", "hide loading.");
        if (!(CardGiftVideoUI.g(this.hEs) == null || CardGiftVideoUI.g(this.hEs).getVisibility() == 8)) {
            CardGiftVideoUI.g(this.hEs).setVisibility(8);
        }
        if (CardGiftVideoUI.h(this.hEs) != null && CardGiftVideoUI.h(this.hEs).getVisibility() != 8) {
            CardGiftVideoUI.h(this.hEs).setVisibility(8);
        }
    }
}
