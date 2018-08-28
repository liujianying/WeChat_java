package com.tencent.mm.plugin.shake.d.a;

import android.content.Context;
import com.tencent.mm.plugin.shake.b.d;

class k$1 implements Runnable {
    final /* synthetic */ d mYV;
    final /* synthetic */ Context val$context;

    public k$1(d dVar, Context context) {
        this.mYV = dVar;
        this.val$context = context;
    }

    public final void run() {
        k.a(this.mYV, this.val$context, false);
    }
}
