package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.mm.sdk.platformtools.x;

class ShareCardListUI$5 implements Runnable {
    final /* synthetic */ ShareCardListUI hAq;

    ShareCardListUI$5(ShareCardListUI shareCardListUI) {
        this.hAq = shareCardListUI;
    }

    public final void run() {
        ShareCardListUI.i(this.hAq);
        if (this.hAq.isFinishing()) {
            x.w("MicroMsg.ShareCardListUI", "Activity is finished!!!");
        } else {
            ShareCardListUI.j(this.hAq);
        }
    }
}
