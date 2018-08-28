package com.tencent.mm.network;

import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.network.j.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class t$a extends a implements l {
    private t cWB;
    private WakerLock esP;
    private int esQ = 0;

    public t$a(t tVar, WakerLock wakerLock) {
        this.cWB = tVar;
        this.esP = wakerLock;
    }

    public final void a(r rVar, int i, int i2, String str) {
        this.esP.lock(1000, "MMAutoAuth.IOnAutoAuth.onAutoAuth");
        new 1(this, rVar, i, i2, str).a(this.cWB.handler);
    }

    public final void a(int i, int i2, int i3, String str, r rVar, byte[] bArr) {
        if (rVar.getType() == 701) {
            x.d("MicroMsg.AutoAuth", "summerauth IOnAutoAuth onGYNetEnd manual auth");
            if (rVar.LD().LH() != 0 || i2 != 0) {
                f.mDy.a(148, -102 == i3 ? 30 : 29, 1, false);
            } else if (rVar.LE() == 2) {
                f.mDy.a(148, 28, 1, false);
                this.esQ++;
                if (this.esQ > 1) {
                    x.w("MicroMsg.AutoAuth", "summerauth manualLoginDecodeFailedTry beyond 1 no more try!");
                    this.cWB.c(i2, i3, "auth_decode_failed_" + bi.aG(str, ""));
                } else {
                    rVar.a(this, 0, 0);
                }
            } else {
                this.esQ = 0;
                rVar.a(this, i2, i3, str);
            }
        }
        if (rVar.LD().LH() == 0 && i2 == 0) {
            rVar.a(this, i2, i3, str);
        } else if (-102 == i3) {
            this.cWB.esp = i;
            rVar.a(this.cWB.esl, this.cWB.esn, 0, 0);
        } else {
            if (-301 == i3) {
                rVar.a(this, i2, i3, str);
            } else if (-105 == i3) {
                rVar.a(this, i2, i3, str);
            } else if (-17 == i3) {
                rVar.a(this, i2, i3, str);
            }
            this.cWB.c(i2, i3, "autoauth_errmsg_" + bi.aG(str, ""));
        }
    }
}
