package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

class SnsStrangerCommentDetailUI$9 implements OnClickListener {
    final /* synthetic */ SnsStrangerCommentDetailUI obC;

    SnsStrangerCommentDetailUI$9(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI) {
        this.obC = snsStrangerCommentDetailUI;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof ap) {
            SnsStrangerCommentDetailUI.f(this.obC).a(view, 2, null);
        }
    }
}
