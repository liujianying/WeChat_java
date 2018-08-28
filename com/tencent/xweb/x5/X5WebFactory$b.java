package com.tencent.xweb.x5;

import android.content.Context;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.xweb.WebView.c;
import org.xwalk.core.Log;

class X5WebFactory$b {
    private static boolean iEe = false;
    private static boolean vDO = false;

    public static boolean hasInited() {
        return iEe;
    }

    public static boolean isCoreReady() {
        return vDO;
    }

    public static void a(Context context, c cVar) {
        if (!iEe) {
            Log.i("X5WebFactory.preIniter", "preInit");
            iEe = true;
            QbSdk.preInit(context, new 1(cVar));
        }
    }
}
