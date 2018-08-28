package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.qo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsCommentDetailUI$12 extends c<qo> {
    final /* synthetic */ SnsCommentDetailUI nUO;

    SnsCommentDetailUI$12(SnsCommentDetailUI snsCommentDetailUI) {
        this.nUO = snsCommentDetailUI;
        this.sFo = qo.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qo qoVar = (qo) bVar;
        if (qoVar instanceof qo) {
            String str = qoVar.cbe.id;
            if (qoVar.cbe.type == 1) {
                SnsCommentDetailUI.b(this.nUO, str);
            } else if (qoVar.cbe.type == 2) {
                SnsCommentDetailUI.c(this.nUO, str);
            }
        }
        return false;
    }
}
