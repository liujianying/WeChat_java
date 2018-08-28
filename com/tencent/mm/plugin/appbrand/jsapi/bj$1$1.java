package com.tencent.mm.plugin.appbrand.jsapi;

import android.view.WindowManager.LayoutParams;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.bj.1;
import com.tencent.mm.ui.MMActivity;

class bj$1$1 extends b {
    final /* synthetic */ MMActivity bAl;
    final /* synthetic */ LayoutParams fHk;
    final /* synthetic */ 1 fHl;

    bj$1$1(1 1, LayoutParams layoutParams, MMActivity mMActivity) {
        this.fHl = 1;
        this.fHk = layoutParams;
        this.bAl = mMActivity;
    }

    public final void a(c cVar) {
        this.fHk.screenBrightness = this.fHl.fHj.fHg;
        this.bAl.getWindow().setAttributes(this.fHk);
    }

    public final void onResume() {
        this.fHk.screenBrightness = this.fHl.fHj.fHh;
        this.bAl.getWindow().setAttributes(this.fHk);
    }
}
