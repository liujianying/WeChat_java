package com.tencent.mm.plugin.luckymoney.sns.b;

import com.tencent.mm.kernel.g;

public final class a {
    public static int bbi() {
        g.Ek();
        return ((Integer) g.Ei().DT().get(com.tencent.mm.storage.aa.a.sSG, Integer.valueOf(0))).intValue();
    }

    public static void si(int i) {
        g.Ek();
        g.Ei().DT().a(com.tencent.mm.storage.aa.a.sSG, Integer.valueOf(i));
        g.Ek();
        g.Ei().DT().lm(true);
    }

    public static String bbj() {
        g.Ek();
        return (String) g.Ei().DT().get(com.tencent.mm.storage.aa.a.sSL, "");
    }

    public static String bbk() {
        g.Ek();
        return (String) g.Ei().DT().get(com.tencent.mm.storage.aa.a.sSM, "");
    }
}
