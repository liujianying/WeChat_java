package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.j;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.account.friend.a.r.b;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.brj;
import com.tencent.mm.protocal.c.sy;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public final class z extends l implements k {
    public q dJM;
    private int dJp;
    private e diJ;

    public static class a extends j {
        private r$a eKT = new r$a();
        private b eKU = new b();

        public final int getType() {
            return 481;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/emailreg";
        }

        public final com.tencent.mm.protocal.k.e Id() {
            return this.eKU;
        }

        protected final d Ic() {
            return this.eKT;
        }

        public final int KP() {
            return 1;
        }
    }

    private z(int i, String str, String str2, String str3) {
        this.dJp = 2;
        this.dJM = new a();
        r$a r_a = (r$a) this.dJM.KV();
        r_a.eKz.rfe = i;
        r_a.eKz.rhg = str;
        r_a.eKz.iwP = w.chP();
        r_a.eKz.rhI = bi.WN(str2);
        r_a.eKz.rwg = str3;
        sy syVar = r_a.eKz;
        g.Eg();
        syVar.reS = com.tencent.mm.kernel.a.DA();
        r_a.eKz.rwh = com.tencent.mm.compatible.e.q.getSimCountryIso();
        r_a.eKz.rwi = 1;
    }

    public z(String str, String str2, String str3) {
        this(2, str, str2, str3);
    }

    public z(String str, String str2) {
        this(1, str, str2, "");
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dJM, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:%d errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        b bVar = (b) qVar.Id();
        if (i2 == 4 && i3 == -301) {
            av.a(true, bVar.eKA.rhK, bVar.eKA.rhL, bVar.eKA.rhJ);
            this.dJp--;
            if (this.dJp <= 0) {
                this.diJ.a(3, -1, "", this);
            } else {
                a(this.dIX, this.diJ);
            }
        } else if (i2 == 0 && i3 == 0) {
            av.a(false, bVar.eKA.rhK, bVar.eKA.rhL, bVar.eKA.rhJ);
            this.diJ.a(i2, i3, str, this);
        } else {
            x.e("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            this.diJ.a(i2, i3, str, this);
        }
    }

    protected final int Cc() {
        return 5;
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    public final int Ro() {
        bnp bnp = ((b) this.dJM.Id()).eKA.reD;
        if (!(bnp == null || bnp.slI == null || bnp.slI.size() <= 0)) {
            Iterator it = bnp.slI.iterator();
            while (it.hasNext()) {
                brj brj = (brj) it.next();
                if (brj.mEb == 1) {
                    return bi.getInt(brj.spx, 0);
                }
            }
        }
        return 0;
    }

    public final int getType() {
        return 481;
    }
}
