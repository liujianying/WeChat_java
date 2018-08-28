package com.tencent.mm.sandbox.updater;

import com.tencent.mm.sdk.platformtools.bi;

class AppUpdaterUI$11 implements Runnable {
    final /* synthetic */ String sDr;
    final /* synthetic */ AppUpdaterUI sDx;

    AppUpdaterUI$11(AppUpdaterUI appUpdaterUI, String str) {
        this.sDx = appUpdaterUI;
        this.sDr = str;
    }

    public final void run() {
        this.sDx.startActivity(bi.WI(this.sDr));
        AppUpdaterUI.f(this.sDx);
    }
}
