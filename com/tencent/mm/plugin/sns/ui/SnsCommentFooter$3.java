package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.sdk.platformtools.x;

class SnsCommentFooter$3 implements OnClickListener {
    final /* synthetic */ SnsCommentFooter nVN;

    SnsCommentFooter$3(SnsCommentFooter snsCommentFooter) {
        this.nVN = snsCommentFooter;
    }

    public final void onClick(View view) {
        this.nVN.setModeClick(true);
        x.i("MicroMsg.SnsCommentFooter", "state onClick" + SnsCommentFooter.c(this.nVN));
        if (SnsCommentFooter.c(this.nVN) == 0) {
            SnsCommentFooter.d(this.nVN);
            SnsCommentFooter.a(this.nVN).requestFocus();
            SnsCommentFooter.a(this.nVN, 1);
            SnsCommentFooter.e(this.nVN);
            SnsCommentFooter.f(this.nVN).setImageResource(e.chatting_setmode_keyboard_btn);
            SnsCommentFooter.g(this.nVN);
            return;
        }
        SnsCommentFooter.h(this.nVN);
        SnsCommentFooter.g(this.nVN);
        SnsCommentFooter.a(this.nVN).requestFocus();
        SnsCommentFooter.i(this.nVN);
        SnsCommentFooter.f(this.nVN).setImageResource(e.chatting_setmode_biaoqing_btn);
        SnsCommentFooter.a(this.nVN, 0);
    }
}
