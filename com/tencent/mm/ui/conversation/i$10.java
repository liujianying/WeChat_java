package com.tencent.mm.ui.conversation;

import com.tencent.mm.R;

class i$10 implements Runnable {
    final /* synthetic */ int eNW;
    final /* synthetic */ i uqR;

    i$10(i iVar, int i) {
        this.uqR = iVar;
        this.eNW = i;
    }

    public final void run() {
        if (i.h(this.uqR) != null) {
            i.h(this.uqR).setMessage(i.a(this.uqR).getString(R.l.app_loading_data) + this.eNW + "%");
        }
    }
}
