package com.tencent.mm.modelappbrand;

import android.os.Bundle;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.c;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static boolean jh(String str) {
        if (bi.oW(str)) {
            return false;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("BindWxaInfo");
            if (optJSONObject == null || optJSONObject.optInt("openWxaByBizQRCode", 0) <= 0) {
                return false;
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    private static void a(qu quVar, com.tencent.mm.y.g.a aVar) {
        quVar.cbq.appId = aVar.dyT;
        quVar.cbq.userName = aVar.dyS;
        quVar.cbq.cbs = aVar.dyR;
        quVar.cbq.cbt = aVar.dyZ;
        quVar.cbq.cbw = aVar.dyV;
        quVar.cbq.cbu = aVar.dza;
        quVar.cbq.cbx = aVar.dyZ != 0;
    }

    public static void a(String str, String str2, boolean z, com.tencent.mm.y.g.a aVar, Bundle bundle) {
        qu quVar = new qu();
        a(quVar, aVar);
        quVar.cbq.scene = z ? 1008 : 1007;
        quVar.cbq.bGG = str + (z ? ":" + str2 : "") + ":" + aVar.dyX;
        quVar.cbq.bJx = bundle;
        com.tencent.mm.sdk.b.a.sFg.m(quVar);
    }

    public static void a(String str, int i, com.tencent.mm.y.g.a aVar, Bundle bundle) {
        qu quVar = new qu();
        a(quVar, aVar);
        quVar.cbq.scene = i;
        if (i == 1074) {
            quVar.cbq.bGG = str;
        }
        quVar.cbq.bJx = bundle;
        com.tencent.mm.sdk.b.a.sFg.m(quVar);
    }

    public static void b(String str, String str2, boolean z, com.tencent.mm.y.g.a aVar, Bundle bundle) {
        qu quVar = new qu();
        a(quVar, aVar);
        quVar.cbq.scene = 1044;
        quVar.cbq.bGG = aVar.dyX;
        quVar.cbq.cbB = z ? 2 : 1;
        com.tencent.mm.g.a.qu.a aVar2 = quVar.cbq;
        if (z) {
            str2 = str;
        }
        aVar2.cbC = str2;
        quVar.cbq.cbz.dzR = aVar.dyY;
        if (bi.oW(aVar.dyY)) {
            quVar.cbq.cbz.dFy = null;
        } else {
            quVar.cbq.cbz.dFy = str;
        }
        quVar.cbq.bJx = bundle;
        com.tencent.mm.sdk.b.a.sFg.m(quVar);
    }

    public static boolean JJ() {
        if (!g.Eg().Dx()) {
            return false;
        }
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100360");
        if (fJ.isValid() && "1".equals(fJ.ckq().get("isOpenFTSSearchMiniGameEntry"))) {
            return true;
        }
        return false;
    }
}
