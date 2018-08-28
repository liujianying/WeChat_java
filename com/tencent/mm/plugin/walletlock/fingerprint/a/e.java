package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.btl;
import com.tencent.mm.protocal.c.btm;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends l implements k {
    private b diG;
    private com.tencent.mm.ab.e diJ;
    String jgX;
    boolean pGF = false;

    public e(String str, String str2) {
        a aVar = new a();
        aVar.dIG = new btl();
        aVar.dIH = new btm();
        aVar.uri = "/cgi-bin/mmpay-bin/touchlockgetchallenge";
        aVar.dIF = 1548;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        btl btl = (btl) this.diG.dID.dIL;
        btl.scene = 1548;
        btl.onE = str;
        btl.onF = str2;
    }

    public final int getType() {
        return 1548;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetTouchWalletLockChallenge", "alvinluo get touch wallet lock challenge errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        btm btm = (btm) ((b) qVar).dIE.dIL;
        this.jgX = btm.jgX;
        x.d("MicroMsg.NetSceneGetTouchWalletLockChallenge", "alvinluo get touch lock challenge: %s", new Object[]{this.jgX});
        if (btm.soi == 1) {
            this.pGF = true;
        } else {
            this.pGF = false;
        }
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
