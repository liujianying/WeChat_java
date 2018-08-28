package com.tencent.tencentmap.mapsdk.a;

import android.os.Build.VERSION;
import com.tencent.map.lib.gl.e;

public class gg {
    public static boolean a(e eVar, boolean z) {
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        eVar.setPreserveEGLContextOnPause(z);
        return true;
    }
}
