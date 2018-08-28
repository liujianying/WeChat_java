package com.tencent.mm.compatible.util;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.bi;

public final class n {
    public static String fi(String str) {
        if (str == null || q.deW.ddJ == 2 || q.deW.ddU == 1) {
            return str;
        }
        if (q.deW.ddJ == 1) {
            if (str.toString().contains("\n")) {
                return str.toString().replace("\n", " ");
            }
            return str;
        } else if (VERSION.SDK_INT == 16 && str.toString().contains("\n") && bi.aG(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) < 0) {
            return str.toString().replace("\n", " ");
        } else {
            return str;
        }
    }
}
