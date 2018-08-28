package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ac.a.a.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.pluginsdk.model.app.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import java.util.Map;

public final class i implements t {
    public static boolean qyP = false;
    private static i qyQ;
    public a qyR;

    private i() {
    }

    public static i cbs() {
        if (qyQ == null) {
            qyQ = new i();
        }
        return qyQ;
    }

    public final void cbt() {
        if (au.HX()) {
            ao.bmi().a(14, this);
            qyP = true;
        }
    }

    public final void a(int i, int i2, String str, x xVar) {
        if (au.HX()) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.GetUserInfoInAppLogic", "onSceneEnd errType=%s errCode=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (xVar == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.GetUserInfoInAppLogic", "scene == null");
            } else if (i == 0 && i2 == 0) {
                switch (xVar.getType()) {
                    case 14:
                        if (ad.getContext() == null || a.bmm() == null) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.GetUserInfoInAppLogic", "wrong environment");
                            return;
                        }
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.GetUserInfoInAppLogic", "NetSceneGetUserInfoInApp come back", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                        l lVar = (l) xVar;
                        if (this.qyR != null) {
                            this.qyR.a(lVar);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public static b SM(String str) {
        if (str == null) {
            return null;
        }
        Map z = bl.z(str, "PersonalAppSetting");
        if (z == null) {
            return null;
        }
        String str2 = (String) z.get(".PersonalAppSetting.OpenID");
        if (bi.oW(str2)) {
            return null;
        }
        b bVar = new b();
        bVar.qyS = str2;
        return bVar;
    }
}
