package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class n implements e {
    public String eRp = null;
    public String fsy = null;
    public String gtX = null;
    private String oFo = null;
    public int oFp = -1;
    public a oFr = null;

    public n() {
        au.DF().a(618, this);
        au.DF().a(616, this);
        au.DF().a(617, this);
    }

    public final void bIW() {
        au.DF().a(new g(this.fsy), 0);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.VoicePrintLoginService", "onSceneEnd, errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 || i2 == 0) {
            if (lVar.getType() == 618) {
                this.fsy = ((e) lVar).eHp;
                x.d("MicroMsg.VoicePrintLoginService", "onGetTicket, loginTicket==null:%b", new Object[]{Boolean.valueOf(bi.oW(this.fsy))});
                if (!bi.oW(this.fsy)) {
                    bIW();
                }
            }
            if (lVar.getType() == 616) {
                g gVar = (g) lVar;
                this.oFp = gVar.oES;
                this.oFo = gVar.oER;
                x.d("MicroMsg.VoicePrintLoginService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[]{Integer.valueOf(this.oFp), Boolean.valueOf(bi.oW(this.oFo))});
                if (this.oFr != null) {
                    this.oFr.OF(this.oFo);
                }
            }
            if (lVar.getType() == 617) {
                h hVar = (h) lVar;
                if (hVar.oFc == 0) {
                    x.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, success");
                    this.eRp = hVar.eRp;
                    if (this.oFr != null) {
                        this.oFr.iH(true);
                        return;
                    }
                    return;
                }
                x.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, failed");
                if (this.oFr != null) {
                    this.oFr.iH(false);
                }
            }
        } else if (i2 == -34 && lVar.getType() == 617) {
            x.d("MicroMsg.VoicePrintLoginService", "blocked by limit");
            if (this.oFr != null) {
                this.oFr.bIX();
            }
        } else if (this.oFr != null) {
            this.oFr.bIV();
        }
    }
}
