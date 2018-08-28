package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.b;

class SnsCommentDetailUI$b$1 implements Runnable {
    final /* synthetic */ b nVu;

    SnsCommentDetailUI$b$1(b bVar) {
        this.nVu = bVar;
    }

    public final void run() {
        SnsCommentDetailUI.c(this.nVu.nUO).setSelection((SnsCommentDetailUI.c(this.nVu.nUO).getHeaderViewsCount() + this.nVu.nVs.size()) - 1);
    }
}
