package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import android.view.View.OnClickListener;

class h$1 implements OnClickListener {
    final /* synthetic */ j tTK;
    final /* synthetic */ h tVx;

    h$1(h hVar, j jVar) {
        this.tVx = hVar;
        this.tTK = jVar;
    }

    public final void onClick(View view) {
        this.tTK.cxy().tWS.q(this.tVx.tTx.tTy.mController.tml, true);
    }
}
