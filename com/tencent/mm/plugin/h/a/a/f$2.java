package com.tencent.mm.plugin.h.a.a;

import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class f$2 implements a {
    final /* synthetic */ f hfj;

    f$2(f fVar) {
        this.hfj = fVar;
    }

    public final boolean vD() {
        if (f.f(this.hfj).size() > 0) {
            x.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now start");
            if (f.g(this.hfj).booleanValue()) {
                x.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan ok");
            } else {
                x.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan fail");
            }
            f.dH(ad.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false));
            if (!f.access$700()) {
                if (!f.h(this.hfj).ciq()) {
                    f.h(this.hfj).SO();
                }
                if (!f.i(this.hfj).ciq()) {
                    f.i(this.hfj).SO();
                }
            }
        }
        return false;
    }
}
