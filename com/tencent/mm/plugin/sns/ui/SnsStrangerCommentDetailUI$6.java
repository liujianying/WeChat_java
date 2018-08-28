package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.model.s;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.ui.base.h.c;

class SnsStrangerCommentDetailUI$6 implements c {
    final /* synthetic */ SnsStrangerCommentDetailUI obC;

    SnsStrangerCommentDetailUI$6(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI) {
        this.obC = snsStrangerCommentDetailUI;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                if (SnsStrangerCommentDetailUI.c(this.obC).BA()) {
                    s.i(SnsStrangerCommentDetailUI.c(this.obC));
                    SnsStrangerCommentDetailUI.c(this.obC).Be();
                    a.ezo.vl();
                    return;
                }
                s.h(SnsStrangerCommentDetailUI.c(this.obC));
                SnsStrangerCommentDetailUI.c(this.obC).Bd();
                a.ezo.vl();
                return;
            default:
                return;
        }
    }
}
