package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.l.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.ba.a;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.byp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends l implements k {
    private final q dJM;
    e diJ;
    String eRp = "";
    private String filename;
    public boolean oEW = false;
    private boolean oEX = false;
    private Handler oEY = null;
    private int oEZ = 0;
    int oFc = 0;
    private int tH = 0;

    public h(String str, int i, String str2) {
        x.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "resid %d vertifyTicket %s", new Object[]{Integer.valueOf(i), bi.aG(str2, "")});
        this.dJM = new c();
        a aVar = (a) this.dJM.KV();
        this.filename = str;
        this.tH = 0;
        aVar.dBW.shi = i;
        aVar.dBW.rMq = str2;
        this.oEZ = 0;
        aVar.dBW.shg = 0;
        x.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voiceRegist %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(0)});
        this.oEW = true;
        bIU();
    }

    protected final int a(q qVar) {
        return b.dJm;
    }

    protected final int Cc() {
        return d.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dJM, this);
    }

    private int bIU() {
        a aVar = (a) this.dJM.KV();
        byp byp = new byp();
        g gVar = new g();
        aVar.dBW.suq = byp;
        com.tencent.mm.modelvoice.l lVar = new com.tencent.mm.modelvoice.l(m.aY(this.filename, false));
        int cm = com.tencent.mm.a.e.cm(m.aY(this.filename, false));
        if (cm - this.tH >= 6000) {
            gVar = lVar.br(this.tH, 6000);
        } else {
            gVar = lVar.br(this.tH, cm - this.tH);
        }
        x.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[]{Integer.valueOf(this.tH), Integer.valueOf(gVar.ret), Integer.valueOf(gVar.bEG), Integer.valueOf(cm), Boolean.valueOf(this.oEW)});
        if (gVar.bEG == 0) {
            return -2;
        }
        if (gVar.ret < 0) {
            x.w("MicroMsg.NetSceneRsaVertifyVoicePrint", "readerror %d", new Object[]{Integer.valueOf(gVar.ret)});
            return -1;
        } else if (this.tH >= 469000) {
            x.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "moffset > maxfile %d", new Object[]{Integer.valueOf(this.tH)});
            return -1;
        } else {
            byp.suA = new bhy().bq(gVar.buf);
            byp.rdW = this.tH;
            byp.suy = gVar.bEG;
            byp.suz = 0;
            aVar.dBW.shg = this.oEZ;
            if (this.oEW && gVar.eon >= com.tencent.mm.a.e.cm(m.aY(this.filename, false))) {
                byp.suz = 1;
                this.oEX = true;
                x.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "the last one pack for uploading totallen %d", new Object[]{Integer.valueOf(cm)});
            }
            this.tH = gVar.eon;
            aVar.dBW.suq = byp;
            return 0;
        }
    }

    public final int getType() {
        return 617;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        ba.b bVar = (ba.b) qVar.Id();
        if (i2 == 4 && i3 == -102) {
            x.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[]{Integer.valueOf(qVar.KV().qWA.ver)});
            au.Em().H(new 1(this, r0));
        } else if (i2 == 0 || i3 == 0) {
            this.oEZ = bVar.dBX.shg;
            this.oFc = bVar.dBX.rsj;
            this.eRp = bVar.dBX.sur;
            String str2 = "MicroMsg.NetSceneRsaVertifyVoicePrint";
            String str3 = "voice VoiceTicket %d mResult %d mAuthPwd is null: %b, mAuthPwd.len: %d";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(bVar.dBX.shg);
            objArr[1] = Integer.valueOf(this.oFc);
            objArr[2] = Boolean.valueOf(bi.oW(this.eRp));
            objArr[3] = Integer.valueOf(bi.oW(this.eRp) ? 0 : this.eRp.length());
            x.i(str2, str3, objArr);
            if (this.oEX) {
                this.diJ.a(i2, i3, str, this);
                return;
            }
            x.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "tryDoScene ret %d", new Object[]{Integer.valueOf(bIU())});
            a(this.dIX, this.diJ);
            x.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "loop doscene");
        } else {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
