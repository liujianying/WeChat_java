package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class SnsCommentDetailUI$c implements Runnable {
    int AV = -1;
    int hGJ;
    final /* synthetic */ SnsCommentDetailUI nUO;
    private int nVx = -1;
    private int nVy = 10;
    private int offset = 0;

    SnsCommentDetailUI$c(SnsCommentDetailUI snsCommentDetailUI) {
        this.nUO = snsCommentDetailUI;
    }

    public final void run() {
        this.nVy = 10;
        SnsCommentDetailUI.a(this.nUO);
        this.nVx = SnsCommentDetailUI.b(this.nUO).getTop();
        int i = this.nVx - this.hGJ;
        x.i("MicroMsg.SnsCommentDetailUI", "list.bottom: %d, listOriginalBottom: %d, footerTop: %d, commentFooter.getTop: %d, topSelection: %d", new Object[]{Integer.valueOf(SnsCommentDetailUI.c(this.nUO).getBottom()), Integer.valueOf(SnsCommentDetailUI.d(this.nUO)), Integer.valueOf(this.nVx), Integer.valueOf(SnsCommentDetailUI.b(this.nUO).getTop()), Integer.valueOf(i)});
        if (i == this.offset) {
            SnsCommentDetailUI.c(this.nUO).setSelectionFromTop(SnsCommentDetailUI.c(this.nUO).getHeaderViewsCount() + this.AV, i);
            this.nVy = 0;
            this.offset = 0;
            return;
        }
        int i2 = this.nVy;
        this.nVy = i2 - 1;
        if (i2 > 0) {
            new ag().postDelayed(this, 100);
            this.offset = i;
            return;
        }
        this.offset = 0;
        this.nVy = 0;
    }
}
