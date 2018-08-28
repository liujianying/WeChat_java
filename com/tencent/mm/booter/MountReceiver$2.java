package com.tencent.mm.booter;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.x;

class MountReceiver$2 implements Runnable {
    final /* synthetic */ MountReceiver cWT;

    MountReceiver$2(MountReceiver mountReceiver) {
        this.cWT = mountReceiver;
    }

    public final void run() {
        x.d("MicroMsg.MountReceiver", "dkmount [MOUNT] action:%s hasuin:%b", new Object[]{MountReceiver.a(this.cWT), Boolean.valueOf(au.HX())});
        if (au.HX()) {
            g.Ei().DX();
            au.HU();
            c.DV();
            MountReceiver.c(this.cWT).sendEmptyMessage(0);
        }
    }
}
