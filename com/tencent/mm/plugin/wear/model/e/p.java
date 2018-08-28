package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.e.b.g;
import com.tencent.mm.e.c.d;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.d.c;
import com.tencent.mm.protocal.c.cfe;
import com.tencent.mm.protocal.c.cff;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.qqpinyin.voicerecoapi.c$a;
import java.util.LinkedList;

public final class p implements e {
    public static final String pJW = (aa.duN + "tmp_wearvoicetotext.spx");
    public boolean ceW = false;
    public LinkedList<Integer> ftL = new LinkedList();
    public c pJX;
    public com.tencent.qqpinyin.voicerecoapi.c pJY;
    public d pJZ;
    private int pKa = 0;
    public int pKb;
    public int pKc;

    public final void reset() {
        x.i("MicroMsg.Wear.VoiceToTextServer", "reset: sessionId=%s", new Object[]{Integer.valueOf(this.pKb)});
        if (this.pJZ != null) {
            this.pJZ.wA();
            this.pJZ = null;
            x.i("MicroMsg.Wear.VoiceToTextServer", "reset speexWriter");
        }
        if (this.pJY != null) {
            this.pJY.stop();
            this.pJY = null;
            x.i("MicroMsg.Wear.VoiceToTextServer", "reset voiceDetectAPI");
        }
        if (this.pJX != null) {
            this.pJX.eoE = true;
            au.DF().b(349, this);
            au.DF().c(this.pJX);
            this.pJX = null;
        }
        this.pKc = 0;
        this.ceW = false;
        this.pKa = 0;
        this.pKb = -1;
        this.ftL.clear();
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar instanceof c) {
            c cVar = (c) lVar;
            cff cff;
            if (i != 0 || i2 != 0) {
                au.DF().b(349, this);
                cff = new cff();
                cff.szk = cVar.talker;
                cff.rBM = "";
                cff.qZk = -1;
                cff.szO = false;
                a.bSl().pIS.a(new a(this, cVar.mFO, cff));
            } else if (cVar.pJN) {
                au.DF().b(349, this);
                cff = new cff();
                cff.szk = cVar.talker;
                if (bi.oW(cVar.pJM)) {
                    cff.rBM = "";
                    cff.qZk = -1;
                    cff.szO = false;
                } else {
                    x.i("MicroMsg.Wear.VoiceToTextServer", "receive text: %s", new Object[]{cVar.pJM});
                    cff.rBM = cVar.pJM;
                    cff.qZk = 0;
                    cff.szO = true;
                }
                a.bSl().pIS.a(new a(this, cVar.mFO, cff));
            }
        }
    }

    public final void a(int i, cfe cfe) {
        if (cfe.rdU == null) {
            x.i("MicroMsg.Wear.VoiceToTextServer", "voice data is null");
            return;
        }
        byte[] toByteArray = cfe.rdU.toByteArray();
        this.pKa += this.pJZ.a(new g.a(toByteArray, cfe.rvV), 0, false);
        x.i("MicroMsg.Wear.VoiceToTextServer", "write bytes: %d", new Object[]{Integer.valueOf(this.pKa)});
        short[] sArr = new short[(cfe.rvV / 2)];
        for (int i2 = 0; i2 < cfe.rvV / 2; i2++) {
            sArr[i2] = (short) ((toByteArray[i2 * 2] & 255) | (toByteArray[(i2 * 2) + 1] << 8));
        }
        c$a c_a = new c$a();
        this.pJY.a(sArr, cfe.rvV / 2, c_a);
        x.i("MicroMsg.Wear.VoiceToTextServer", "state.vad_flag: " + c_a.vgN);
        if (c_a.vgN == 2) {
            this.pKc = 1;
        } else if (c_a.vgN == 3) {
            this.pKc = 2;
        }
        if (this.pKc != 0) {
            if (this.pKc < 0) {
                if (this.ftL.size() > 10) {
                    this.ftL.removeLast();
                }
                this.ftL.addFirst(Integer.valueOf(i));
            }
            if (this.pKc == 1) {
                cff cff = new cff();
                cff.szk = this.pJX.talker;
                cff.rBM = "";
                cff.qZk = this.pKc;
                cff.szO = true;
                a.bSl().pIS.a(new a(this, this.pJX.mFO, cff));
                this.pKc = 0;
            }
        }
        if (!this.ceW && this.pKa > 3300) {
            this.ceW = true;
            au.DF().a(this.pJX, 0);
        }
    }
}
