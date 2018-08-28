package com.tencent.mm.app.plugin.b;

import com.tencent.mm.app.plugin.b.a.f;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class a$f$1 implements a {
    final /* synthetic */ f bBf;

    a$f$1(f fVar) {
        this.bBf = fVar;
    }

    public final boolean vD() {
        x.i("MicroMsg.SubCoreExtAgent", "Voice record timeout.");
        this.bBf.bBc = true;
        this.bBf.stopRecord();
        return false;
    }
}
