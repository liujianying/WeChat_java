package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class l implements e {
    public int oEZ;
    public int oFn;
    private String oFo;
    public int oFp;
    public a oFq;

    public interface a {
        void OD(String str);

        void OE(String str);

        void bIV();

        void u(boolean z, int i);
    }

    public l() {
        this.oFn = 71;
        this.oFo = null;
        this.oFp = 0;
        this.oEZ = 0;
        this.oFq = null;
        au.DF().a(611, this);
        au.DF().a(612, this);
    }

    public l(a aVar) {
        this();
        this.oFq = aVar;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.d("MicroMsg.VoicePrintCreateService", "onSceneEnd, errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 || i2 == 0) {
            if (lVar.getType() == 611) {
                d dVar = (d) lVar;
                this.oFp = dVar.oES;
                this.oFo = dVar.oER;
                x.d("MicroMsg.VoicePrintCreateService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[]{Integer.valueOf(this.oFp), Boolean.valueOf(bi.oW(this.oFo))});
                if (this.oFq != null) {
                    if (this.oFn == 71) {
                        this.oFq.OD(this.oFo);
                    } else if (this.oFn == 72) {
                        this.oFq.OE(this.oFo);
                    }
                }
            }
            if (lVar.getType() == 612) {
                boolean z;
                f fVar = (f) lVar;
                if ((fVar.oFb == 72 && fVar.oFc == 0) || fVar.oFb == 71) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    x.d("MicroMsg.VoicePrintCreateService", "onRegister, ok, step:%d", new Object[]{Integer.valueOf(fVar.oFb)});
                    this.oEZ = fVar.oEZ;
                    if (this.oFq != null) {
                        this.oFq.u(true, fVar.oFb);
                    }
                } else {
                    x.d("MicroMsg.VoicePrintCreateService", "onRegister, not ok, step:%d", new Object[]{Integer.valueOf(fVar.oFb)});
                    if (this.oFq != null) {
                        this.oFq.u(false, fVar.oFb);
                    }
                }
                if (z && fVar.oFb == 71 && this.oFq != null) {
                    this.oFq.OE(this.oFo);
                }
            }
        } else if (this.oFq != null) {
            this.oFq.bIV();
        }
    }
}
