package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ayg;
import com.tencent.mm.protocal.c.ayh;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends l implements k {
    private b diG;
    private e diJ;

    public final int getType() {
        return 1967;
    }

    public f(String str, String str2, String str3) {
        a aVar = new a();
        aVar.dIG = new ayg();
        aVar.dIH = new ayh();
        aVar.uri = "/cgi-bin/mmpay-bin/opensotertouchlock";
        aVar.dIF = 1967;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ayg ayg = (ayg) this.diG.dID.dIL;
        x.d("MicroMsg.NetSceneOpenSoterFingerprintLock", "alvinluo json: %s, signature: %s, token: %s", new Object[]{str, str2, str3});
        ayg.sba = str;
        ayg.signature = str2;
        ayg.pjE = str3;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneOpenSoterFingerprintLock", "alvinluo open soter fingerprint lock errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
