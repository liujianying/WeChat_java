package com.tencent.mm.ui;

import com.tencent.mm.sdk.platformtools.ah;

class aa$9 implements Runnable {
    final /* synthetic */ aa toC;

    aa$9(aa aaVar) {
        this.toC = aaVar;
    }

    public final void run() {
        this.toC.tox = true;
        ah.M(this.toC.toy);
        ah.i(this.toC.toy, 300);
    }
}
