package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.chatting.viewitems.an.h;

class an$h$1 implements OnClickListener {
    final /* synthetic */ au uff;
    final /* synthetic */ h ufg;

    an$h$1(h hVar, au auVar) {
        this.ufg = hVar;
        this.uff = auVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        rn rnVar = new rn();
        rnVar.ccn.ccq = true;
        a.sFg.m(rnVar);
        h.a(this.ufg, this.uff);
        dialogInterface.dismiss();
    }
}
