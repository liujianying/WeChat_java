package com.tencent.mm.plugin.appbrand.dynamic.widget;

import com.tencent.mm.plugin.report.service.h;

class IPCDynamicPageView$1 implements Runnable {
    final /* synthetic */ IPCDynamicPageView fyl;

    IPCDynamicPageView$1(IPCDynamicPageView iPCDynamicPageView) {
        this.fyl = iPCDynamicPageView;
    }

    public final void run() {
        int i = 1;
        if (!IPCDynamicPageView.a(this.fyl)) {
            IPCDynamicPageView.a(this.fyl, true);
            IPCDynamicPageView.b(this.fyl);
            long currentTimeMillis = System.currentTimeMillis() - IPCDynamicPageView.c(this.fyl);
            if (currentTimeMillis <= 1000) {
                i = 0;
            } else if (currentTimeMillis > 2000) {
                i = currentTimeMillis <= 3000 ? 2 : currentTimeMillis <= 4000 ? 3 : currentTimeMillis <= 5000 ? 4 : currentTimeMillis <= 6000 ? 5 : currentTimeMillis <= 7000 ? 6 : currentTimeMillis <= 8000 ? 7 : currentTimeMillis <= 9000 ? 8 : currentTimeMillis <= 10000 ? 9 : 10;
            }
            h.mEJ.a(645, (long) i, 1, false);
            h.mEJ.a(645, 11, 1, false);
            this.fyl.kg(2107);
        }
        IPCDynamicPageView.a(this.fyl, System.currentTimeMillis());
        IPCDynamicPageView.d(this.fyl).adk();
    }
}
