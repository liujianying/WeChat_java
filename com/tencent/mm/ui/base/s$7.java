package com.tencent.mm.ui.base;

import android.app.Activity;

class s$7 implements Runnable {
    final /* synthetic */ Activity ews;
    final /* synthetic */ o tym;
    final /* synthetic */ int tyq;

    s$7(o oVar, Activity activity, int i) {
        this.tym = oVar;
        this.ews = activity;
        this.tyq = i;
    }

    public final void run() {
        this.tym.showAtLocation(this.ews.getWindow().getDecorView(), 48, 0, this.tyq);
    }
}
