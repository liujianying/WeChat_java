package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class SnsCommentDetailUI$4 implements OnTouchListener {
    final /* synthetic */ SnsCommentDetailUI nUO;

    SnsCommentDetailUI$4(SnsCommentDetailUI snsCommentDetailUI) {
        this.nUO = snsCommentDetailUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (SnsCommentDetailUI.q(this.nUO) != null) {
            SnsCommentDetailUI.q(this.nUO).bzf();
        }
        return false;
    }
}
