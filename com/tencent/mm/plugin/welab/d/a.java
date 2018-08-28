package com.tencent.mm.plugin.welab.d;

import android.app.Activity;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.g.c.ci;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.plugin.welab.a.a.d;

public final class a implements b {
    public final void e(Activity activity, String str) {
        ci RU = ((d) g.l(d.class)).RU(str);
        qu quVar = new qu();
        quVar.cbq.userName = RU.field_WeAppUser;
        quVar.cbq.cbs = RU.field_WeAppPath;
        quVar.cbq.scene = 1051;
        quVar.cbq.cbt = RU.field_WeAppDebugMode;
        quVar.cbq.bGG = String.format("%s:%s:%s:%s", new Object[]{(String) g.Ei().DT().get(2, null), RU.field_expId, RU.field_LabsAppId, Long.valueOf(System.currentTimeMillis() / 1000)});
        com.tencent.mm.sdk.b.a.sFg.m(quVar);
    }

    public final String bYQ() {
        return null;
    }

    public final String bYR() {
        return null;
    }
}
