package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.c.aex;
import com.tencent.mm.protocal.c.aey;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

public final class b extends l implements k {
    private final com.tencent.mm.ab.b diG;
    private e diJ;
    public e mXj;

    public b(float f, float f2) {
        a aVar = new a();
        aVar.dIG = new aex();
        aVar.dIH = new aey();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/getlbscard";
        aVar.dIF = 1251;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aex aex = (aex) this.diG.dID.dIL;
        aex.bSx = f2;
        aex.bUg = f;
    }

    public final int getType() {
        return 1251;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetLbsCard", "onGYNetEnd, getType = 1251 errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            aey aey = (aey) this.diG.dIE.dIL;
            if (aey != null) {
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (!aey.rIO) {
                    x.e("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is false, no card , don't handle");
                } else if (aey.rIS <= currentTimeMillis) {
                    x.e("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + aey.rIS + " is <= currentTime:" + currentTimeMillis + " , don't handle");
                } else if (TextUtils.isEmpty(aey.huU)) {
                    x.e("MicroMsg.NetSceneGetLbsCard", "getlbscard card_tp_id is empty , don't handle");
                } else {
                    x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is true");
                    if (aey.rIP) {
                        x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is true");
                    } else {
                        x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is false");
                    }
                    this.mXj = new e();
                    this.mXj.hwF = 1;
                    this.mXj.huU = aey.huU;
                    this.mXj.cad = aey.cad;
                    this.mXj.title = aey.title;
                    this.mXj.huX = aey.huX;
                    this.mXj.huY = aey.huY;
                    this.mXj.hwh = aey.hwh;
                    this.mXj.huW = aey.huW;
                    this.mXj.dxh = aey.dxh;
                    this.mXj.mXk = 0;
                    this.mXj.mXn = aey.mXn;
                    this.mXj.mXo = aey.mXo;
                    this.mXj.mXp = aey.mXp;
                    this.mXj.mXq = aey.mXq;
                    this.mXj.mXr = "";
                    this.mXj.end_time = aey.end_time;
                    this.mXj.mXs = aey.mXs;
                    this.mXj.mXt = aey.mXt;
                    m.buI().mXm = this.mXj.mXr;
                    x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + aey.rIS + " is <= currentTime:" + currentTimeMillis);
                    x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard activity_type: " + aey.rIU);
                    au.HU();
                    c.DT().a(aa.a.sOB, Integer.valueOf(currentTimeMillis));
                    au.HU();
                    c.DT().a(aa.a.sOC, Integer.valueOf(aey.rIS));
                    au.HU();
                    c.DT().a(aa.a.sOD, aey.rIV);
                    au.HU();
                    c.DT().a(aa.a.sOG, aey.rIT);
                    au.HU();
                    c.DT().a(aa.a.sOH, Integer.valueOf(aey.rIU));
                    String buZ = com.tencent.mm.plugin.shake.c.c.a.buZ();
                    x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard msg reddotid is " + aey.rIQ);
                    x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre reddotid is " + buZ);
                    if (TextUtils.isEmpty(aey.rIQ)) {
                        x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard resp.red_dot_id is empty");
                    }
                    if (TextUtils.isEmpty(buZ)) {
                        x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre_red_dot_id is empty, resp.red_dot_id is not empty");
                        com.tencent.mm.s.c.Cp().v(262155, true);
                        au.HU();
                        c.DT().a(aa.a.sOL, aey.rIQ);
                        au.HU();
                        c.DT().a(aa.a.sOM, aey.rIR);
                    } else if (!buZ.equals(aey.rIQ)) {
                        x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard redDotId and msg.reddotid is not empty, but no equals");
                        com.tencent.mm.s.c.Cp().v(262155, true);
                        au.HU();
                        c.DT().a(aa.a.sOL, aey.rIQ);
                        au.HU();
                        c.DT().a(aa.a.sOM, aey.rIR);
                    } else if (buZ.equals(aey.rIQ)) {
                        x.i("MicroMsg.NetSceneGetLbsCard", "redDotId equals msg.reddotid");
                    }
                    h.mEJ.k(11721, aey.huU);
                }
            } else {
                x.e("MicroMsg.NetSceneGetLbsCard", "getlbscard resp is null");
            }
        }
        this.diJ.a(i2, i3, str, this);
    }
}
