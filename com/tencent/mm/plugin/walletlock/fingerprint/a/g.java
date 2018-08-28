package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.d.b.e.e;
import com.tencent.d.b.e.e.a;
import com.tencent.mm.ab.b;
import com.tencent.mm.g.a.hw;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.c.btn;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends d implements e, k {
    public b diG;
    private com.tencent.mm.ab.e diJ;
    private String eWo = null;
    private com.tencent.d.b.e.b<e.b> jgZ = null;

    public final /* synthetic */ void bx(Object obj) {
        a aVar = (a) obj;
        b.a aVar2 = new b.a();
        aVar2.dIG = new btn();
        aVar2.dIH = new bto();
        aVar2.uri = "/cgi-bin/mmpay-bin/touchlockupdateauthkey";
        aVar2.dIF = 1244;
        aVar2.dII = 0;
        aVar2.dIJ = 0;
        this.diG = aVar2.KT();
        btn btn = (btn) this.diG.dID.dIL;
        btn.sok = aVar.vmc;
        btn.sol = aVar.vmd;
        btn.soj = this.eWo;
        hw hwVar = new hw();
        hwVar.bRo.bRq = this.eWo;
        com.tencent.mm.sdk.b.a.sFg.m(hwVar);
        btn.bRr = hwVar.bRp.bRr;
        x.v("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "alvinluo wcpaysign: %s", new Object[]{btn.bRr});
    }

    public g(String str) {
        this.eWo = str;
    }

    public final int getType() {
        return 1665;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void d(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "alvinluo onGYNetEnd errType: %d , errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
        if (this.jgZ == null) {
            return;
        }
        if (i == 0 && i2 == 0) {
            this.jgZ.cG(new e.b(true));
        } else {
            this.jgZ.cG(new e.b(false));
        }
    }

    public final void aNJ() {
        x.i("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "hy: authkey required");
        if (this.diJ != null) {
            this.diJ.a(4, -1, "", this);
        }
        if (this.jgZ != null) {
            x.e("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "alvinluo pay auth key expired when upload pay auth key");
            this.jgZ.cG(new e.b(false));
        }
    }

    public final void pS(int i) {
        x.i("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "hy: onError: errType: %d, errcode: %d", new Object[]{Integer.valueOf(3), Integer.valueOf(i)});
        if (this.diJ != null) {
            this.diJ.a(4, -1, "", this);
        }
    }

    public final void execute() {
        com.tencent.mm.kernel.g.DF().a(this, 0);
    }

    public final void a(com.tencent.d.b.e.b<e.b> bVar) {
        this.jgZ = bVar;
    }
}
