package com.tencent.mm.ax;

import android.content.Context;
import com.tencent.mm.ay.d;
import com.tencent.mm.g.a.jr;
import com.tencent.mm.p.a;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.ui.widget.a.c;

public final class e {
    public static boolean bw(Context context) {
        return a.bw(context);
    }

    public static boolean Sz() {
        jr jrVar = new jr();
        jrVar.bTt.action = 2;
        com.tencent.mm.sdk.b.a.sFg.m(jrVar);
        return jrVar.bTu.bTv;
    }

    public static boolean SA() {
        return d.elh != null && d.elh.SB();
    }

    public static c a(Context context, int i, Runnable runnable) {
        c.a aVar = new c.a(context);
        aVar.Gq(h.app_tip);
        aVar.Gr(i);
        aVar.Gt(h.app_i_known).a(new 1(runnable));
        aVar.mF(true);
        aVar.e(new 2(runnable));
        c anj = aVar.anj();
        anj.show();
        return anj;
    }
}
