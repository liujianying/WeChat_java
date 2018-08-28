package com.tencent.mm.plugin.appbrand.appusage;

public enum e$c {
    WXAPP(1),
    H5(2);
    
    private int bop;

    private e$c(int i) {
        this.bop = i;
    }

    public static e$c jK(int i) {
        for (e$c e_c : values()) {
            if (i == e_c.bop) {
                return e_c;
            }
        }
        return null;
    }
}
