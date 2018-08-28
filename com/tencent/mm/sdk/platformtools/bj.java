package com.tencent.mm.sdk.platformtools;

public final class bj {
    private static boolean sJH = false;
    private static String sJI = null;
    private static boolean sJJ = false;

    public static void lj(boolean z) {
        sJJ = z;
    }

    public static boolean chn() {
        return sJJ;
    }

    public static void cjg() {
        sJH = true;
    }

    public static boolean cjh() {
        return sJH;
    }

    public static void Xm(String str) {
        sJI = str;
    }

    public static String cji() {
        return sJI;
    }
}
