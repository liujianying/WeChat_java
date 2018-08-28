package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aat;
import com.tencent.mm.protocal.c.aau;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class j extends l implements k {
    public b diG;
    private e diJ;

    public j(String str, String str2, Map<String, Object> map) {
        a aVar = new a();
        aVar.dIG = new aat();
        aVar.dIH = new aau();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizjsapiredirecturl";
        aVar.dIF = 1393;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aat aat = (aat) this.diG.dID.dIL;
        aat.ruF = str;
        aat.rki = str2;
        aat.rFZ = (String) map.get("groupId");
        aat.pnl = (String) map.get("timestamp");
        aat.hFm = (String) map.get("nonceStr");
        aat.signature = (String) map.get("signature");
        aat.rGa = map.get("params").toString();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1393;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "do scene");
        return a(eVar, this.diG, this);
    }

    public final aau bTX() {
        if (this.diG == null || this.diG.dIE.dIL == null) {
            return null;
        }
        return (aau) this.diG.dIE.dIL;
    }
}
