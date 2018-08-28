package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class SnsStrangerCommentDetailUI$2 implements Runnable {
    int nVx = -1;
    int nVy = 10;
    final /* synthetic */ SnsStrangerCommentDetailUI obC;

    SnsStrangerCommentDetailUI$2(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI) {
        this.obC = snsStrangerCommentDetailUI;
    }

    public final void run() {
        if (!SnsStrangerCommentDetailUI.h(this.obC)) {
            this.nVy = 10;
        }
        SnsStrangerCommentDetailUI.i(this.obC);
        x.e("MicroMsg.SnsStrangerCommentDetailUI", "list.bottom:" + SnsStrangerCommentDetailUI.a(this.obC).getBottom() + " footer.top" + SnsStrangerCommentDetailUI.a(this.obC).getTop());
        int top = SnsStrangerCommentDetailUI.j(this.obC).getTop();
        int i = this.nVy;
        this.nVy = i - 1;
        if (i > 0 && (this.nVx != top || SnsStrangerCommentDetailUI.a(this.obC).getBottom() == SnsStrangerCommentDetailUI.g(this.obC))) {
            new ag().postDelayed(this, 30);
        }
        this.nVx = top;
        c.b(SnsStrangerCommentDetailUI.a(this.obC), SnsStrangerCommentDetailUI.a(this.obC).getCount() - 1);
    }
}
