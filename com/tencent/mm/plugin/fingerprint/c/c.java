package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.d.b.e.e;
import com.tencent.d.b.e.e.a;
import com.tencent.mm.ab.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.c.bqm;
import com.tencent.mm.protocal.c.bqn;
import com.tencent.mm.sdk.platformtools.x;
import com.tenpay.android.wechat.TenpayUtil;
import org.json.JSONObject;

public final class c extends d implements e, k {
    public b diG;
    private com.tencent.mm.ab.e diJ;
    private String eWo = null;
    private com.tencent.d.b.e.b<e.b> jgZ = null;

    public final /* synthetic */ void bx(Object obj) {
        a aVar = (a) obj;
        b.a aVar2 = new b.a();
        aVar2.dIG = new bqm();
        aVar2.dIH = new bqn();
        aVar2.uri = "/cgi-bin/mmpay-bin/soterupdateauthkey";
        aVar2.dIF = 1665;
        aVar2.dII = 0;
        aVar2.dIJ = 0;
        this.diG = aVar2.KT();
        bqm bqm = (bqm) this.diG.dID.dIL;
        bqm.soj = this.eWo;
        bqm.sok = aVar.vmc;
        bqm.sol = aVar.vmd;
        bqm.bRr = TenpayUtil.signWith3Des("passwd=" + bqm.soj);
        try {
            JSONObject jSONObject = new JSONObject(aVar.vmc);
            com.tencent.mm.plugin.soter.c.b.eQ(jSONObject.getString("cpu_id"), jSONObject.getString("uid"));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", e, "save device info exception", new Object[0]);
        }
    }

    public c(String str) {
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
        x.d("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "onGYNetEnd errType: %d , errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
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
        x.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: authkey required");
        if (this.diJ != null) {
            this.diJ.a(4, -1, "", this);
        }
        if (this.jgZ != null) {
            x.e("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "alvinluo pay auth key expired when upload pay auth key");
            this.jgZ.cG(new e.b(false));
        }
    }

    public final void pS(int i) {
        x.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: onError: errType: %d, errcode: %d", new Object[]{Integer.valueOf(3), Integer.valueOf(i)});
        if (this.diJ != null) {
            this.diJ.a(4, -1, "", this);
        }
    }

    public final void execute() {
        g.DF().a(this, 0);
    }

    public final void a(com.tencent.d.b.e.b<e.b> bVar) {
        this.jgZ = bVar;
    }
}
