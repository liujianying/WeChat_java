package com.tencent.mm.plugin.appbrand.report;

import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport.b;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandIDKeyBatchReport$b$1 implements a {
    AppBrandIDKeyBatchReport$b$1() {
    }

    public final boolean vD() {
        b.amB();
        x.d("MicroMsg.AppBrandIDKeyBatchReport", "on timer expired in monitor timer!");
        return true;
    }
}
