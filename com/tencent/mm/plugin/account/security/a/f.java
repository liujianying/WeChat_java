package com.tencent.mm.plugin.account.security.a;

import android.content.Context;
import android.os.Build;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.e;

public final class f {
    public static void n(boolean z, boolean z2) {
        if (g.Eg().Dx()) {
            int GL = q.GL();
            if (z) {
                GL |= 16384;
            } else {
                GL &= -16385;
            }
            g.Ei().DT().set(40, Integer.valueOf(GL));
            if (z2) {
                xt xtVar = new xt();
                xtVar.rDz = 28;
                xtVar.rDA = z ? 1 : 2;
                ((i) g.l(i.class)).FQ().b(new a(23, xtVar));
                com.tencent.mm.plugin.account.a.a.ezo.vl();
            }
        }
    }

    public static String cn(Context context) {
        return context == null ? e.sFF ? ad.getContext().getString(j.safe_device_android_device_nm) : ad.getContext().getString(j.safe_device_android_device) : e.sFF ? context.getString(j.safe_device_android_device_nm) : context.getString(j.safe_device_android_device);
    }

    public static String Yo() {
        return Build.MANUFACTURER + "-" + Build.MODEL;
    }
}
