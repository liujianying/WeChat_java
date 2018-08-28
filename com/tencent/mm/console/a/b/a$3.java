package com.tencent.mm.console.a.b;

import android.content.Context;

class a$3 implements Runnable {
    final /* synthetic */ b dhA;
    final /* synthetic */ a dhC;
    final /* synthetic */ int dhD;
    final /* synthetic */ String dhE;
    final /* synthetic */ Context val$context;

    a$3(a aVar, String str, int i, b bVar, Context context) {
        this.dhC = aVar;
        this.dhE = str;
        this.dhD = i;
        this.dhA = bVar;
        this.val$context = context;
    }

    public final void run() {
        a.a(this.dhC, this.dhE, this.dhD, this.dhA);
        a.a(this.dhC, this.val$context);
    }
}
