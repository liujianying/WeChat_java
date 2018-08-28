package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.a.a.i;
import com.tencent.mm.protocal.c.ami;
import com.tencent.mm.protocal.c.pb;
import com.tencent.mm.protocal.c.pc;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends l implements k {
    int bVU = 0;
    private b diG;
    private com.tencent.mm.ab.e diJ;
    private boolean iLZ = false;
    private pb mDP = null;
    private a mDQ = new a();

    public e(byte[] bArr, int i) {
        if (bArr == null) {
            throw new NullPointerException("data must not be null");
        }
        this.bVU = i;
        g.Eg();
        this.iLZ = a.Dw();
        if (i == 1) {
            try {
                i iVar = new i();
                iVar.aG(bArr);
                this.mDP = SmcProtoBufUtil.toMMReportKvReq(iVar);
            } catch (Exception e) {
                x.e("MicroMsg.NetSceneCliReportKV", "parse data error");
                g.Ek();
                g.Em().H(new Runnable() {
                    public final void run() {
                        SmcLogic.OnReportResp(3, -1, null, e.this.bVU);
                    }
                });
            }
        } else if (i == 2) {
            try {
                com.tencent.mm.protocal.a.a.g gVar = new com.tencent.mm.protocal.a.a.g();
                gVar.aG(bArr);
                this.mDP = SmcProtoBufUtil.toMMReportIdkeyReq(gVar);
            } catch (Exception e2) {
                x.e("MicroMsg.NetSceneCliReportKV", "parse data error");
                g.Ek();
                g.Em().H(new Runnable() {
                    public final void run() {
                        SmcLogic.OnReportResp(3, -1, null, e.this.bVU);
                    }
                });
            }
        }
        if (this.mDP != null) {
            this.mDP.rtn = new ami();
            this.mDP.rtn.rOY = a.vs(this.bVU);
            return;
        }
        x.i("MicroMsg.NetSceneCliReportKV", "NetSceneCliReportKV parse req is null, stack[%s]", new Object[]{bi.cjd()});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (g.Eh().dpP == null || g.Eh().dpP.dJs == null) {
            x.f("MicroMsg.NetSceneCliReportKV", "null == MMCore.getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
            this.diJ.a(i2, i3, str, this);
        } else if (i2 != 0) {
            x.e("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy err, errType:" + i2 + ", errCode:" + i3);
            SmcLogic.OnReportResp(i2, i3, null, this.bVU);
            this.diJ.a(i2, i3, str, this);
        } else {
            x.d("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy ok, channel:" + this.bVU);
            pc pcVar = (pc) this.diG.dIE.dIL;
            this.mDQ.a(pcVar.rtx, this.bVU);
            try {
                if (this.bVU == 1) {
                    SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportKvResp(pcVar).toByteArray(), this.bVU);
                } else if (this.bVU == 2) {
                    SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportIdkeyResp(pcVar).toByteArray(), this.bVU);
                }
            } catch (Throwable e) {
                x.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", new Object[]{Integer.valueOf(hashCode()), bi.i(e)});
            }
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return !this.iLZ ? 1 == this.bVU ? 997 : 987 : 1 == this.bVU ? 996 : 986;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        if (this.mDP == null) {
            x.e("MicroMsg.NetSceneCliReportKV", "do scene but req is null!");
            return -2;
        }
        if (!this.iLZ) {
            this.mDP.rtm = com.tencent.mm.bk.b.bi(bi.ciV());
        }
        b.a aVar = new b.a();
        aVar.dIK = false;
        aVar.dIG = this.mDP;
        aVar.dIH = new pc();
        String str = 1 == this.bVU ? "/cgi-bin/micromsg-bin/newreportkvcomm" : "/cgi-bin/micromsg-bin/newreportidkey";
        String str2 = 1 == this.bVU ? "/cgi-bin/micromsg-bin/newreportkvcommrsa" : "/cgi-bin/micromsg-bin/newreportidkeyrsa";
        if (!this.iLZ) {
            str = str2;
        }
        aVar.uri = str;
        aVar.dIF = getType();
        this.diG = aVar.KT();
        if (!this.iLZ) {
            this.diG.a(y.cgs());
            this.diG.cdn = 1;
        }
        int a = a(eVar, this.diG, this);
        if (a >= 0) {
            return a;
        }
        x.i("MicroMsg.NetSceneCliReportKV", "mark all failed. do scene %d", new Object[]{Integer.valueOf(a)});
        try {
            SmcLogic.OnReportResp(3, -1, null, this.bVU);
            return a;
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", new Object[]{Integer.valueOf(hashCode()), bi.i(e)});
            return a;
        }
    }
}
