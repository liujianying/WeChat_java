package com.tencent.mm.plugin.ipcall.a.c;

import android.os.Looper;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.byy;
import com.tencent.mm.protocal.c.cah;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public boolean kqA = false;
    public boolean kqB = false;
    public a kqC = null;
    public v2protocal kqx = new v2protocal(this.kqy);
    private ag kqy = new 1(this, Looper.getMainLooper());
    private boolean kqz = false;

    static /* synthetic */ void a(a aVar, int i) {
        x.d("MicroMsg.IPCallEngineManager", "channel connect failed!");
        if (aVar.kqC != null) {
            aVar.kqC.rt(i);
        }
    }

    public final void aXJ() {
        x.d("MicroMsg.IPCallEngineManager", "setChannelActiveAfterAccept");
        if (!this.kqA) {
            x.d("MicroMsg.IPCallEngineManager", "channel not connect now");
        }
        this.kqx.setActive();
    }

    public final void aXK() {
        if (this.kqz) {
            x.d("MicroMsg.IPCallEngineManager", "requestChannelConnect, already request channel connect");
            return;
        }
        x.i("MicroMsg.IPCallEngineManager", "requestChannelConnect");
        c cVar = i.aXp().koG;
        if (cVar != null) {
            if (cVar.gUH != null) {
                byy V = com.tencent.mm.plugin.ipcall.b.c.V(cVar.gUH);
                byy V2 = com.tencent.mm.plugin.ipcall.b.c.V(cVar.kpM);
                cah cah = new cah();
                cah.swD = 0;
                cah.swE = 0;
                cah.swF = 0;
                cah.userName = "";
                cah.eSH = "";
                this.kqx.a(V, V, V2, cah);
            }
            x.d("MicroMsg.IPCallEngineManager", "finish set svr addr");
            this.kqx.oOp = cVar.kpH;
            this.kqx.oPj = cVar.kpK;
            if (cVar.kpL != null) {
                this.kqx.oPk = cVar.kpL.toByteArray();
            }
            if (cVar.kpI != null) {
                this.kqx.oOq = cVar.kpI.toByteArray();
            }
            this.kqx.kpo = cVar.kpo;
            this.kqx.kpp = cVar.kpp;
            this.kqx.kpw = cVar.kpw;
            this.kqx.oOs = cVar.kpF;
            this.kqx.oOr = cVar.kpG;
            this.kqx.oOt = cVar.kpN;
            int configInfo = this.kqx.setConfigInfo(this.kqx.oOk, (long) this.kqx.kpo, this.kqx.kpw, this.kqx.kpp, this.kqx.field_peerId, 1, this.kqx.oOr, this.kqx.oOs, this.kqx.oOp, this.kqx.oOq == null ? 0 : this.kqx.oOq.length, this.kqx.oOq, this.kqx.oOt, 0, 0, this.kqx.oPj, this.kqx.oPk, 255, 0);
            x.d("MicroMsg.IPCallEngineManager", "setConfigInfo, ret: %d", Integer.valueOf(configInfo));
            if (configInfo == 0) {
                configInfo = this.kqx.connectToPeer();
            }
            if (configInfo < 0) {
                x.e("MicroMsg.IPCallEngineManager", "setConfigInfo failed, ret: %d", Integer.valueOf(configInfo));
                if (this.kqC != null) {
                    this.kqC.rt(21);
                }
            }
            this.kqz = true;
        }
    }

    public final void ry(int i) {
        if (this.kqA) {
            x.d("MicroMsg.IPCallEngineManager", "setDtmfPayloadType: %d", Integer.valueOf(i));
            if (this.kqx.SetDTMFPayload(i) < 0) {
                x.i("MicroMsg.IPCallEngineManager", "setDtmfPayloadType failed, ret: %d", Integer.valueOf(this.kqx.SetDTMFPayload(i)));
            }
        }
    }

    public final void aXL() {
        this.kqA = false;
        this.kqz = false;
        this.kqB = false;
    }
}
