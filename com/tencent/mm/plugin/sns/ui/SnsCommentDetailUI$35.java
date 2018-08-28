package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.lucky.ui.a;
import com.tencent.mm.plugin.sns.storage.n;

class SnsCommentDetailUI$35 implements OnClickListener {
    final /* synthetic */ n nMf;
    final /* synthetic */ SnsCommentDetailUI nUO;

    SnsCommentDetailUI$35(SnsCommentDetailUI snsCommentDetailUI, n nVar) {
        this.nUO = snsCommentDetailUI;
        this.nMf = nVar;
    }

    public final void onClick(View view) {
        if (m.LS(this.nMf.bBe())) {
            SnsCommentDetailUI.b(this.nUO).setmComment(null);
            SnsCommentDetailUI.b(this.nUO).setHint("");
            SnsCommentDetailUI.b(this.nUO).setSendType(0);
            SnsCommentDetailUI.b(this.nUO).ir(true);
            SnsCommentDetailUI.B(this.nUO).setVisibility(8);
            SnsCommentDetailUI.u(this.nUO);
            return;
        }
        a.e(this.nUO.mController.tml, this.nUO.nUK.xm(0));
    }
}
