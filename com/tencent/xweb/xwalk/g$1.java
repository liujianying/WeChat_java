package com.tencent.xweb.xwalk;

import org.xwalk.core.XWalkV8;

class g$1 implements Runnable {
    final /* synthetic */ int vEU;
    final /* synthetic */ g vEV;

    g$1(g gVar, int i) {
        this.vEV = gVar;
        this.vEU = i;
    }

    public final void run() {
        if (this.vEV.vET == null) {
            this.vEV.vET = new XWalkV8();
            this.vEV.vET.init(this.vEU);
        }
    }
}
