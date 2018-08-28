package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.report.service.h;
import org.json.JSONObject;

public final class d extends a {
    private static final int CTRL_INDEX = 340;
    private static final String NAME = "enableLocationUpdate";
    private volatile f fQX;

    public final void a(l lVar, JSONObject jSONObject, int i) {
        h.mEJ.e(840, 9, 1);
        synchronized (this) {
            if (this.fQX == null) {
                this.fQX = new f(lVar);
                this.fQX.start();
            }
        }
        boolean optBoolean = jSONObject.optBoolean("enable");
        if (optBoolean || i(lVar)) {
            if (!optBoolean) {
                this.fQX.Dd(2);
            } else if (i(lVar)) {
                this.fQX.Dd(1);
            } else {
                h.mEJ.e(840, 11, 1);
                lVar.E(i, f("fail:system permission denied", null));
            }
            h.mEJ.e(840, 10, 1);
            lVar.E(i, f("ok", null));
            return;
        }
        lVar.E(i, f("ok", null));
    }
}
