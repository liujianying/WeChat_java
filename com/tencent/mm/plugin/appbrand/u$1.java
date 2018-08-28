package com.tencent.mm.plugin.appbrand;

import android.content.Context;

class u$1 implements Runnable {
    final /* synthetic */ String dhF;
    final /* synthetic */ int fen;
    final /* synthetic */ u feo;
    final /* synthetic */ Context val$context;

    u$1(u uVar, Context context, String str, int i) {
        this.feo = uVar;
        this.val$context = context;
        this.dhF = str;
        this.fen = i;
    }

    public final void run() {
        m.f(this.val$context, this.dhF, this.fen);
    }
}
