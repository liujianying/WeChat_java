package com.tencent.mm.plugin.h.a.a;

import com.tencent.mm.sdk.platformtools.x;
import java.util.UUID;

class f$6 implements Runnable {
    final /* synthetic */ f hfj;
    final /* synthetic */ UUID hfl;

    public f$6(f fVar, UUID uuid) {
        this.hfj = fVar;
        this.hfl = uuid;
    }

    public final void run() {
        if (!f.a(this.hfj, this.hfl)) {
            x.e("MicroMsg.exdevice.IBeaconServer", "startRanging failed!!!");
        }
    }
}
