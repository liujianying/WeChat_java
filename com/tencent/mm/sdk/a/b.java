package com.tencent.mm.sdk.a;

import com.tencent.mm.sdk.platformtools.bj;

public final class b {
    public static boolean foreground = false;
    public static String sFc = "unknow";
    private static c sFd = null;
    private static boolean sFe = false;

    public static void a(c cVar) {
        sFd = cVar;
    }

    public static void A(String str, String str2) {
        if (sFd != null) {
            sFd.A(str, str2);
        }
    }

    public static void l(int i, String str) {
        if (sFd != null) {
            sFd.l(i, str);
        }
    }

    public static void bB(boolean z) {
        foreground = z;
    }

    public static void VV(String str) {
        sFc = str;
    }

    public static void a(a aVar) {
        if (sFd != null) {
            sFd.a(aVar);
        }
    }

    @Deprecated
    public static boolean chn() {
        return bj.chn();
    }

    @Deprecated
    public static void cho() {
        bj.cjg();
    }

    @Deprecated
    public static boolean chp() {
        return bj.cjh();
    }

    @Deprecated
    public static void VW(String str) {
        bj.Xm(str);
    }

    @Deprecated
    public static String chq() {
        return bj.cji();
    }

    public static boolean chr() {
        return sFe;
    }

    public static void ld(boolean z) {
        sFe = z;
    }
}
