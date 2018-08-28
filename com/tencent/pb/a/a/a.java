package com.tencent.pb.a.a;

import com.tencent.pb.common.c.g;

public final class a {
    private static String TAG = "AccountEngine";
    private static int vgk = 0;
    private static String vgl = "";

    public static String cEG() {
        return vgl;
    }

    public static void aci(String str) {
        if (str == null) {
            str = "";
        }
        vgl = str;
    }

    public static void Hi(int i) {
        vgk = i;
    }

    public static boolean cEH() {
        return !g.isEmpty(vgl);
    }
}
