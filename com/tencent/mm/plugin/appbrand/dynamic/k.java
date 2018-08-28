package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class k {
    private static final Map<String, WxaWidgetContext> fuR = new ConcurrentHashMap();

    public static boolean a(String str, WxaWidgetContext wxaWidgetContext) {
        if (bi.oW(str) || wxaWidgetContext == null) {
            return false;
        }
        fuR.put(str, wxaWidgetContext);
        return true;
    }

    public static WxaWidgetContext sA(String str) {
        if (bi.oW(str)) {
            return null;
        }
        return (WxaWidgetContext) fuR.get(str);
    }

    public static WxaWidgetContext sB(String str) {
        if (bi.oW(str)) {
            return null;
        }
        return (WxaWidgetContext) fuR.remove(str);
    }
}
