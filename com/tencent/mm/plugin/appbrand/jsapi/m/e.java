package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.content.res.Configuration;
import com.tencent.mm.bc.a.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    private static String fYq = "";
    private static String fYr = "";
    private static d fYs = new d();
    private static a fYt = a.euN;
    private static a fYu = a.euN;
    private static boolean mEnable = false;

    public static void k(l lVar) {
        fYq = lVar.mAppId;
        mEnable = true;
        fYs.a(lVar);
        if (fYu == a.euN || !fYr.equalsIgnoreCase(fYq)) {
            fYu = a.euN;
        } else {
            fYs.a(fYu);
        }
        x.i("MicroMsg.OrientationConfigListenerHelper", "init mJsAppid:" + fYq + "; mEnable:" + mEnable);
    }

    public static void l(l lVar) {
        if (lVar.mAppId.equalsIgnoreCase(fYq)) {
            x.i("MicroMsg.OrientationConfigListenerHelper", "unInit mAppid:" + fYq);
            fYq = "";
            mEnable = false;
            fYu = a.euN;
        }
    }

    public static void a(Configuration configuration, String str) {
        if (configuration.orientation == 2) {
            if (fYt == a.euR) {
                fYu = a.euR;
            } else {
                fYu = a.euP;
            }
        } else if (configuration.orientation == 1) {
            fYu = a.euO;
        } else {
            fYu = a.euN;
        }
        x.i("MicroMsg.OrientationConfigListenerHelper", "onConfigurationChanged mAppid:" + fYq + "; appid:" + str + "; mOrientation:" + fYu.name());
        if (!fYq.equalsIgnoreCase("") && fYq.equalsIgnoreCase(str) && mEnable) {
            fYs.a(fYu);
        } else {
            fYr = str;
        }
    }

    public static void b(a aVar) {
        fYt = aVar;
        if (!mEnable || fYu != a.euP) {
            return;
        }
        if (aVar == a.euR || aVar == a.euP) {
            fYs.a(aVar);
            x.i("MicroMsg.OrientationConfigListenerHelper", "onFourOrientationsChange mAppid:" + fYq + "; mOrientation:" + aVar.name());
        }
    }
}
