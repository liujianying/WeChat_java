package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.k.b;
import com.tencent.mm.plugin.sns.ui.SnsCommentFooter.c;

class SnsCommentFooter$6 implements OnClickListener {
    final /* synthetic */ SnsCommentFooter nVN;
    final /* synthetic */ c nVP;

    SnsCommentFooter$6(SnsCommentFooter snsCommentFooter, c cVar) {
        this.nVN = snsCommentFooter;
        this.nVP = cVar;
    }

    public final void onClick(View view) {
        com.tencent.mm.ui.tools.a.c Gi = com.tencent.mm.ui.tools.a.c.d(SnsCommentFooter.a(this.nVN)).Gi(b.Aw());
        Gi.uCR = true;
        Gi.a(new 1(this));
    }
}
