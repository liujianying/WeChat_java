package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.protocal.c.bhc;

class AppBrandOpReportLogic$b$1 implements a {
    final /* synthetic */ String bAj;

    AppBrandOpReportLogic$b$1(String str) {
        this.bAj = str;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        if (i == 0 && i2 == 0) {
            bhc bhc = (bhc) bVar.dIE.dIL;
            if (bhc != null) {
                AppBrandOpReportLogic.b.aE(this.bAj, bhc.shW);
            }
        }
        return 0;
    }
}
