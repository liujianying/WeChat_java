package com.tencent.mm.plugin.appbrand.page.a;

import com.tencent.mm.plugin.appbrand.widget.actionbar.b;

class a$1 implements Runnable {
    final /* synthetic */ a gpn;

    a$1(a aVar) {
        this.gpn = aVar;
    }

    public final void run() {
        boolean z = true;
        b bVar = (b) this.gpn.fNZ.gnn;
        int[] iArr = new int[2];
        this.gpn.fNZ.getContentView().getLocationOnScreen(iArr);
        if (iArr[1] <= 0) {
            z = false;
        }
        bVar.dl(z);
    }
}
