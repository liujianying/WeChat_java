package com.tencent.mm.plugin.sns.f;

import android.view.View;

class b$2 implements Runnable {
    final /* synthetic */ View ntO;
    final /* synthetic */ b ntP;
    final /* synthetic */ View val$view;

    b$2(b bVar, View view, View view2) {
        this.ntP = bVar;
        this.val$view = view;
        this.ntO = view2;
    }

    public final void run() {
        b.a(this.ntP, this.val$view, this.ntO);
    }
}
