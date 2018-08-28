package com.tencent.mm.plugin.appbrand.media.a;

import android.os.Build.VERSION;
import com.tencent.mm.z.d;

public final class f {
    public static d bD(String str, String str2) {
        if ((VERSION.SDK_INT <= 19 ? 1 : null) != null) {
            return new e(str, str2);
        }
        return new d(str, str2);
    }
}
