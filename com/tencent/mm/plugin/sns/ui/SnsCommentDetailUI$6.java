package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.jt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsCommentDetailUI$6 extends c<jt> {
    final /* synthetic */ SnsCommentDetailUI nUO;

    SnsCommentDetailUI$6(SnsCommentDetailUI snsCommentDetailUI) {
        this.nUO = snsCommentDetailUI;
        this.sFo = jt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        jt jtVar = (jt) bVar;
        if (jtVar instanceof jt) {
            switch (jtVar.bTE.action) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    SnsCommentDetailUI.o(this.nUO);
                    break;
            }
        }
        return false;
    }
}
