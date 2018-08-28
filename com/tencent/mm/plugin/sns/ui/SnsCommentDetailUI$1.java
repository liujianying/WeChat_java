package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.qn;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsCommentDetailUI$1 extends c<qn> {
    final /* synthetic */ SnsCommentDetailUI nUO;

    SnsCommentDetailUI$1(SnsCommentDetailUI snsCommentDetailUI) {
        this.nUO = snsCommentDetailUI;
        this.sFo = qn.class.getName().hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean a(b bVar) {
        qn qnVar = (qn) bVar;
        if (qnVar instanceof qn) {
            String str = qnVar.cbc.id;
            String str2 = qnVar.cbc.result;
            String str3 = qnVar.cbc.cbd;
            if (qnVar.cbc.type == 1) {
                SnsCommentDetailUI.a(this.nUO, str, str2, str3);
            } else if (qnVar.cbc.type == 2) {
                SnsCommentDetailUI.a(this.nUO, str);
            }
        }
        return false;
    }
}
