package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import com.tencent.mm.bp.a;

public final class b {
    public static int gbS = 18;
    public static int gbT = 10;
    private static int gbU = 3;

    public static float cB(Context context) {
        return ((float) a.fromDPToPix(context, gbS)) * 2.0f;
    }

    public static int y(Context context, int i) {
        return a.fromDPToPix(context, i);
    }

    public static int akf() {
        return gbU;
    }
}
