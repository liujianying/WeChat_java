package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.DexLoader;

public class TbsVideoUtils {
    private static bg a = null;

    private static void a(Context context) {
        DexLoader dexLoader = null;
        synchronized (TbsVideoUtils.class) {
            if (a == null) {
                o.a(true).a(context, false, false, null);
                bi a = o.a(true).a();
                if (a != null) {
                    dexLoader = a.b();
                }
                if (dexLoader != null) {
                    a = new bg(dexLoader);
                }
            }
        }
    }

    public static void deleteVideoCache(Context context, String str) {
        a(context);
        if (a != null) {
            a.a(context, str);
        }
    }

    public static String getCurWDPDecodeType(Context context) {
        a(context);
        return a != null ? a.a(context) : "";
    }
}
