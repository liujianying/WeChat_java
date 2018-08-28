package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.storage.ab;

class SnsCommentDetailUI$31 implements OnClickListener {
    final /* synthetic */ ab eLI;
    final /* synthetic */ n nMf;
    final /* synthetic */ SnsCommentDetailUI nUO;

    SnsCommentDetailUI$31(SnsCommentDetailUI snsCommentDetailUI, n nVar, ab abVar) {
        this.nUO = snsCommentDetailUI;
        this.nMf = nVar;
        this.eLI = abVar;
    }

    public final void onClick(View view) {
        c cVar = new c(this.nMf.bBn(), 24, 2, "", this.nMf.bBr(), this.nMf.bAK());
        g.Ek();
        g.Eh().dpP.a(cVar, 0);
        SnsCommentDetailUI.b(this.nUO).b(this.eLI.BL(), null);
        SnsCommentDetailUI.b(this.nUO).ir(true);
        SnsCommentDetailUI.B(this.nUO).setVisibility(8);
        SnsCommentDetailUI.u(this.nUO);
    }
}
