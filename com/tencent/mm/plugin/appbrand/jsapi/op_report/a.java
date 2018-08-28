package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.mm.plugin.appbrand.jsapi.h;

final class a extends h {
    private static final int CTRL_INDEX = 246;
    private static final String NAME = "onStartReportPageData";
    private static final a fWG = new a();

    a() {
    }

    static synchronized void tm(String str) {
        synchronized (a.class) {
            fWG.aC(str, 0).ahM();
        }
    }
}
