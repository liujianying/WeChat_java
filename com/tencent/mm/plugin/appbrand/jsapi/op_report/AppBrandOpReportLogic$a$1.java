package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.a;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.AppBrandOnOpReportStartEvent;

class AppBrandOpReportLogic$a$1 implements a {
    AppBrandOpReportLogic$a$1() {
    }

    public final void bj(Object obj) {
        if (obj instanceof AppBrandOnOpReportStartEvent) {
            g pY = com.tencent.mm.plugin.appbrand.a.pY(((AppBrandOnOpReportStartEvent) obj).appId);
            if (pY != null) {
                a.tm(pY.mAppId);
            }
        }
    }
}
