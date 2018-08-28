package com.tencent.mm.r;

import android.os.Looper;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ads;
import com.tencent.mm.protocal.c.adt;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends l implements k {
    private b diG;
    private ads diH;
    adt diI;
    e diJ = null;
    d diK;
    private String diL = null;
    private ag handler = new ag(Looper.getMainLooper());
    private int retryCount = 0;

    public g(d dVar) {
        if (dVar != null) {
            this.diK = dVar;
            x.d("MicroMsg.NetSceneGetFuncMsg", "new NetSceneGetFuncMsg, cgi: %s, cmdId: %s, functionMsgId: %s", new Object[]{dVar.field_cgi, Integer.valueOf(dVar.field_cmdid), dVar.field_functionmsgid});
            a aVar = new a();
            aVar.dIG = new ads();
            aVar.dIH = new adt();
            aVar.dIF = 825;
            aVar.uri = dVar.field_cgi;
            aVar.dII = dVar.field_cmdid;
            aVar.dIJ = 0;
            this.diG = aVar.KT();
            this.diH = (ads) this.diG.dID.dIL;
            this.diH.rIe = dVar.field_functionmsgid;
            if (dVar.field_custombuff != null) {
                this.diH.rIf = dVar.field_custombuff;
            }
        }
    }

    public final int getType() {
        return 825;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (this.diK != null) {
            x.i("MicroMsg.NetSceneGetFuncMsg", "doScene, functionMsgId: %s", new Object[]{this.diK.field_functionmsgid});
            this.diK.field_status = 1;
        }
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    protected final int Cc() {
        return 6;
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.diI = (adt) ((b) qVar).dIE.dIL;
        this.diL = this.diI.rIf;
        x.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s, opCode: %s, responseCustomBuff==null: %s, response.version: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(this.diI.qZc), Boolean.valueOf(bi.oW(this.diL)), Long.valueOf(this.diI.rIg)});
        if (!bi.oW(this.diL)) {
            this.diH = (ads) this.diG.dID.dIL;
            this.diH.rIf = this.diL;
        }
        if (i2 == 0 || i3 == 0) {
            h.mEJ.a((long) this.diK.field_reportid, (long) this.diK.field_successkey, 1, false);
            this.diJ.a(i2, i3, str, this);
        } else if (i2 == 4) {
            x.i("MicroMsg.NetSceneGetFuncMsg", "server error");
            if (this.diI.qZc != 1) {
                Cd();
                return;
            }
            x.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, stop retry, directly return");
            this.diJ.a(i2, i3, str, this);
        } else {
            x.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, local error");
            h.mEJ.a((long) this.diK.field_reportid, (long) this.diK.field_failkey, 1, false);
            if (this.retryCount < 2) {
                x.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, retry, retryCount: %s", new Object[]{Integer.valueOf(this.retryCount)});
                this.retryCount++;
                Cd();
                return;
            }
            x.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, reach retry limit, directly return");
            h.mEJ.a((long) this.diK.field_reportid, (long) this.diK.field_finalfailkey, 1, false);
            this.diJ.a(i2, i3, str, this);
        }
    }

    private void Cd() {
        this.handler.postDelayed(new 1(this), (long) (this.diK.field_retryinterval * 1000));
    }
}
