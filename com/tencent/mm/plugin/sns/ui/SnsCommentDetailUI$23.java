package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.qp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsCommentDetailUI$23 extends c<qp> {
    final /* synthetic */ SnsCommentDetailUI nUO;

    SnsCommentDetailUI$23(SnsCommentDetailUI snsCommentDetailUI) {
        this.nUO = snsCommentDetailUI;
        this.sFo = qp.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qp qpVar = (qp) bVar;
        if (qpVar instanceof qp) {
            String str = qpVar.cbf.id;
            if (qpVar.cbf.type == 1) {
                SnsCommentDetailUI.d(this.nUO, str);
            } else if (qpVar.cbf.type == 2) {
                SnsCommentDetailUI.e(this.nUO, str);
            }
        }
        return false;
    }
}
