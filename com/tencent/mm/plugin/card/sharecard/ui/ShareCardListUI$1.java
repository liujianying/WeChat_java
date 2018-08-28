package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.mm.sdk.platformtools.x;

class ShareCardListUI$1 implements Runnable {
    final /* synthetic */ ShareCardListUI hAq;

    ShareCardListUI$1(ShareCardListUI shareCardListUI) {
        this.hAq = shareCardListUI;
    }

    public final void run() {
        ShareCardListUI.a(this.hAq);
        ShareCardListUI.b(this.hAq);
        this.hAq.hAl = true;
        x.d("MicroMsg.ShareCardListUI", "initLocation end");
    }
}
