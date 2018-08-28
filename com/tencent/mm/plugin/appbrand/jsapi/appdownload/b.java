package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.a;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.l;
import java.util.HashMap;

public final class b extends h {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "onDownloadAppStateChange";
    private static HashMap<Integer, b> fHu = new HashMap();
    private a fHt;

    private b(l lVar) {
        this.fHt = new 1(this, lVar);
        MMToClientEvent.a(this.fHt);
        lVar.fdO.fcL.a(new 2(this, lVar));
    }

    public static void f(l lVar) {
        if (!fHu.containsKey(Integer.valueOf(lVar.hashCode()))) {
            fHu.put(Integer.valueOf(lVar.hashCode()), new b(lVar));
        }
    }
}
