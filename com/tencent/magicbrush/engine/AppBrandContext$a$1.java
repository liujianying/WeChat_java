package com.tencent.magicbrush.engine;

import com.tencent.magicbrush.engine.AppBrandContext.a;

class AppBrandContext$a$1 implements Runnable {
    final /* synthetic */ a bnx;

    AppBrandContext$a$1(a aVar) {
        this.bnx = aVar;
    }

    public final void run() {
        AppBrandContext.notifyRunTimer(this.bnx.bnw.bnA, AppBrandContext.a(this.bnx.bnw), this.bnx.bnu);
    }
}
