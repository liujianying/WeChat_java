package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.protocal.c.byh;
import com.tencent.mm.protocal.c.byp;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends l implements k {
    private final b diG;
    private e diJ;
    private String eRp = "";
    private String filename;
    public boolean oEW = false;
    private boolean oEX = false;
    private Handler oEY = null;
    private int oEZ = 0;
    int oFc = 0;
    private int tH = 0;

    public j(String str, int i) {
        x.d("MicroMsg.NetSceneVerifyVoicePrint", "resid %d", new Object[]{Integer.valueOf(i)});
        a aVar = new a();
        aVar.dIG = new byg();
        aVar.dIH = new byh();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyvoiceprint";
        aVar.dIF = 613;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        byg byg = (byg) this.diG.dID.dIL;
        this.filename = str;
        this.tH = 0;
        byg.shi = i;
        this.oEZ = 0;
        byg.shg = 0;
        x.i("MicroMsg.NetSceneVerifyVoicePrint", "voiceRegist %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(0)});
        this.oEW = true;
        bIU();
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    protected final int Cc() {
        return d.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    private int bIU() {
        byg byg = (byg) this.diG.dID.dIL;
        byp byp = new byp();
        g gVar = new g();
        byg.suq = byp;
        com.tencent.mm.modelvoice.l lVar = new com.tencent.mm.modelvoice.l(m.aY(this.filename, false));
        int cm = com.tencent.mm.a.e.cm(m.aY(this.filename, false));
        if (cm - this.tH >= 6000) {
            gVar = lVar.br(this.tH, 6000);
        } else {
            gVar = lVar.br(this.tH, cm - this.tH);
        }
        x.d("MicroMsg.NetSceneVerifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[]{Integer.valueOf(this.tH), Integer.valueOf(gVar.ret), Integer.valueOf(gVar.bEG), Integer.valueOf(cm), Boolean.valueOf(this.oEW)});
        if (gVar.bEG == 0) {
            return -2;
        }
        if (gVar.ret < 0) {
            x.w("MicroMsg.NetSceneVerifyVoicePrint", "readerror %d", new Object[]{Integer.valueOf(gVar.ret)});
            return -1;
        } else if (this.tH >= 469000) {
            x.i("MicroMsg.NetSceneVerifyVoicePrint", "moffset > maxfile %d", new Object[]{Integer.valueOf(this.tH)});
            return -1;
        } else {
            byp.suA = new bhy().bq(gVar.buf);
            byp.rdW = this.tH;
            byp.suy = gVar.bEG;
            byp.suz = 0;
            byg.shg = this.oEZ;
            if (this.oEW && gVar.eon >= com.tencent.mm.a.e.cm(m.aY(this.filename, false))) {
                byp.suz = 1;
                this.oEX = true;
                x.i("MicroMsg.NetSceneVerifyVoicePrint", "the last one pack for uploading totallen %d", new Object[]{Integer.valueOf(cm)});
            }
            this.tH = gVar.eon;
            byg.suq = byp;
            return 0;
        }
    }

    public final int getType() {
        return 613;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneVerifyVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        byh byh = (byh) ((b) qVar).dIE.dIL;
        if (i2 == 0 || i3 == 0) {
            this.oEZ = byh.shg;
            this.oFc = byh.rsj;
            x.i("MicroMsg.NetSceneVerifyVoicePrint", "voice VoiceTicket %d mResult %d", new Object[]{Integer.valueOf(byh.shg), Integer.valueOf(this.oFc)});
            if (this.oEX) {
                this.diJ.a(i2, i3, str, this);
                return;
            }
            x.i("MicroMsg.NetSceneVerifyVoicePrint", "tryDoScene ret %d", new Object[]{Integer.valueOf(bIU())});
            a(this.dIX, this.diJ);
            x.i("MicroMsg.NetSceneVerifyVoicePrint", "loop doscene");
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
