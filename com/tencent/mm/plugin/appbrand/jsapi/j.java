package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.plugin.appbrand.report.a.h;
import java.util.HashMap;

public final class j {
    final HashMap<Integer, a> fFi = new HashMap();

    j() {
    }

    public final void H(int i, String str) {
        a aVar = (a) this.fFi.remove(Integer.valueOf(i));
        if (aVar != null) {
            h.a(aVar.fFj.getAppId(), aVar.path, aVar.fFk.getName(), aVar.data, c.a(aVar.fFj, aVar.fFk), System.currentTimeMillis() - aVar.startTime, str);
            this.fFi.remove(Integer.valueOf(i));
        }
    }
}
