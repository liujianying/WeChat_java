package com.tencent.mm.plugin.wear.model.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bwa;
import com.tencent.mm.protocal.c.bwb;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import java.util.UUID;

public final class c extends l implements k {
    private String clientId;
    al dHa = new al(new 1(this), true);
    private b diG;
    e diJ;
    public boolean eoE = false;
    private boolean eql = false;
    private int eqp = 0;
    String filename = null;
    public int mFO;
    int pJL = 0;
    public String pJM;
    public boolean pJN;
    public String talker;

    public c(String str, String str2, int i) {
        this.mFO = i;
        this.talker = str2;
        this.filename = str;
        this.eqp = 0;
        this.clientId = UUID.randomUUID().toString();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        int cm = com.tencent.mm.a.e.cm(this.filename);
        if (cm <= 0) {
            x.e("MicroMsg.Wear.NetSceneVoiceToText", "doScene file length is zero: %s", this.filename);
            return -1;
        }
        int i = cm - this.pJL;
        if (i > 3960) {
            i = 3960;
        } else if (i < 3300 && !this.eoE) {
            x.e("MicroMsg.Wear.NetSceneVoiceToText", "try to send a buf less than MIN_SEND_BYTE_PER_PACK: canReadLen=%d | isRecordFinished=%b", Integer.valueOf(i), Boolean.valueOf(this.eoE));
            return -1;
        } else if (this.eoE) {
            this.eql = true;
        }
        x.i("MicroMsg.Wear.NetSceneVoiceToText", "fileLength: %d | readOffset: %d | isRecordFinish=%b | endFlag=%b | filename=%s", Integer.valueOf(cm), Integer.valueOf(this.pJL), Boolean.valueOf(this.eoE), Boolean.valueOf(this.eql), this.filename);
        byte[] e = com.tencent.mm.a.e.e(this.filename, this.pJL, i);
        if (e != null) {
            a aVar = new a();
            aVar.dIG = new bwa();
            aVar.dIH = new bwb();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
            aVar.dIF = 349;
            aVar.dII = 158;
            aVar.dIJ = 1000000158;
            this.diG = aVar.KT();
            bwa bwa = (bwa) this.diG.dID.dIL;
            au.HU();
            bwa.hbL = (String) com.tencent.mm.model.c.DT().get(2, (Object) "");
            bwa.rtW = new bhy().bq(e);
            bwa.rjC = this.pJL;
            bwa.sso = this.clientId;
            bwa.rgC = this.eql ? 1 : 0;
            bwa.ssp = 0;
            bwa.reb = 0;
            bwa.ssq = this.eqp;
            bwa.rdY = 0;
            cm = a(eVar, this.diG, this);
            this.pJL = bwa.rtW.siI + bwa.rjC;
            long j = this.eoE ? 0 : 500;
            x.i("MicroMsg.Wear.NetSceneVoiceToText", "doScene filename=%s | delay=%d | ret=%d", this.filename, Long.valueOf(j), Integer.valueOf(cm));
            this.dHa.J(j, j);
            return cm;
        } else if (this.eql) {
            return 0;
        } else {
            x.e("MicroMsg.Wear.NetSceneVoiceToText", "Can not read file: canReadLen=%d | isRecordFinish=%b | endFlag=%b", Integer.valueOf(i), Boolean.valueOf(this.eoE), Boolean.valueOf(this.eql));
            return -1;
        }
    }

    protected final int a(q qVar) {
        return b.dJm;
    }

    protected final int Cc() {
        return 20;
    }

    protected final void a(a aVar) {
        this.diJ.a(3, 0, "securityCheckError", this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Wear.NetSceneVoiceToText", "onGYNetEnd errorType=%d | errorCode=%d |filename=%s", Integer.valueOf(i2), Integer.valueOf(i3), this.filename);
        bwb bwb = (bwb) ((b) qVar).dIE.dIL;
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.Wear.NetSceneVoiceToText", "resp EndFlag=%d | Text=%s", Integer.valueOf(bwb.rgC), d(bwb.ssr));
            if (bwb.rgC == 1) {
                this.pJN = true;
                String d = d(bwb.ssr);
                if (d != null) {
                    this.pJM = d;
                }
                this.diJ.a(i2, i3, str, this);
                return;
            }
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }

    private static String d(bhy bhy) {
        if (bhy == null || bhy.siK == null) {
            return null;
        }
        return bhy.siK.cfV();
    }

    public final int getType() {
        return 349;
    }
}
