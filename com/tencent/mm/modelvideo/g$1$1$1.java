package com.tencent.mm.modelvideo;

import com.tencent.mm.modelvideo.g.1.1;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class g$1$1$1 implements Runnable {
    final /* synthetic */ 1 emC;

    g$1$1$1(1 1) {
        this.emC = 1;
    }

    public final void run() {
        g.m(this.emC.emB.emA);
        g.g(this.emC.emB.emA).status = 104;
        g.g(this.emC.emB.emA).createTime = bi.VE();
        g.g(this.emC.emB.emA).enK = bi.VE();
        g.g(this.emC.emB.emA).emu = 0;
        g.g(this.emC.emB.emA).bWA = 1800;
        boolean e = t.e(g.g(this.emC.emB.emA));
        x.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[]{g.a(this.emC.emB.emA), Boolean.valueOf(g.h(this.emC.emB.emA)), Boolean.valueOf(e), Long.valueOf(g.g(this.emC.emB.emA).createTime)});
        this.emC.emB.emA.a(g.n(this.emC.emB.emA), g.f(this.emC.emB.emA));
    }
}
