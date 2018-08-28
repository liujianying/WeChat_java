package com.tencent.mm.plugin.appbrand.appusage;

public enum e$a {
    FORCE_OFF(0),
    FORCE_ON(1);
    
    int bop;

    private e$a(int i) {
        this.bop = i;
    }

    public static e$a jJ(int i) {
        for (e$a e_a : values()) {
            if (e_a.bop == i) {
                return e_a;
            }
        }
        return null;
    }
}
