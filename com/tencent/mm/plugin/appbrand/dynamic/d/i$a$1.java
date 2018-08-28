package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.plugin.appbrand.dynamic.d.i.a;

class i$a$1 implements r {
    final /* synthetic */ c dmx;
    final /* synthetic */ Bundle fwb;
    final /* synthetic */ a fwi;

    i$a$1(a aVar, Bundle bundle, c cVar) {
        this.fwi = aVar;
        this.fwb = bundle;
        this.dmx = cVar;
    }

    public final void b(boolean z, String str, Bundle bundle) {
        this.fwb.putBoolean("ret", z);
        this.fwb.putString("reason", str);
        this.fwb.putBundle("data", bundle);
        this.dmx.at(this.fwb);
    }
}
