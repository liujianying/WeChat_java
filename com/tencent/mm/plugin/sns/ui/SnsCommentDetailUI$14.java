package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.lucky.ui.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsCommentFooter.c;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class SnsCommentDetailUI$14 implements c {
    final /* synthetic */ n nMf;
    final /* synthetic */ SnsCommentDetailUI nUO;

    SnsCommentDetailUI$14(SnsCommentDetailUI snsCommentDetailUI, n nVar) {
        this.nUO = snsCommentDetailUI;
        this.nMf = nVar;
    }

    public final void NJ(String str) {
        int i = 1;
        if (m.LS(this.nMf.bBe())) {
            bon commentInfo = SnsCommentDetailUI.b(this.nUO).getCommentInfo();
            if (SnsCommentDetailUI.b(this.nUO).getSendType() != 1) {
                i = 0;
            }
            SnsCommentDetailUI.a(this.nUO, str, commentInfo, i);
            SnsCommentDetailUI.b(this.nUO).ir(false);
            x.i("MicroMsg.SnsCommentDetailUI", "comment send imp!");
            SnsCommentDetailUI.s(this.nUO);
            new ag().postDelayed(new 1(this), 100);
            return;
        }
        a.e(this.nUO.mController.tml, this.nUO.nUK.xm(0));
    }
}
