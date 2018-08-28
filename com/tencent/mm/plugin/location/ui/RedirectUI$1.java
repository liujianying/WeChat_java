package com.tencent.mm.plugin.location.ui;

import android.content.Intent;

class RedirectUI$1 implements Runnable {
    final /* synthetic */ double jbn;
    final /* synthetic */ double jbo;
    final /* synthetic */ RedirectUI kFv;
    final /* synthetic */ Intent val$intent;

    RedirectUI$1(RedirectUI redirectUI, Intent intent, double d, double d2) {
        this.kFv = redirectUI;
        this.val$intent = intent;
        this.jbn = d;
        this.jbo = d2;
    }

    public final void run() {
        RedirectUI.a(this.kFv, this.val$intent, this.jbn, this.jbo);
    }
}
