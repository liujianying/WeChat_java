package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.sns.i$e;

class SnsCommentFooter$4 implements OnTouchListener {
    final /* synthetic */ SnsCommentFooter nVN;

    SnsCommentFooter$4(SnsCommentFooter snsCommentFooter) {
        this.nVN = snsCommentFooter;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        SnsCommentFooter.g(this.nVN);
        SnsCommentFooter.j(this.nVN).setVisibility(8);
        SnsCommentFooter.j(this.nVN).onPause();
        SnsCommentFooter.f(this.nVN).setImageResource(i$e.chatting_setmode_biaoqing_btn);
        if (SnsCommentFooter.k(this.nVN) != null) {
            SnsCommentFooter.k(this.nVN).bDh();
        }
        SnsCommentFooter.a(this.nVN, 0);
        return false;
    }
}
