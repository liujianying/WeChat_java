package com.tencent.mm.plugin.game.gamewebview.model;

import java.util.HashMap;

public final class b {
    private static HashMap<String, String> jHY = new HashMap();

    public static void cV(String str, String str2) {
        jHY.put(str, str2);
    }

    public static String Dg(String str) {
        return (String) jHY.get(str);
    }

    public static void Dh(String str) {
        jHY.remove(str);
    }
}
