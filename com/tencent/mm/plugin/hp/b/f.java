package com.tencent.mm.plugin.hp.b;

import com.tencent.mm.g.a.d;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tinkerboots.sdk.a;

public final class f extends c<d> {
    private static long bvB = 0;

    public f() {
        this.sFo = d.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (!(((d) bVar).bGd.bGe || au.HM())) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - bvB >= 21600000 && a.cJC() != null) {
                a.cJC().na(false);
                x.i("MicroMsg.Tinker.TinkerBootsActivateListener", "callback post task and fetchPatchUpdate false");
                bvB = currentTimeMillis;
            }
        }
        return false;
    }

    public static void dM(long j) {
        bvB = j;
    }
}
