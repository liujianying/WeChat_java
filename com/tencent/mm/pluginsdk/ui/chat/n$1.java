package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnLongClickListener;

class n$1 implements OnLongClickListener {
    final /* synthetic */ n qNT;

    n$1(n nVar) {
        this.qNT = nVar;
    }

    public final boolean onLongClick(View view) {
        if (n.a(this.qNT)) {
            n.b(this.qNT);
        }
        return true;
    }
}
