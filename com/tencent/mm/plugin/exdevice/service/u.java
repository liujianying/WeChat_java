package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.plugin.exdevice.model.c;

public final class u {
    private static u iyO = null;
    private c iyP;
    private f iyQ;

    private static u aHE() {
        if (iyO == null) {
            iyO = new u();
        }
        return iyO;
    }

    public static f aHF() {
        if (aHE().iyQ == null) {
            aHE().iyQ = new f();
        }
        return aHE().iyQ;
    }

    public static void a(m mVar) {
        aHG().isY = mVar;
    }

    public static c aHG() {
        if (aHE().iyP == null) {
            u aHE = aHE();
            if (c.isX == null) {
                c.isX = new c();
            }
            aHE.iyP = c.isX;
        }
        return aHE().iyP;
    }
}
