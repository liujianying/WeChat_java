package com.tencent.mm.booter;

import com.tencent.mm.a.h;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;

public final class j {
    public static void run() {
        int i = g.AT().getInt("EnableForgroundService", 0);
        au.HU();
        int aM = h.aM(c.Df(), 101);
        boolean z = b.chp() || (i > 0 && aM >= 0 && aM <= i);
        if (!z) {
            z = d.qVQ;
        }
        if (!z) {
            z = b.chp();
        }
        if (e.bxk == 1) {
            z = false;
        }
        ad.getContext().getSharedPreferences("system_config_prefs", 0).edit().putBoolean("set_service", z).commit();
        x.i("MicroMsg.PostTaskSetPushForegroundService", "Set service, userHash:%d, prob:%d, enabled: %b  isalpha:%b channel:%d", new Object[]{Integer.valueOf(aM), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(d.qVQ), Integer.valueOf(e.bxk)});
    }
}
