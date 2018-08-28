package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq;
import com.tencent.mm.protocal.c.bgb;
import com.tencent.mm.protocal.c.bgc;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.byp;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends l implements k {
    private final b diG;
    private e diJ;
    private String filename;
    public boolean oEW = false;
    private boolean oEX = false;
    private Handler oEY = null;
    int oEZ = 0;
    private int oFa = 0;
    int oFb = 0;
    int oFc = 0;
    private int tH = 0;

    public f(String str, int i, int i2, int i3) {
        x.d("MicroMsg.NetSceneRegisterVoicePrint", "step %d resid %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.oFb = i;
        a aVar = new a();
        aVar.dIG = new bgb();
        aVar.dIH = new bgc();
        aVar.uri = "/cgi-bin/micromsg-bin/registervoiceprint";
        aVar.dIF = 612;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bgb bgb = (bgb) this.diG.dID.dIL;
        this.filename = str;
        this.tH = 0;
        bgb.shi = i2;
        bgb.hcC = i;
        this.oEZ = i3;
        bgb.shg = i3;
        x.i("MicroMsg.NetSceneRegisterVoicePrint", "voiceRegist %d %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.oEW = true;
        bIU();
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    protected final int Cc() {
        return aq.CTRL_BYTE;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    private int bIU() {
        bgb bgb = (bgb) this.diG.dID.dIL;
        byp byp = new byp();
        g gVar = new g();
        bgb.shh = byp;
        com.tencent.mm.modelvoice.l lVar = new com.tencent.mm.modelvoice.l(m.aY(this.filename, false));
        int cm = com.tencent.mm.a.e.cm(m.aY(this.filename, false));
        if (cm - this.tH >= 6000) {
            gVar = lVar.br(this.tH, 6000);
        } else {
            gVar = lVar.br(this.tH, cm - this.tH);
        }
        x.d("MicroMsg.NetSceneRegisterVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[]{Integer.valueOf(this.tH), Integer.valueOf(gVar.ret), Integer.valueOf(gVar.bEG), Integer.valueOf(cm), Boolean.valueOf(this.oEW)});
        if (gVar.bEG == 0) {
            return -2;
        }
        if (gVar.ret < 0) {
            x.w("MicroMsg.NetSceneRegisterVoicePrint", "readerror %d", new Object[]{Integer.valueOf(gVar.ret)});
            return -1;
        } else if (this.tH >= 469000) {
            x.i("MicroMsg.NetSceneRegisterVoicePrint", "moffset > maxfile %d", new Object[]{Integer.valueOf(this.tH)});
            return -1;
        } else {
            byp.suA = new bhy().bq(gVar.buf);
            byp.rdW = this.tH;
            byp.suy = gVar.bEG;
            byp.suz = 0;
            bgb.shg = this.oEZ;
            if (this.oEW && gVar.eon >= com.tencent.mm.a.e.cm(m.aY(this.filename, false))) {
                byp.suz = 1;
                this.oEX = true;
                x.i("MicroMsg.NetSceneRegisterVoicePrint", "the last one pack for uploading totallen %d", new Object[]{Integer.valueOf(cm)});
            }
            this.tH = gVar.eon;
            bgb.shh = byp;
            return 0;
        }
    }

    public final int getType() {
        return 612;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneRegisterVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        bgc bgc = (bgc) ((b) qVar).dIE.dIL;
        if (i2 == 0 || i3 == 0) {
            x.i("MicroMsg.NetSceneRegisterVoicePrint", "voice ticket %d ret %d nextstep %d %d ", new Object[]{Integer.valueOf(bgc.shg), Integer.valueOf(bgc.shj), Integer.valueOf(bgc.shk), Integer.valueOf(bgc.shj)});
            this.oEZ = bgc.shg;
            this.oFa = bgc.shk;
            this.oFc = bgc.shj;
            if (this.oEX) {
                this.diJ.a(i2, i3, str, this);
                return;
            }
            x.i("MicroMsg.NetSceneRegisterVoicePrint", "tryDoScene ret %d", new Object[]{Integer.valueOf(bIU())});
            a(this.dIX, this.diJ);
            x.i("MicroMsg.NetSceneRegisterVoicePrint", "loop doscene");
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
