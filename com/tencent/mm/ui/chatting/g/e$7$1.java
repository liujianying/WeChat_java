package com.tencent.mm.ui.chatting.g;

import com.tencent.mm.ui.chatting.g.e.7;

class e$7$1 implements Runnable {
    final /* synthetic */ int tYy;
    final /* synthetic */ 7 tYz;

    e$7$1(7 7, int i) {
        this.tYz = 7;
        this.tYy = i;
    }

    public final void run() {
        this.tYz.tYu.tYp.tNF = false;
        if (e.c(this.tYz.tYu) != null) {
            e.c(this.tYz.tYu).y(this.tYz.tXV, this.tYy);
        }
    }
}
