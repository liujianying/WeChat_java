package com.tencent.mm.bz;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;

public final class a {
    public static boolean hi(Context context) {
        if (!WebView.isX5() || WebView.getUsingTbsCoreVersion(context) > 36541) {
            return true;
        }
        x.i("XWebUtil", "lower version of x5 not support source type ");
        return false;
    }
}
