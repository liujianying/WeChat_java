package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;

class o$13 implements OnClickListener {
    final /* synthetic */ l bFp;
    final /* synthetic */ o eTO;

    o$13(o oVar, l lVar) {
        this.eTO = oVar;
        this.bFp = lVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.DF().a(701, this.eTO);
        this.eTO.eSA = new g(new 1(this), ((a) this.bFp).getUsername(), ((a) this.bFp).Oi(), this.eTO.eTG.bTi);
        this.eTO.eSA.a(this.eTO.eTG);
    }
}
