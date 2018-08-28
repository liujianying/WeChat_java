package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements Runnable {
    final /* synthetic */ b ncT;
    final /* synthetic */ double ncU;

    public b$3(b bVar, double d) {
        this.ncT = bVar;
        this.ncU = d;
    }

    public final void run() {
        x.i("MicroMsg.SightPlayController", "SeekToFrame   %f  %s", new Object[]{Double.valueOf(this.ncU), bi.cjd().toString()});
        b.a(this.ncT, this.ncU);
    }
}
