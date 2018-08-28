package com.tencent.mm.ac;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aav;
import com.tencent.mm.protocal.c.aaw;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class t extends l implements k {
    private Object data;
    public b diG;
    private e diJ;

    public static void a(e eVar) {
        g.Eh().dpP.b(1285, eVar);
    }

    public static boolean m(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("brand_user_name", str2);
            jSONObject.put("bizchat_id", str3);
            return g.Eh().dpP.a(new t(str, jSONObject.toString()), 0);
        } catch (Exception e) {
            return false;
        }
    }

    private t(String str, String str2) {
        a aVar = new a();
        aVar.dIG = new aav();
        aVar.dIH = new aaw();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizjsapiresult";
        aVar.dIF = 1285;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aav aav = (aav) this.diG.dID.dIL;
        aav.ruF = str;
        aav.nc = 1;
        aav.data = str2;
        this.data = null;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetBizJsApiResult", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1285;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.NetSceneGetBizJsApiResult", "do scene");
        return a(eVar, this.diG, this);
    }
}
