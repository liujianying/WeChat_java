package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.ag;

class SnsCommentDetailUI$36 implements OnClickListener {
    final /* synthetic */ n nMf;
    final /* synthetic */ SnsCommentDetailUI nUO;
    final /* synthetic */ bsu nUW;

    SnsCommentDetailUI$36(SnsCommentDetailUI snsCommentDetailUI, n nVar, bsu bsu) {
        this.nUO = snsCommentDetailUI;
        this.nMf = nVar;
        this.nUW = bsu;
    }

    public final void onClick(View view) {
        if (!SnsCommentDetailUI.C(this.nUO)) {
            if (SnsCommentDetailUI.A(this.nUO) != null && this.nMf.field_likeFlag == 0) {
                SnsCommentDetailUI.A(this.nUO).ez(this.nMf.field_snsId);
            }
            new ag().postDelayed(new 1(this, view), (long) SnsCommentDetailUI.a(this.nUO, this.nUW, this.nMf));
        }
    }
}
