package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.storage.n;

class SnsCommentDetailUI$24 implements e {
    final /* synthetic */ n nMf;
    final /* synthetic */ SnsCommentDetailUI nUO;

    SnsCommentDetailUI$24(SnsCommentDetailUI snsCommentDetailUI, n nVar) {
        this.nUO = snsCommentDetailUI;
        this.nMf = nVar;
    }

    public final void d(b bVar, int i) {
        if (i != -1 && SnsCommentDetailUI.A(this.nUO) != null) {
            SnsCommentDetailUI.A(this.nUO).o(this.nMf.field_snsId, false);
        }
    }
}
