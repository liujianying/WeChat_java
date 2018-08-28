package com.tencent.mm.plugin.h.a.a;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class f$5 implements a {
    final /* synthetic */ f hfj;

    f$5(f fVar) {
        this.hfj = fVar;
    }

    public final boolean vD() {
        x.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]time out ,let's stop this new method scan");
        f.k(this.hfj);
        return false;
    }
}
