package com.tencent.mm.ui.chatting.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.chatting.b.b.m;

class ai$1 implements OnClickListener {
    final /* synthetic */ Boolean tSE;
    final /* synthetic */ ai tSF;

    ai$1(ai aiVar, Boolean bool) {
        this.tSF = aiVar;
        this.tSE = bool;
    }

    public final void onClick(View view) {
        if (this.tSE.booleanValue()) {
            ai.a(this.tSF, Boolean.valueOf(true), Boolean.valueOf(true));
            ((m) this.tSF.bAG.O(m.class)).cvb().cej();
            return;
        }
        ai.a(this.tSF, Boolean.valueOf(true), Boolean.valueOf(false));
        ((m) this.tSF.bAG.O(m.class)).cvb().setMode(2);
    }
}
