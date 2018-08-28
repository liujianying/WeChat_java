package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.x;

class SnsStrangerCommentDetailUI$10 implements Runnable {
    final /* synthetic */ SnsStrangerCommentDetailUI obC;

    SnsStrangerCommentDetailUI$10(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI) {
        this.obC = snsStrangerCommentDetailUI;
    }

    public final void run() {
        SnsStrangerCommentDetailUI.a(this.obC, SnsStrangerCommentDetailUI.a(this.obC).getBottom());
        x.d("MicroMsg.SnsStrangerCommentDetailUI", "listOriginalBottom: " + SnsStrangerCommentDetailUI.g(this.obC));
    }
}
