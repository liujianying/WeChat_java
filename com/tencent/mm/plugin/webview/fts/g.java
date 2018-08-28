package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.b;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.protocal.c.cfo;
import com.tencent.mm.protocal.c.cfp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.LinkedList;
import org.json.JSONArray;

public final class g extends b implements k {
    j dFC;
    private com.tencent.mm.ab.b dZf;
    private e diJ;
    private cfp pOX;

    public g(j jVar) {
        this.dFC = jVar;
        this.fur = jVar.bHt;
        this.fdx = jVar.scene;
        this.pKL = jVar.bWo;
        if (bi.oW(jVar.bHt)) {
            x.e("MicroMsg.FTS.NetSceneWebSuggest", "keyword is unavailable");
            return;
        }
        x.i("MicroMsg.FTS.NetSceneWebSuggest", "Constructors: query=%s", new Object[]{jVar.bHt});
        a aVar = new a();
        aVar.dIF = 1161;
        aVar.uri = "/cgi-bin/mmsearch-bin/searchsuggestion";
        aVar.dIG = new cfo();
        aVar.dIH = new cfp();
        this.dZf = aVar.KT();
        cfo cfo = (cfo) this.dZf.dID.dIL;
        cfo.rDH = jVar.bHt;
        cfo.rll = (long) jVar.iPZ;
        cfo.syH = p.zP(0);
        cfo.shN = jVar.pKO;
        cfo.rUI = p.JU();
        cfo.otY = jVar.scene;
        cfo.syL = jVar.bJK;
        if (jVar.pLd != null) {
            try {
                cfo.sAd = new com.tencent.mm.bk.b(jVar.pLd.toByteArray());
            } catch (Exception e) {
            }
        }
        if (jVar.pLc != null) {
            try {
                cfo.sAc = new com.tencent.mm.bk.b(jVar.pLc.toByteArray());
            } catch (IOException e2) {
            }
        }
        try {
            JSONArray jSONArray = new JSONArray(jVar.pKU);
            cfo.sAa = new LinkedList();
            for (int i = 0; i < jSONArray.length(); i++) {
                cfo.sAa.add(URLDecoder.decode(jSONArray.getString(i), "UTF-8"));
            }
        } catch (Throwable e3) {
            x.printErrStackTrace("MicroMsg.FTS.NetSceneWebSuggest", e3, "decode json error", new Object[0]);
        }
        String str = "MicroMsg.FTS.NetSceneWebSuggest";
        String str2 = "businessTypeList is %d | contains location = %b | scene=%d | businessType=%d | isHomePage=%b | webViewId=%d";
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(jVar.iPZ);
        objArr[1] = Boolean.valueOf(cfo.rUI != null);
        objArr[2] = Integer.valueOf(jVar.scene);
        objArr[3] = Integer.valueOf(jVar.iPZ);
        objArr[4] = Integer.valueOf(jVar.pKO);
        objArr[5] = Integer.valueOf(jVar.bWo);
        x.i(str, str2, objArr);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.FTS.NetSceneWebSuggest", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.pOX = (cfp) this.dZf.dIE.dIL;
            if (this.pOX != null) {
                x.v("MicroMsg.FTS.NetSceneWebSuggest", "return data\n%s", new Object[]{this.pOX.rjK});
            }
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1161;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }

    public final String JS() {
        return this.pOX != null ? this.pOX.rjK : "";
    }
}
