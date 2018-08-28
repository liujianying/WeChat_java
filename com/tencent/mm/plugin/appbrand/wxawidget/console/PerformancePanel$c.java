package com.tencent.mm.plugin.appbrand.wxawidget.console;

import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;

class PerformancePanel$c implements a<IPCBoolean, IPCVoid> {
    private PerformancePanel$c() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        if (((IPCBoolean) obj).value) {
            com.tencent.mm.plugin.appbrand.collector.c.ry("widget_launch");
        } else {
            com.tencent.mm.plugin.appbrand.collector.c.rz("widget_launch");
        }
    }
}
