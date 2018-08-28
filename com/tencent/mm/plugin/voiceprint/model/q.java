package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class q implements e {
    private String oET;
    private int oEZ;
    public a oFE;
    public String oFo;
    public int oFp;

    public q() {
        this.oFE = null;
        this.oFp = -1;
        this.oFo = null;
        this.oET = null;
        this.oEZ = 0;
        au.DF().a(611, this);
        au.DF().a(613, this);
    }

    public q(a aVar) {
        this();
        this.oFE = aVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.VoicePrintUnLockService", "onSceneEnd, errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 || i2 == 0) {
            if (lVar.getType() == 611) {
                d dVar = (d) lVar;
                this.oFp = dVar.oES;
                this.oFo = dVar.oER;
                this.oET = dVar.oET;
                x.d("MicroMsg.VoicePrintUnLockService", "onGetVoiceText, resId:%d, verifyKey:%s, voiceText==null:%b", new Object[]{Integer.valueOf(this.oFp), this.oET, Boolean.valueOf(bi.oW(this.oFo))});
                if (this.oFE != null) {
                    this.oFE.OF(this.oFo);
                }
            }
            if (lVar.getType() != 613) {
                return;
            }
            if (((j) lVar).oFc == 0) {
                x.d("MicroMsg.VoicePrintUnLockService", "onVerify, success");
                if (this.oFE != null) {
                    this.oFE.iI(true);
                    return;
                }
                return;
            }
            x.d("MicroMsg.VoicePrintUnLockService", "onVerify, failed");
            if (this.oFE != null) {
                this.oFE.iI(false);
            }
        } else if (this.oFE != null) {
            this.oFE.bIV();
        }
    }
}
