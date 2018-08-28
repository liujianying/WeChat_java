package com.tencent.mm.console.a.b;

import android.content.Context;

class a$2 implements Runnable {
    final /* synthetic */ a dhC;
    final /* synthetic */ int dhD;
    final /* synthetic */ Context val$context;

    a$2(a aVar, int i, Context context) {
        this.dhC = aVar;
        this.dhD = i;
        this.val$context = context;
    }

    public final void run() {
        a.gb(this.dhD);
        a.a(this.dhC, this.val$context);
    }
}
