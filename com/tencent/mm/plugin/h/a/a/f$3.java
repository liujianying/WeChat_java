package com.tencent.mm.plugin.h.a.a;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class f$3 implements a {
    final /* synthetic */ f hfj;

    f$3(f fVar) {
        this.hfj = fVar;
    }

    public final boolean vD() {
        if (f.f(this.hfj).size() <= 0) {
            return false;
        }
        x.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now stop");
        f.j(this.hfj);
        if (f.i(this.hfj).ciq()) {
            f.i(this.hfj).J(2000, 2000);
        }
        return true;
    }
}
