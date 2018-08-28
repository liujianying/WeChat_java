package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.SnsCommentFooter.c;
import com.tencent.mm.sdk.platformtools.x;

class SnsStrangerCommentDetailUI$3 implements c {
    final /* synthetic */ SnsStrangerCommentDetailUI obC;

    SnsStrangerCommentDetailUI$3(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI) {
        this.obC = snsStrangerCommentDetailUI;
    }

    public final void NJ(String str) {
        x.v("MicroMsg.SnsStrangerCommentDetailUI", "comment send requested");
        SnsStrangerCommentDetailUI.a(this.obC, true);
        SnsStrangerCommentDetailUI.a(this.obC, SnsStrangerCommentDetailUI.k(this.obC), str);
    }
}
