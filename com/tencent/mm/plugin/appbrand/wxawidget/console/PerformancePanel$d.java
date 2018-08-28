package com.tencent.mm.plugin.appbrand.wxawidget.console;

import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;

class PerformancePanel$d implements a<IPCBoolean, IPCVoid> {
    private PerformancePanel$d() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        com.tencent.mm.plugin.appbrand.collector.c.cx(((IPCBoolean) obj).value);
    }
}
