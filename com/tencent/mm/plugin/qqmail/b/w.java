package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.a.e;
import com.tencent.mm.bt.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.a;
import java.io.File;
import java.util.HashMap;

public final class w implements ar {
    private p mdW;
    private b mdX = new b();
    private v mdu;

    private static w bov() {
        au.HN();
        w wVar = (w) bs.iK("plugin.qqmail");
        if (wVar != null) {
            return wVar;
        }
        wVar = new w();
        au.HN().a("plugin.qqmail", wVar);
        return wVar;
    }

    public static p bow() {
        g.Eg().Ds();
        if (bov().mdW == null) {
            bov().mdW = new p(d.qVN, d.DEVICE_TYPE);
        }
        return bov().mdW;
    }

    public static v box() {
        g.Eg().Ds();
        if (bov().mdu == null) {
            bov().mdu = new v();
        }
        return bov().mdu;
    }

    public final void onAccountRelease() {
        p pVar = bov().mdW;
        if (pVar != null) {
            pVar.reset();
        }
        a.sFg.c(this.mdX);
    }

    public final HashMap<Integer, h.d> Ci() {
        return null;
    }

    public final void gi(int i) {
        if ((i & 1) != 0) {
            boy();
        }
    }

    public static void boy() {
        bd.iE("qqmail");
        au.HU();
        c.FW().Yp("qqmail");
        p bow = bow();
        au.HU();
        e.k(new File(c.Gh()));
        bow.reset();
    }

    public final void bn(boolean z) {
        a.sFg.b(this.mdX);
        au.Em().H(new 1(this));
    }

    public final void bo(boolean z) {
    }
}
