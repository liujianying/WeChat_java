package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.R;

class e$6 implements Runnable {
    final /* synthetic */ e ltL;

    public e$6(e eVar) {
        this.ltL = eVar;
    }

    public final void run() {
        this.ltL.koX.stop();
        this.ltL.koX.o(R.k.playend, 0, true);
    }
}
