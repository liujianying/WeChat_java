package com.tencent.mm.plugin.wallet_core.model;

public enum m$a {
    ;

    static {
        pou = 1;
        pov = 2;
        pow = 3;
        pox = new int[]{pou, pov, pow};
    }

    public static int[] bOQ() {
        return (int[]) pox.clone();
    }
}
