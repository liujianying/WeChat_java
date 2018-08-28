package com.tencent.mm.ui.conversation;

class j$8 implements Runnable {
    final /* synthetic */ j ure;

    j$8(j jVar) {
        this.ure = jVar;
    }

    public final void run() {
        if (this.ure.thisActivity() != null) {
            this.ure.thisActivity().supportInvalidateOptionsMenu();
        }
    }
}
