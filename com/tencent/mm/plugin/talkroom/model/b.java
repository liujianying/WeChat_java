package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.ax.g;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.c;
import com.tencent.mm.network.n;
import java.util.HashMap;

public final class b implements ar {
    private n mHI = new 1(this);
    g ovX;
    private d ovY = new d();
    public c ovZ = new c();
    private e owa;
    f owb;

    public static b bGS() {
        au.HN();
        b bVar = (b) bs.iK("plugin.talkroom");
        if (bVar != null) {
            return bVar;
        }
        bVar = new b();
        au.HN().a("plugin.talkroom", bVar);
        return bVar;
    }

    public static g bGT() {
        if (bGS().ovX == null) {
            bGS().ovX = new g();
        }
        return bGS().ovX;
    }

    public static e bGU() {
        if (bGS().owa == null) {
            bGS().owa = new e();
        }
        return bGS().owa;
    }

    public static String bGV() {
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        return stringBuilder.append(c.Gp()).append("talkroom/").toString();
    }

    public static f bGW() {
        if (bGS().owb == null) {
            bGS().owb = new f();
        }
        return bGS().owb;
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        com.tencent.mm.ab.d.c.a(Integer.valueOf(56), this.ovY);
        au.a(this.mHI);
        g.elf = bGU();
        g.elg = bGT();
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.ab.d.c.b(Integer.valueOf(56), this.ovY);
        au.b(this.mHI);
        g.elf = null;
        g.elg = null;
        if (this.ovX != null) {
            this.ovX.aZL();
            this.ovX = null;
        }
    }
}
