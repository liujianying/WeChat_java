package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.x;

class SnsCommentDetailUI$9 implements Runnable {
    final /* synthetic */ SnsCommentDetailUI nUO;

    SnsCommentDetailUI$9(SnsCommentDetailUI snsCommentDetailUI) {
        this.nUO = snsCommentDetailUI;
    }

    public final void run() {
        SnsCommentDetailUI.a(this.nUO, SnsCommentDetailUI.c(this.nUO).getBottom());
        x.d("MicroMsg.SnsCommentDetailUI", "listOriginalBottom: " + SnsCommentDetailUI.d(this.nUO));
    }
}
