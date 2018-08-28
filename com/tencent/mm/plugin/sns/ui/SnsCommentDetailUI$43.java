package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.ui.base.h.c;

class SnsCommentDetailUI$43 implements c {
    final /* synthetic */ SnsCommentDetailUI nUO;
    final /* synthetic */ Object[] nVn;

    SnsCommentDetailUI$43(SnsCommentDetailUI snsCommentDetailUI, Object[] objArr) {
        this.nUO = snsCommentDetailUI;
        this.nVn = objArr;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                SnsCommentDetailUI.b(this.nUO).a(this.nUO.getString(i$j.sns_reply) + this.nVn[3], (bon) this.nVn[1]);
                SnsCommentDetailUI.b(this.nUO).ir(true);
                int intValue = ((Integer) this.nVn[0]).intValue();
                if (aj.n(h.Nl(SnsCommentDetailUI.j(this.nUO))).smL.size() > 0) {
                    intValue++;
                    if (intValue > SnsCommentDetailUI.k(this.nUO).getCount()) {
                        intValue = SnsCommentDetailUI.k(this.nUO).getCount() - 1;
                    }
                }
                SnsCommentDetailUI.l(this.nUO).AV = intValue;
                SnsCommentDetailUI.l(this.nUO).run();
                return;
            default:
                return;
        }
    }
}
