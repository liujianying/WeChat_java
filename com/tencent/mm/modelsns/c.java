package com.tencent.mm.modelsns;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public static int ehb = 0;
    public static c ehc = new c();

    public static void RE() {
        com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100024");
        x.i("MicroMsg.StatisticsOplogAbTest", "test " + fJ.field_rawXML + " " + fJ.isValid());
        if (fJ.isValid()) {
            ehb = bi.WU((String) fJ.ckq().get("Switch"));
            x.i("MicroMsg.StatisticsOplogAbTest", "switchVal " + ehb);
        }
    }
}
