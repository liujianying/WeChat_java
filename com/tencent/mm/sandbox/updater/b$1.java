package com.tencent.mm.sandbox.updater;

import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.protocal.c.aix;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class b$1 implements a {
    final /* synthetic */ b sDH;

    b$1(b bVar) {
        this.sDH = bVar;
    }

    public final void a(int i, int i2, bhp bhp) {
        if (i == 200 && i2 == 0 && (bhp == null || bhp.six.rfn == 0)) {
            aix aix = (aix) bhp;
            x.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : file dir = " + e.bnC);
            x.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : total len = " + aix.rdV);
            x.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : start pos = " + aix.rdW);
            x.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : data len = " + aix.rdX);
            if (aix.rdX <= 0 || aix.rtW == null) {
                x.e("MicroMsg.NetSceneGetUpdatePack", "data is null");
                b.c(this.sDH).a(i, -1, null);
            } else if (aix.rtW.siI != aix.rdX) {
                x.e("MicroMsg.NetSceneGetUpdatePack", "data len not match with data buf, dataLen = " + aix.rdX + " data buf len = " + aix.rtW.siI);
                b.c(this.sDH).a(4, -1, null);
            } else if (aix.rdW < 0 || aix.rdW + aix.rdX > aix.rdV) {
                x.e("MicroMsg.NetSceneGetUpdatePack", "startPos = " + aix.rdW + " dataLen = " + aix.rdX + " totalLen = " + aix.rdV);
                b.c(this.sDH).a(4, -1, null);
            } else if (aix.rdV <= 0) {
                x.e("MicroMsg.NetSceneGetUpdatePack", "totalLen is invalid: totalLen = " + aix.rdV);
                b.c(this.sDH).a(4, -1, null);
            } else {
                int a = com.tencent.mm.a.e.a(c.sDh, b.d(this.sDH), ".temp", aix.rtW.siK.toByteArray());
                if (a != 0) {
                    x.e("MicroMsg.NetSceneGetUpdatePack", "appendBuf failed : " + a);
                    b.c(this.sDH).a(4, -1, null);
                    return;
                }
                b.a(this.sDH, aix.rdX + aix.rdW);
                b.b(this.sDH, aix.rdV);
                b.c(this.sDH).co(aix.rdV, aix.rdW);
                if (aix.rdW + aix.rdX >= aix.rdV) {
                    try {
                        if (b.f(this.sDH).equalsIgnoreCase(g.cu(b.e(this.sDH)))) {
                            com.tencent.mm.a.e.i(c.sDh, b.g(this.sDH) + ".temp", b.h(this.sDH) + ".apk");
                            b.c(this.sDH).a(200, 0, bhp);
                            return;
                        }
                        x.e("MicroMsg.NetSceneGetUpdatePack", "update pack check error");
                        new File(b.i(this.sDH)).delete();
                        b.c(this.sDH).a(-1, -1, bhp);
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e, "", new Object[0]);
                        return;
                    }
                }
                this.sDH.a(b.c(this.sDH));
            }
        } else if (this.sDH.cgM() || b.a(this.sDH) >= b.b(this.sDH).length * 5) {
            b.c(this.sDH).a(i, i2, bhp);
        } else {
            this.sDH.a(b.c(this.sDH));
        }
    }

    public final void fV(long j) {
        b.c(this.sDH).fV(j);
    }

    public final void fW(long j) {
        b.c(this.sDH).fW(j);
    }

    public final void co(int i, int i2) {
    }
}
