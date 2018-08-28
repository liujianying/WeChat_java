package com.tencent.mm.modelappbrand;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.g.a.hx;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.protocal.c.cdc;
import com.tencent.mm.protocal.c.cdd;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends a implements k {
    private final b dFA;
    private cdd dFB;
    private j dFC;
    private e doG;

    public o(j jVar) {
        this.dFC = jVar;
        this.pKL = jVar.bWo;
        this.pKM = jVar.bHt;
        this.tH = jVar.offset;
        this.fdx = jVar.scene;
        this.pKN = jVar.pLg;
        b.a aVar = new b.a();
        aVar.dIG = new cdc();
        aVar.dIH = new cdd();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearch";
        this.dFA = aVar.KT();
        cdc cdc = (cdc) this.dFA.dID.dIL;
        aqs JU = JU();
        cdc.hcE = jVar.iPZ;
        cdc.rHk = jVar.bHt;
        cdc.rjC = jVar.offset;
        cdc.rlo = jVar.iow;
        cdc.syI = jVar.pKV;
        com.tencent.mm.sdk.b.b hxVar = new hx();
        com.tencent.mm.sdk.b.a.sFg.m(hxVar);
        cdc.syH = hxVar.bRs.bRt;
        if (JU != null) {
            cdc.syJ = (double) JU.rmr;
            cdc.syK = (double) JU.rms;
        }
        cdc.syL = b.dFw;
        cdc.syO = jVar.pKR;
        cdc.syP = jVar.pKW;
        cdc.syQ = jVar.pKX;
        cdc.syM = b.dFx;
        cdc.sdX = jVar.jru;
        x.i("MicroMsg.NetSceneWeAppSearch", "NetSceneWeAppSearch oreh SessionID : %s, KeywordID : %s, LocationX : %s, LocationY : %s", cdc.syL, cdc.syM, Double.valueOf(cdc.syJ), Double.valueOf(cdc.syK));
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneWeAppSearch", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.dFB = (cdd) this.dFA.dIE.dIL;
        if (this.dFB != null) {
            x.v("MicroMsg.NetSceneWeAppSearch", "return data\n%s", this.dFB.rjK);
        }
        if (this.doG != null) {
            this.doG.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1162;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneWeAppSearch", "doScene");
        this.doG = eVar2;
        return a(eVar, this.dFA, this);
    }

    public final String JS() {
        return this.dFB != null ? this.dFB.rjK : "";
    }

    public final int JT() {
        return this.dFB != null ? this.dFB.syR : 0;
    }

    private static aqs JU() {
        try {
            au.HU();
            String str = (String) c.DT().get(67591, null);
            if (str != null) {
                aqs aqs = new aqs();
                String[] split = str.split(",");
                aqs.ryV = Integer.valueOf(split[0]).intValue();
                aqs.ryY = Integer.valueOf(split[1]).intValue();
                aqs.rms = ((float) Integer.valueOf(split[2]).intValue()) / 1000000.0f;
                aqs.rmr = ((float) Integer.valueOf(split[3]).intValue()) / 1000000.0f;
                x.i("MicroMsg.NetSceneWeAppSearch", "lbs location is not null, %f, %f", Float.valueOf(aqs.rms), Float.valueOf(aqs.rmr));
                return aqs;
            }
            x.i("MicroMsg.NetSceneWeAppSearch", "lbs location is null, lbsContent is null!");
            return null;
        } catch (Exception e) {
            x.i("MicroMsg.NetSceneWeAppSearch", "lbs location is null, reason %s", e.getMessage());
            return null;
        }
    }
}
