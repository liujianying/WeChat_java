package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.g.a.kc;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.chatting.b.ab.4;

class ab$4$1 implements OnCancelListener {
    final /* synthetic */ kc tRk;
    final /* synthetic */ 4 tRl;

    ab$4$1(4 4, kc kcVar) {
        this.tRl = 4;
        this.tRk = kcVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.tRk.bUs.bTN = true;
        a.sFg.m(this.tRk);
    }
}
