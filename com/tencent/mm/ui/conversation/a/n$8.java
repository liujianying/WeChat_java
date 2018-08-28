package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.MMAppMgr;

class n$8 implements OnClickListener {
    final /* synthetic */ int bpX;
    final /* synthetic */ n usU;

    n$8(n nVar, int i) {
        this.usU = nVar;
        this.bpX = i;
    }

    public final void onClick(View view) {
        MMAppMgr.a((Context) this.usU.qJS.get(), this.bpX, new 1(this), new 2(this));
    }
}
