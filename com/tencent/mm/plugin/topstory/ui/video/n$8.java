package com.tencent.mm.plugin.topstory.ui.video;

import android.view.View;
import android.view.View.OnClickListener;

class n$8 implements OnClickListener {
    final /* synthetic */ n oBM;

    n$8(n nVar) {
        this.oBM = nVar;
    }

    public final void onClick(View view) {
        n.b(this.oBM).bHQ().a(this.oBM, true);
        if (n.c(this.oBM) != null) {
            n.c(this.oBM).bID();
            n.y(this.oBM);
        }
    }
}
