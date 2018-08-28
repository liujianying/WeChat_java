package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.voip.model.b;

class a$a implements Runnable {
    final /* synthetic */ a kpZ;
    private b kqa = null;

    public a$a(a aVar, b bVar) {
        this.kpZ = aVar;
        this.kqa = bVar;
    }

    public final void run() {
        if (this.kqa != null) {
            this.kqa.bJv();
            this.kqa.bJs();
            this.kqa = null;
            this.kpZ.kpY = false;
        }
        au.HV().setMode(0);
    }
}
