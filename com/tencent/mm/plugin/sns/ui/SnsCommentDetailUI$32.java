package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.ui.base.h;

class SnsCommentDetailUI$32 implements OnClickListener {
    final /* synthetic */ SnsCommentDetailUI nUO;

    SnsCommentDetailUI$32(SnsCommentDetailUI snsCommentDetailUI) {
        this.nUO = snsCommentDetailUI;
    }

    public final void onClick(View view) {
        h.a(this.nUO, i$j.sns_timeline_ui_confirm_del, i$j.app_tip, new 1(this), null);
    }
}
