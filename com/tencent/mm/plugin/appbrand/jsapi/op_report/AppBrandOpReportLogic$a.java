package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;

public final class AppBrandOpReportLogic$a {
    private static boolean fWr = false;

    public static synchronized void aju() {
        synchronized (AppBrandOpReportLogic$a.class) {
            if (!fWr) {
                MMToClientEvent.a(new 1());
                fWr = true;
            }
        }
    }
}
