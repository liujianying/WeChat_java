package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;

public final class be {
    private static final HashMap<String, String> sJg = new HashMap();

    public static String getProperty(String str) {
        return (String) sJg.get(str);
    }

    public static void setProperty(String str, String str2) {
        sJg.put(str, str2);
    }
}
