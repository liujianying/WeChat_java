package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.wear.model.d.a;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.protocal.c.cec;

class b$b extends d {
    final /* synthetic */ b pIZ;
    private cec pJa;

    public b$b(b bVar, cec cec) {
        this.pIZ = bVar;
        this.pJa = cec;
    }

    public final void execute() {
        au.DF().a(1091, this.pIZ);
        au.DF().a(new a(this.pJa.szd, "gh_43f2581f6fd6"), 0);
    }

    public final String getName() {
        return "RegisterDeviceTask";
    }
}
