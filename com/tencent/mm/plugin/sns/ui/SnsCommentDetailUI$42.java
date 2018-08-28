package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class SnsCommentDetailUI$42 implements OnClickListener {
    final /* synthetic */ SnsCommentDetailUI nUO;

    SnsCommentDetailUI$42(SnsCommentDetailUI snsCommentDetailUI) {
        this.nUO = snsCommentDetailUI;
    }

    public final void onClick(View view) {
        x.e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
        SnsCommentDetailUI.f(this.nUO);
        if (SnsCommentDetailUI.g(this.nUO)) {
            SnsCommentDetailUI.h(this.nUO);
        }
    }
}
