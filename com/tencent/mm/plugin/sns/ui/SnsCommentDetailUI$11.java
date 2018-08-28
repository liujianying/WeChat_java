package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsCommentFooter.a;

class SnsCommentDetailUI$11 implements a {
    final /* synthetic */ n nMf;
    final /* synthetic */ SnsCommentDetailUI nUO;

    SnsCommentDetailUI$11(SnsCommentDetailUI snsCommentDetailUI, n nVar) {
        this.nUO = snsCommentDetailUI;
        this.nMf = nVar;
    }

    public final void bDh() {
        if (m.LS(this.nMf.bBe())) {
            if (this.nUO.mController.tmG != 1 && !SnsCommentDetailUI.b(this.nUO).bDk()) {
                SnsCommentDetailUI.u(this.nUO);
            }
        } else if (SnsCommentDetailUI.t(this.nUO) == null || !SnsCommentDetailUI.t(this.nUO).isShowing()) {
            SnsCommentDetailUI.a(this.nUO, com.tencent.mm.plugin.sns.lucky.ui.a.e(this.nUO.mController.tml, this.nUO.nUK.xm(0)));
        }
    }
}
