package com.tencent.mm.modelappbrand;

import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class s {
    private static Map<String, Long> dFE = new HashMap();
    private static Map<String, Long> dFF = new HashMap();
    private static Map<String, Long> dFG = new HashMap();
    private static Map<String, Long> dFH = new HashMap();

    public static void i(String str, String str2, Object... objArr) {
        x.i("SearchWidgetStartTrace", "widget trace - " + str + "-" + str2, objArr);
    }

    public static void jo(String str) {
        x.i("SearchWidgetStartTrace", "recv rsp widget %s", new Object[]{str});
        dFE.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public static void jp(String str) {
        x.i("SearchWidgetStartTrace", "jsapiInsertWidget %s", new Object[]{str});
    }

    public static void jq(String str) {
        x.i("SearchWidgetStartTrace", "realInsert %s", new Object[]{str});
    }

    public static void z(String str, boolean z) {
        x.i("SearchWidgetStartTrace", "drawEnd %s,succ %s", new Object[]{str, Boolean.valueOf(z)});
        if (z) {
            if ((dFE.containsKey(str) ? ((Long) dFE.get(str)).longValue() : 0) > 0) {
                System.currentTimeMillis();
            } else {
                x.e("SearchWidgetStartTrace", "can't find widget Recv timestamp for appid %s", new Object[]{str});
            }
        }
    }

    public static void JW() {
        x.i("SearchWidgetStartTrace", "hasInitData %s", new Object[]{Boolean.valueOf(true)});
    }
}
