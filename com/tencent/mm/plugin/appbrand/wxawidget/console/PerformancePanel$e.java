package com.tencent.mm.plugin.appbrand.wxawidget.console;

import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.collector.c;

class PerformancePanel$e implements i<IPCString, IPCString> {
    private PerformancePanel$e() {
    }

    public final /* synthetic */ Object av(Object obj) {
        return new IPCString(c.rx(((IPCString) obj).value).toString());
    }
}
