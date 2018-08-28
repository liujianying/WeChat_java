package com.tencent.mm.plugin.masssend.a;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.model.c;
import java.util.HashMap;

public final class h implements ar {
    private static HashMap<Integer, d> cVM;
    private a kYi = new 2(this);
    private b las;
    private c lau;
    private i lav = new i();
    private g law = new g();

    private static h bcn() {
        au.HN();
        h hVar = (h) bs.iK("plugin.masssend");
        if (hVar != null) {
            return hVar;
        }
        hVar = new h();
        au.HN().a("plugin.favorite", hVar);
        return hVar;
    }

    public static b bco() {
        g.Eg().Ds();
        if (bcn().las == null) {
            h bcn = bcn();
            au.HU();
            bcn.las = new b(c.FO());
        }
        return bcn().las;
    }

    public static c bcp() {
        if (bcn().lau == null) {
            bcn().lau = new c();
        }
        return bcn().lau;
    }

    public final void onAccountRelease() {
        au.getSysCmdMsgExtension().b("masssendapp", this.kYi, false);
        com.tencent.mm.sdk.b.a.sFg.c(this.lav);
        com.tencent.mm.sdk.b.a.sFg.c(this.law);
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("MASSENDINFO_TABLE".hashCode()), new 1());
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        au.getSysCmdMsgExtension().a("masssendapp", this.kYi, false);
        com.tencent.mm.sdk.b.a.sFg.b(this.lav);
        com.tencent.mm.sdk.b.a.sFg.b(this.law);
    }

    public final void bo(boolean z) {
    }
}
