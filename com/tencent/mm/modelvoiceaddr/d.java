package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bwa;
import com.tencent.mm.protocal.c.bwb;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;

public final class d extends a implements k {
    al dHa;
    private b diG;
    e diJ;
    int ehi;
    boolean eoE;
    private long eqk;
    private boolean eql;
    private String[] eqn;
    private int eqp;
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

    public d(String str, int i) {
        this.retCode = 0;
        this.eoE = false;
        this.ehi = 0;
        this.filename = null;
        this.eqk = -1;
        this.eql = false;
        this.eqp = 0;
        this.eqn = new String[0];
        this.dHa = new al(new 1(this), true);
        this.eqk = (long) (bi.VF()).hashCode();
        this.filename = str;
        this.eqp = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        int cm = com.tencent.mm.a.e.cm(this.filename);
        x.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %d, isFin: %b", new Object[]{this.filename, Integer.valueOf(cm), Integer.valueOf(this.ehi), Boolean.valueOf(this.eoE)});
        if (cm <= 0) {
            x.e("MicroMsg.NetSceneVoiceInput", "read failed :" + this.filename);
            this.retCode = g.getLine() + 40000;
            return -1;
        }
        int i = cm - this.ehi;
        if (i > 3960) {
            i = 3960;
        } else if (i < 3300 && !this.eoE) {
            x.e("MicroMsg.NetSceneVoiceInput", g.Ac() + " read failed :" + this.filename + "can read:" + i + " isfinish:" + this.eoE);
            this.retCode = g.getLine() + 40000;
            return -1;
        } else if (this.eoE) {
            this.eql = true;
        }
        x.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %b, isFin:%b, endFlag: %b", new Object[]{this.filename, Integer.valueOf(cm), Boolean.valueOf(this.eoE), Boolean.valueOf(this.eoE), Boolean.valueOf(this.eql)});
        byte[] e = com.tencent.mm.a.e.e(this.filename, this.ehi, i);
        if (e == null) {
            x.e("MicroMsg.NetSceneVoiceInput", g.Ac() + " read failed :" + this.filename + " read:" + i);
            this.retCode = g.getLine() + 40000;
            return -1;
        }
        a aVar = new a();
        aVar.dIG = new bwa();
        aVar.dIH = new bwb();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
        aVar.dIF = 349;
        aVar.dII = 158;
        aVar.dIJ = 1000000158;
        this.diG = aVar.KT();
        bwa bwa = (bwa) this.diG.dID.dIL;
        bwa.hbL = (String) com.tencent.mm.kernel.g.Ei().DT().get(2, "");
        bwa.rtW = new bhy().bq(e);
        x.d("MicroMsg.NetSceneVoiceInput", g.Ac() + " read file:" + this.filename + " readlen:" + e.length + " datalen:" + bwa.rtW.siK.toByteArray().length + " dataiLen:" + bwa.rtW.siI + " md5:" + com.tencent.mm.a.g.u(e) + " datamd5:" + com.tencent.mm.a.g.u(bwa.rtW.siK.toByteArray()));
        bwa.rjC = this.ehi;
        bwa.sso = this.eqk;
        bwa.rgC = this.eql ? 1 : 0;
        bwa.ssp = 0;
        bwa.reb = 0;
        bwa.ssq = this.eqp;
        bwa.rdY = 0;
        x.d("MicroMsg.NetSceneVoiceInput", "clientId " + this.eqk);
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
        x.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " errtype:" + i2 + " errCode:" + i3);
        bwa bwa = (bwa) ((b) qVar).dID.dIL;
        bwb bwb = (bwb) ((b) qVar).dIE.dIL;
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneVoiceInput", g.Ac() + " onGYNetEnd  file:" + this.filename + " endflag:" + bwb.rgC);
            if (bwa.rgC == 1) {
                if (!(bwb.ssr == null || bwb.ssr.siK == null)) {
                    this.eqn = new String[]{bwb.ssr.siK.cfV()};
                }
                this.diJ.a(i2, i3, str, this);
                return;
            }
            this.ehi = bwa.rtW.siI + bwa.rjC;
            long j = this.eoE ? 0 : 500;
            x.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " delay:" + j);
            this.dHa.J(j, j);
            return;
        }
        x.e("MicroMsg.NetSceneVoiceInput", g.Ac() + " onGYNetEnd file:" + this.filename + " errType:" + i2 + " errCode:" + i3);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 349;
    }
}
