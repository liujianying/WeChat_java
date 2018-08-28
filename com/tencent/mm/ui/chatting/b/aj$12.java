package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.sdk.b.a;

class aj$12 implements OnClickListener {
    final /* synthetic */ aj tSJ;

    aj$12(aj ajVar) {
        this.tSJ = ajVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        rn rnVar = new rn();
        rnVar.ccn.ccq = true;
        a.sFg.m(rnVar);
        aj.a(this.tSJ, this.tSJ.bAG.getTalkerUserName());
    }
}
