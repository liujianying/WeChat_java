package com.tencent.mm.app;

import android.content.SharedPreferences;
import com.tencent.mm.app.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class a$c$1 implements Runnable {
    final /* synthetic */ c bxY;

    a$c$1(c cVar) {
        this.bxY = cVar;
    }

    public final void run() {
        this.bxY.bxW = (this.bxY.bxW + 1) % Integer.MAX_VALUE;
        if (this.bxY.bxW % a.bxN == 0) {
            SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("system_config_prefs", 4);
            int i = sharedPreferences.getInt("main_thread_watch_enable", 65535);
            int i2 = sharedPreferences.getInt("main_thread_watch_timeout", 0);
            int i3 = sharedPreferences.getInt("main_thread_watch_log_loop", 0);
            int i4 = sharedPreferences.getInt("main_thread_watch_report", 0);
            x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ticker tname[%s], tick[%d] enable[%d], timeout[%d], loop[%d], report[%d]", new Object[]{Thread.currentThread().getName(), Integer.valueOf(this.bxY.bxW), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            if (a.p(a.bqA, i)) {
                if (i2 > 0 && i2 != a.bxM) {
                    x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr reset timeout[%d, %d] by new setting", new Object[]{Integer.valueOf(a.bxM), Integer.valueOf(i2)});
                    a.bxM = i2;
                }
                if (i3 > 0 && i3 != a.bxN) {
                    x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr reset loop[%d, %d] by new setting", new Object[]{Integer.valueOf(a.bxN), Integer.valueOf(i3)});
                    a.bxN = i3;
                    return;
                }
                return;
            }
            h.mEJ.a(510, 12, 1, true);
            if (a.bxR != null) {
                a.bxR.interrupt();
            }
            x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr disable by new setting and interrupt watch");
        }
    }
}
