package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.mm.bc.a;
import com.tencent.mm.bc.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

public final class c extends n {
    public static final int CTRL_INDEX = 472;
    public static final String NAME = "enableDeviceOrientationChangeListening";
    private boolean fYk = false;
    protected a fYl;
    private b fYm = new 1(this);

    public final String a(l lVar, JSONObject jSONObject) {
        if (jSONObject.optBoolean("enable", false)) {
            e.k(lVar);
            if (!this.fYk) {
                this.fYl = new a(lVar.getContext(), this.fYm);
                this.fYl.enable();
                this.fYk = true;
            }
        } else {
            e.l(lVar);
            if (this.fYk) {
                this.fYl.disable();
                this.fYl = null;
                this.fYk = false;
            }
        }
        return f("ok", null);
    }
}
