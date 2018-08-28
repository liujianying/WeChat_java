package com.tencent.mm.plugin.appbrand.debugger;

import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView.1;

class q$1 implements Runnable {
    final /* synthetic */ q ftZ;

    q$1(q qVar) {
        this.ftZ = qVar;
    }

    public final void run() {
        RemoteDebugMoveView a = q.a(this.ftZ);
        int width = this.ftZ.getWidth();
        int height = this.ftZ.getHeight();
        a.setLayoutParams(new LayoutParams(-2, -2));
        a.ftm = width;
        a.ftn = height;
        a.post(new 1(a));
        this.ftZ.addView(q.a(this.ftZ));
    }
}
