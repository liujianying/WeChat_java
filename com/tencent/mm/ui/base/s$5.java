package com.tencent.mm.ui.base;

import android.view.Window;
import com.tencent.mm.sdk.platformtools.ah;

class s$5 implements Runnable {
    final /* synthetic */ Window gwT;
    final /* synthetic */ o tym;
    final /* synthetic */ int tyn;

    s$5(o oVar, Window window, int i) {
        this.tym = oVar;
        this.gwT = window;
        this.tyn = i;
    }

    public final void run() {
        ah.A(new 1(this));
    }
}
