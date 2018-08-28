package com.tencent.mm.plugin.sns.ui;

class SnsStrangerCommentDetailUI$8 implements Runnable {
    final /* synthetic */ SnsStrangerCommentDetailUI obC;

    SnsStrangerCommentDetailUI$8(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI) {
        this.obC = snsStrangerCommentDetailUI;
    }

    public final void run() {
        SnsStrangerCommentDetailUI.a(this.obC).setSelection(SnsStrangerCommentDetailUI.d(this.obC).getCount() - 1);
    }
}
