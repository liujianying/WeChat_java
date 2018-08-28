package com.tencent.mm.modelappbrand;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.g.a.hx;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.b;
import com.tencent.mm.protocal.c.cde;
import com.tencent.mm.protocal.c.cdf;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

public final class p extends b implements k {
    private com.tencent.mm.ab.b dFA;
    private cdf dFD;
    private e doG;

    public p(String str, int i, int i2) {
        this.fur = str;
        this.fdx = i;
        this.pKL = i2;
        if (bi.oW(str)) {
            x.e("MicroMsg.NetSceneWeAppSuggest", "keyword is unavailable");
            return;
        }
        x.i("MicroMsg.NetSceneWeAppSuggest", "Constructors: query = %s", str);
        a aVar = new a();
        aVar.dIF = 1173;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchsuggestion";
        aVar.dIG = new cde();
        aVar.dIH = new cdf();
        this.dFA = aVar.KT();
        cde cde = (cde) this.dFA.dID.dIL;
        cde.bWm = str;
        com.tencent.mm.sdk.b.b hxVar = new hx();
        com.tencent.mm.sdk.b.a.sFg.m(hxVar);
        cde.syH = hxVar.bRs.bRt;
        au.HU();
        Object obj = c.DT().get(aa.a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_ID_STRING_SYNC, null);
        if (obj != null && (obj instanceof String)) {
            cde.syS = (String) obj;
        }
        cde.syL = b.dFw;
        cde.syM = b.dFx;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneWeAppSuggest", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.dFD = (cdf) this.dFA.dIE.dIL;
            if (this.dFD != null) {
                x.v("MicroMsg.NetSceneWeAppSuggest", "return data\n%s", this.dFD.rjK);
            }
            this.doG.a(i2, i3, str, this);
            return;
        }
        this.doG.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1173;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.doG = eVar2;
        return a(eVar, this.dFA, this);
    }

    public final String JS() {
        return this.dFD != null ? this.dFD.rjK : "";
    }
}
