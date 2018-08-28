package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.plugin.appbrand.appcache.o;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic$b;
import com.tencent.mm.plugin.appbrand.n.a;

final class d implements a {
    d() {
    }

    public final int qA(String str) {
        return AppBrandOpReportLogic$b.tW(str);
    }

    public final void aaT() {
        o.abK();
    }

    public final void k(String str, String str2, int i) {
        SendDataToMiniProgramFromH5Event sendDataToMiniProgramFromH5Event = new SendDataToMiniProgramFromH5Event();
        sendDataToMiniProgramFromH5Event.fQs = str;
        sendDataToMiniProgramFromH5Event.data = str2;
        sendDataToMiniProgramFromH5Event.fQt = i;
        com.tencent.mm.plugin.appbrand.ipc.d.c(sendDataToMiniProgramFromH5Event);
    }
}
