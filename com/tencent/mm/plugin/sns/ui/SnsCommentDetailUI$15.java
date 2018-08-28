package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;

class SnsCommentDetailUI$15 implements SnsCommentFooter$b {
    final /* synthetic */ SnsCommentDetailUI nUO;

    SnsCommentDetailUI$15(SnsCommentDetailUI snsCommentDetailUI) {
        this.nUO = snsCommentDetailUI;
    }

    public final void bDi() {
        SnsCommentDetailUI.v(this.nUO);
        if (SnsCommentDetailUI.c(this.nUO).getFirstVisiblePosition() > 1 || SnsCommentDetailUI.c(this.nUO).getLastVisiblePosition() <= 0) {
            c.b(SnsCommentDetailUI.c(this.nUO), 1);
        }
    }
}
