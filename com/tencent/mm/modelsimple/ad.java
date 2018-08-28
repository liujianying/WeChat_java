package com.tencent.mm.modelsimple;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.cic;
import com.tencent.mm.protocal.c.cid;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class ad extends l implements k {
    private e diJ;
    private final b efk;
    private int retryCount = 3;

    public ad(String str, int i) {
        a aVar = new a();
        aVar.dIG = new cic();
        aVar.dIH = new cid();
        aVar.uri = "/cgi-bin/micromsg-bin/yybgetpkgsig";
        aVar.dIF = 729;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.efk = aVar.KT();
        cic cic = (cic) this.efk.dID.dIL;
        cic.iwP = w.chP();
        cic.reQ = com.tencent.mm.plugin.normsg.a.b.lFJ.ub(0);
        cic.sCa = str;
        cic.jPh = i;
        x.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig Language[%s], PkgName[%s], versionCode[%d], stack[%s]", new Object[]{cic.iwP, str, Integer.valueOf(i), bi.cjd()});
    }

    public final int getType() {
        return 729;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.efk, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        cic cic = (cic) this.efk.dID.dIL;
        cid cid = (cid) this.efk.dIE.dIL;
        x.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s], ret[%d], sig[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(cid.sCb), cid.sCc});
        h hVar;
        Object[] objArr;
        if (i2 == 0 && i3 == 0) {
            if (cid.sCb == 2 || cid.sCb == 3) {
                this.retryCount--;
                if (this.retryCount <= 0) {
                    x.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken err and return with no try!");
                    h.mEJ.a(322, 2, 1, false);
                    hVar = h.mEJ;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(4002);
                    objArr[1] = String.format("%s,%d", new Object[]{cic.sCa, Integer.valueOf(cic.jPh)});
                    hVar.h(11098, objArr);
                    this.diJ.a(3, -1, "", this);
                    return;
                }
                x.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken do scene again retryCount:%d", new Object[]{Integer.valueOf(this.retryCount)});
                a(this.dIX, this.diJ);
            } else if (cid.sCb == 1) {
                MultiProcessSharedPreferences.getSharedPreferences(com.tencent.mm.sdk.platformtools.ad.getContext(), "yyb_pkg_sig_prefs", 4).edit().remove(cic.sCa).commit();
                h.mEJ.a(322, 5, 1, false);
                hVar = h.mEJ;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4005);
                objArr[1] = String.format("%s,%d", new Object[]{cic.sCa, Integer.valueOf(cic.jPh)});
                hVar.h(11098, objArr);
                x.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no sig[%s] and remove", new Object[]{cid.sCc});
            } else if (cid.sCb == 4) {
                x.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no need try and revise");
                h.mEJ.a(322, 4, 1, false);
                hVar = h.mEJ;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4004);
                objArr[1] = String.format("%s,%d", new Object[]{cic.sCa, Integer.valueOf(cic.jPh)});
                hVar.h(11098, objArr);
            } else {
                x.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret sig[%s]", new Object[]{cid.sCc});
                MultiProcessSharedPreferences.getSharedPreferences(com.tencent.mm.sdk.platformtools.ad.getContext(), "yyb_pkg_sig_prefs", 4).edit().putString(cic.sCa, cid.sCc).commit();
                h.mEJ.a(322, 3, 1, false);
                hVar = h.mEJ;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4003);
                objArr[1] = String.format("%s,%d,%s", new Object[]{cic.sCa, Integer.valueOf(cic.jPh), cid.sCc});
                hVar.h(11098, objArr);
            }
            this.diJ.a(i2, i3, str, this);
            return;
        }
        x.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig err and return!");
        h.mEJ.a(322, 1, 1, false);
        hVar = h.mEJ;
        objArr = new Object[2];
        objArr[0] = Integer.valueOf(4001);
        objArr[1] = String.format("%s,%d,%d,%d", new Object[]{cic.sCa, Integer.valueOf(cic.jPh), Integer.valueOf(i2), Integer.valueOf(i3)});
        hVar.h(11098, objArr);
        this.diJ.a(i2, i3, str, this);
    }
}
