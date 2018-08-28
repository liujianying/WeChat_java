package com.tencent.mm.plugin.appbrand.dynamic.b;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e {
    private static volatile e fvz;
    private Map<String, SoftReference<WxaPkgWrappingInfo>> dmW = new ConcurrentHashMap();

    private static e afh() {
        if (fvz == null) {
            synchronized (e.class) {
                if (fvz == null) {
                    fvz = new e();
                }
            }
        }
        return fvz;
    }

    private e() {
    }

    public static boolean a(String str, WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        if (str == null || str.length() == 0 || wxaPkgWrappingInfo == null) {
            return false;
        }
        afh().dmW.put(str, new SoftReference(wxaPkgWrappingInfo));
        return true;
    }

    public static WxaPkgWrappingInfo sC(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        SoftReference softReference = (SoftReference) afh().dmW.get(str);
        return softReference != null ? (WxaPkgWrappingInfo) softReference.get() : null;
    }

    public static void removeAll() {
        afh().dmW.clear();
    }
}
