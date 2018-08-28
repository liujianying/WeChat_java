package com.tencent.xweb.xwalk;

import android.content.Context;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.WebViewExtensionListener;

class XWalkWebFactory$a {
    private static boolean iEe = false;
    private static boolean vCW = false;
    private static boolean vDO = false;

    public static boolean hasInited() {
        return iEe;
    }

    public static boolean hasInitedCallback() {
        return vCW;
    }

    public static boolean isCoreReady() {
        return vDO;
    }

    public static boolean io(Context context) {
        if (iEe) {
            return iEe;
        }
        Log.i("XWebViewHelper", "preInit");
        if (h.eM(context)) {
            Log.i("XWebViewHelper", "preInit finished");
            iEe = true;
            vDO = true;
        } else {
            Log.i("XWebViewHelper", "preInit xwalk is not available");
        }
        return iEe;
    }

    public static void initCallback(WebViewExtensionListener webViewExtensionListener) {
        if (!vCW) {
            Log.i("XWebViewHelper", "initCallback");
            WebViewExtension.SetExtension(webViewExtensionListener);
            vCW = true;
        }
    }
}
