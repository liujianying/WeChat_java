package com.tencent.mm.wallet_core.c;

import java.util.UUID;

public final class p {
    private static boolean uXr = false;
    private static int uXs = -1;
    private static String uXt = "";

    public static boolean cDb() {
        return uXr;
    }

    public static int cDc() {
        return uXs;
    }

    public static String cDd() {
        return uXt;
    }

    public static void GZ(int i) {
        if (!uXr) {
            uXr = true;
            uXs = i;
            uXt = UUID.randomUUID().toString();
        }
    }

    public static void cDe() {
        uXr = false;
        uXs = -1;
        uXt = "";
    }
}
