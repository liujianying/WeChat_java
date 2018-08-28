package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.aa.j;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.z;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bmm;
import com.tencent.mm.protocal.c.qt;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ay;
import java.util.LinkedList;
import java.util.List;

public final class a extends l implements k {
    private b diG;
    private e diJ;
    private String hyz;
    List<d> mWA;
    private int mWB;
    int ret;

    public a(byte[] bArr) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new bml();
        aVar.dIH = new bmm();
        aVar.uri = "/cgi-bin/micromsg-bin/shakeget";
        this.diG = aVar.KT();
        bml bml = (bml) this.diG.dID.dIL;
        bml.rfy = new bhy().bq(bArr);
        bml.skF = 1;
        bml.rTr = new bhy().bq(com.tencent.mm.plugin.normsg.a.b.lFJ.bjE());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneShakeGet", "doScene");
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 162;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneShakeGet", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        bmm bmm = (bmm) this.diG.dIE.dIL;
        this.mWA = new LinkedList();
        this.mWB = bmm.skH;
        this.ret = bmm.rfn;
        this.hyz = bmm.lRx;
        int i4 = bmm.hbF;
        x.d("MicroMsg.NetSceneShakeGet", "size:" + i4);
        au.HU();
        ay FR = c.FR();
        if (i4 > 0) {
            e buC = m.buC();
            buC.buu();
            x.i("MicroMsg.NewShakeItemStorage", "delOldRecord count:" + i4);
            if (buC.diF.fV("shakeitem1", "DELETE FROM shakeitem1 WHERE shakeItemID NOT IN ( SELECT shakeItemID FROM shakeitem1 ORDER BY shakeItemID DESC LIMIT " + (100 > i4 ? 100 - i4 : 0) + " )")) {
                x.i("MicroMsg.NewShakeItemStorage", "delOldRecord success count:" + i4);
                buC.doNotify();
            }
            for (i4--; i4 >= 0; i4--) {
                if (!com.tencent.mm.model.q.GF().equals(((bmk) bmm.skG.get(i4)).hbL)) {
                    d kA = z.MY().kA(((bmk) bmm.skG.get(i4)).hbL);
                    kA.field_username = ((bmk) bmm.skG.get(i4)).hbL;
                    kA.field_brandList = ((bmk) bmm.skG.get(i4)).eJR;
                    qt qtVar = ((bmk) bmm.skG.get(i4)).rTl;
                    if (qtVar != null) {
                        kA.field_brandFlag = qtVar.eJV;
                        kA.field_brandInfo = qtVar.eJX;
                        kA.field_brandIconURL = qtVar.eJY;
                        kA.field_extInfo = qtVar.eJW;
                    }
                    if (!z.MY().e(kA)) {
                        z.MY().d(kA);
                    }
                }
                d dVar = new d((bmk) bmm.skG.get(i4));
                j jVar = new j();
                jVar.username = dVar.field_username;
                jVar.by(dVar.field_hasHDImg > 0);
                jVar.csA = dVar.field_imgstatus;
                jVar.dHR = ((bmk) bmm.skG.get(i4)).rqZ;
                jVar.dHQ = ((bmk) bmm.skG.get(i4)).rra;
                com.tencent.mm.aa.q.KH().a(jVar);
                jVar.bWA = -1;
                x.d("MicroMsg.NetSceneShakeGet", "dkhurl search %s b[%s] s[%s]", jVar.getUsername(), jVar.Kx(), jVar.Ky());
                dVar.field_reserved2 = FR.Yc(dVar.field_username) ? 1 : 0;
                ai Yg = FR.Yg(dVar.field_username);
                if (Yg != null && ((int) Yg.dhP) > 0) {
                    buC.Lb(Yg.field_username);
                    buC.Lb(Yg.field_encryptUsername);
                }
                buC.a(dVar, false);
                au.HU();
                c.Gw().x(dVar.field_username, this.mWB, ((bmk) bmm.skG.get(i4)).rEJ);
                dVar.scene = this.mWB;
                this.mWA.add(dVar);
                x.v("MicroMsg.NetSceneShakeGet", "item info: " + dVar.field_username + " " + dVar.field_nickname);
            }
        }
        this.diJ.a(i2, i3, str, this);
    }
}
