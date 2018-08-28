package com.tencent.mm.bf;

import android.os.Build.VERSION;
import com.tencent.mm.w.a.f;

public final class a {
    public static int cbg() {
        if (VERSION.SDK_INT < 19) {
            return f.notification_icon;
        }
        return f.notification_icon_gray;
    }
}
