package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.plugin.report.service.h;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class j {
    private static j fuQ = new j();
    public Map<String, b> fuI = new ConcurrentHashMap();

    public static j aeV() {
        return fuQ;
    }

    public final void C(String str, int i, int i2) {
        if (((b) this.fuI.get(str)) != null) {
            b.i("WidgetReporter_14443", "report %s, %s, %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
            h.mEJ.h(14443, new Object[]{r0.appId, Integer.valueOf(0), Integer.valueOf(r0.bGF), Integer.valueOf(2), r0.bOd, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(r0.dCn)});
        }
    }
}
