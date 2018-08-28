package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bym;
import com.tencent.mm.protocal.c.byn;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;

public final class c extends a implements k {
    al dHa;
    private b diG;
    e diJ;
    int ehi;
    boolean eoE;
    private long eqk;
    private boolean eql;
    private int eqm;
    private String[] eqn;
    String filename;
    int retCode;

    public final void TR() {
        this.eoE = true;
    }

    public final String[] TS() {
        return this.eqn;
    }

    public final long TT() {
        return this.eqk;
    }

    public final Set<String> TU() {
        return null;
    }

    public c(String str, int i) {
        this.retCode = 0;
        this.ehi = 0;
        this.filename = null;
        this.eqk = -1;
        this.eql = false;
        this.eoE = false;
        this.eqn = new String[0];
        this.dHa = new al(new 1(this), true);
        this.eqk = bi.VF();
        this.filename = str;
        this.eqm = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 3960;
        this.diJ = eVar2;
        int cm = com.tencent.mm.a.e.cm(this.filename);
        x.d("MicroMsg.NetSceneVoiceAddr", g.Ac() + " read file:" + this.filename + " filelen:" + cm + " oldoff:" + this.ehi + " isFin:" + this.eoE);
        if (cm <= 0) {
            x.e("MicroMsg.NetSceneVoiceAddr", "read failed :" + this.filename);
            this.retCode = g.getLine() + 40000;
            return -1;
        }
        int i2 = cm - this.ehi;
        if (i2 <= 3960) {
            if (i2 >= 3300 || this.eoE) {
                if (this.eoE) {
                    this.eql = true;
                }
                i = i2;
            } else {
                x.e("MicroMsg.NetSceneVoiceAddr", g.Ac() + " read failed :" + this.filename + "can read:" + i2 + " isfinish:" + this.eoE);
                this.retCode = g.getLine() + 40000;
                return -1;
            }
        }
        x.d("MicroMsg.NetSceneVoiceAddr", g.Ac() + " read file:" + this.filename + " filelen:" + cm + " oldoff:" + this.ehi + " isFin:" + this.eoE + " endFlag:" + this.eql);
        byte[] e = com.tencent.mm.a.e.e(this.filename, this.ehi, i);
        if (e == null) {
            x.e("MicroMsg.NetSceneVoiceAddr", g.Ac() + " read failed :" + this.filename + " read:" + i);
            this.retCode = g.getLine() + 40000;
            return -1;
        }
        a aVar = new a();
        aVar.dIG = new bym();
        aVar.dIH = new byn();
        aVar.uri = "/cgi-bin/micromsg-bin/voiceaddr";
        aVar.dIF = 206;
        aVar.dII = 94;
        aVar.dIJ = 1000000094;
        this.diG = aVar.KT();
        bym bym = (bym) this.diG.dID.dIL;
        bym.rtW = new bhy().bq(e);
        x.d("MicroMsg.NetSceneVoiceAddr", g.Ac() + " read file:" + this.filename + " readlen:" + e.length + " datalen:" + bym.rtW.siK.toByteArray().length + " dataiLen:" + bym.rtW.siI + " md5:" + com.tencent.mm.a.g.u(e) + " datamd5:" + com.tencent.mm.a.g.u(bym.rtW.siK.toByteArray()));
        bym.hbL = (String) com.tencent.mm.kernel.g.Ei().DT().get(2, "");
        bym.rjC = this.ehi;
        bym.sso = this.eqk;
        bym.rgC = this.eql ? 1 : 0;
        bym.ssp = 0;
        bym.reb = 0;
        bym.ssq = 0;
        bym.rdY = 0;
        bym.sut = this.eqm;
        x.d("MicroMsg.NetSceneVoiceAddr", "clientId " + this.eqk);
        return a(eVar, this.diG, this);
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    protected final int Cc() {
        return 20;
    }

    protected final void a(l.a aVar) {
        this.diJ.a(3, g.getLine() + 40000, "ecurityCheckError", this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneVoiceAddr", g.Ac() + " onGYNetEnd file:" + this.filename + " errtype:" + i2 + " errCode:" + i3);
        bym bym = (bym) ((b) qVar).dID.dIL;
        byn byn = (byn) ((b) qVar).dIE.dIL;
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneVoiceAddr", g.Ac() + " onGYNetEnd  file:" + this.filename + " endflag:" + byn.rgC + " lst:" + byn.rgF);
            if (bym.rgC == 1) {
                this.eqn = new String[byn.rgF.size()];
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 < byn.rgF.size()) {
                        this.eqn[i5] = ((bhz) byn.rgF.get(i5)).siM;
                        i4 = i5 + 1;
                    } else {
                        this.diJ.a(i2, i3, str, this);
                        return;
                    }
                }
            }
            this.ehi = bym.rtW.siI + bym.rjC;
            long j = this.eoE ? 0 : 500;
            x.d("MicroMsg.NetSceneVoiceAddr", "onGYNetEnd file:" + this.filename + " delay:" + j);
            this.dHa.J(j, j);
            return;
        }
        x.e("MicroMsg.NetSceneVoiceAddr", g.Ac() + " onGYNetEnd file:" + this.filename + " errType:" + i2 + " errCode:" + i3);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 206;
    }
}
