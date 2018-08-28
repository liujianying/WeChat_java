package com.tencent.xweb.xwalk;

import java.util.TimerTask;

public class XWAppBrandEngine$a extends TimerTask {
    public int bnu;
    public boolean vEA;
    final /* synthetic */ XWAppBrandEngine vEB;

    public XWAppBrandEngine$a(XWAppBrandEngine xWAppBrandEngine, int i, boolean z) {
        this.vEB = xWAppBrandEngine;
        this.bnu = i;
        this.vEA = z;
    }

    public final void run() {
        if (!XWAppBrandEngine.a(this.vEB)) {
            XWAppBrandEngine.c(this.vEB).post(new 2(this));
        } else if (!this.vEA) {
            synchronized (this.vEB.vEz) {
                this.vEB.vEz.add(new 1(this));
            }
        }
    }
}
