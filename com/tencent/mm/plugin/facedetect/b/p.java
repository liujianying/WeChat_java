package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.amt;
import com.tencent.mm.protocal.c.avs;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.iz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public abstract class p extends m implements k {
    static String iMG = null;
    protected e diJ = null;

    abstract void AQ(String str);

    abstract void c(int i, int i2, String str, q qVar);

    abstract int g(com.tencent.mm.network.e eVar);

    protected abstract avt g(q qVar);

    protected static String Oj() {
        return iMG;
    }

    public static void AR(String str) {
        iMG = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        if (bi.oW(iMG)) {
            return getType();
        }
        x.i("MicroMsg.NetSceneFaceRsaBase", "hy: has ticket: %s", new Object[]{iMG});
        AQ(iMG);
        return g(eVar);
    }

    public final iz c(q qVar) {
        avt g = g(qVar);
        if (g != null) {
            return g.rhK;
        }
        return null;
    }

    public final avs d(q qVar) {
        avt g = g(qVar);
        if (g != null) {
            return g.rhL;
        }
        return null;
    }

    public final amt e(q qVar) {
        avt g = g(qVar);
        if (g != null) {
            return g.rhJ;
        }
        return null;
    }

    public final void Ld() {
        if (this.diJ != null) {
            this.diJ.a(3, -1, "", this);
        }
    }

    public final e Le() {
        return this.diJ;
    }

    public final void a(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneFaceRsaBase", "hy: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 4 && i2 == -102) {
            x.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[]{Integer.valueOf(qVar.KV().qWA.ver)});
            g.Em().H(new 1(this, r0));
            return;
        }
        c(i, i2, str, qVar);
    }
}
