package com.tencent.mm.plugin.appbrand.wxawidget.console;

import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;

class PerformancePanel$b implements a<IPCBoolean, IPCVoid> {
    private PerformancePanel$b() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        if (((IPCBoolean) obj).value) {
            com.tencent.mm.plugin.appbrand.collector.c.ry("jsapi_draw_canvas");
        } else {
            com.tencent.mm.plugin.appbrand.collector.c.rz("jsapi_draw_canvas");
        }
    }
}
